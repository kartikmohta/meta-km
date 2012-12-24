DESCRIPTION = "ROS is an open-source, meta-operating system for your robot."
LICENSE = "BSD"
HOMEPAGE = "http://www.ros.org/"

DEPENDS = "apr apr-util log4cxx boost python-pyyaml-native chrpath-native"
RDEPENDS_${PN} += "boost-dev cmake log4cxx-dev make python python-compression python-crypt python-datetime python-distutils python-logging python-misc python-netclient python-pyyaml python-shell python-stringold python-subprocess python-textutils python-threading python-xml python-xmlrpc tar"

S = "${WORKDIR}/${PV}"


do_compile_prepend() {
  export ROS_ROOT=$(dirname $(which rospack))/..
  if [ ! -x ${ROS_ROOT}/bin/rospack ]; then
    oefatal ROS not found in PATH
  fi
}

do_install_prepend() {
  export ROS_ROOT=$(dirname $(which rospack))/..
  export ROS_ROOT=${ROS_ROOT}
  export PYTHONPATH=${ROS_ROOT}/core/roslib/src:${PYTHONPATH}
  if [ ! -x ${ROS_ROOT}/bin/rospack ]; then
    oefatal ROS not found in PATH
  fi
}

# From cmake.bbclass
do_generate_toolchain_file() {
    # CMake system name must be something like "Linux".
    # This is important for cross-compiling.
    echo "set( CMAKE_SYSTEM_NAME" `echo ${SDK_OS} | sed 's/^./\u&/'` ")" > ${WORKDIR}/rostoolchain.cmake
    echo "set( CMAKE_SYSTEM_PROCESSOR ${TARGET_ARCH} )" >> ${WORKDIR}/rostoolchain.cmake
    echo "set( CMAKE_C_COMPILER `echo ${CC} | sed 's/^\([^ ]*\).*/\1/'` )" >> ${WORKDIR}/rostoolchain.cmake
    echo "set( CMAKE_CXX_COMPILER `echo ${CXX} | sed 's/^\([^ ]*\).*/\1/'` )" >> ${WORKDIR}/rostoolchain.cmake
    echo "set( CMAKE_C_FLAGS \"${HOST_CC_ARCH} ${TOOLCHAIN_OPTIONS} ${TARGET_CPPFLAGS}\" CACHE STRING \"OpenEmbedded CFLAGS\" )" >> ${WORKDIR}/rostoolchain.cmake
    echo "set( CMAKE_CXX_FLAGS \"${HOST_CC_ARCH} ${TOOLCHAIN_OPTIONS} ${TARGET_CPPFLAGS} -fpermissive\" CACHE STRING \"OpenEmbedded CXXFLAGS\" )" >> ${WORKDIR}/rostoolchain.cmake
    #echo "set( CMAKE_C_FLAGS_RELEASE \"${SELECTED_OPTIMIZATION} -DNDEBUG\" CACHE STRING \"CFLAGS for release\" )" >> ${WORKDIR}/rostoolchain.cmake
    #echo "set( CMAKE_CXX_FLAGS_RELEASE \"${SELECTED_OPTIMIZATION} -DNDEBUG\" CACHE STRING \"CXXFLAGS for release\" )" >> ${WORKDIR}/rostoolchain.cmake

    # only search in the paths provided (from openembedded) so cmake doesnt pick
    # up libraries and tools from the native build machine
    #echo "set( CMAKE_FIND_ROOT_PATH ${STAGING_DIR_HOST} ${STAGING_DIR_NATIVE} ${STAGING_DIR_NATIVE}${prefix_native}/${BASE_PACKAGE_ARCH} )" >> ${WORKDIR}/rostoolchain.cmake
    echo "set( CMAKE_FIND_ROOT_PATH ${STAGING_DIR_HOST} )" >> ${WORKDIR}/rostoolchain.cmake
    echo "set( CMAKE_FIND_ROOT_PATH_MODE_PROGRAM NEVER )" >> ${WORKDIR}/rostoolchain.cmake
    echo "set( CMAKE_FIND_ROOT_PATH_MODE_LIBRARY ONLY )" >> ${WORKDIR}/rostoolchain.cmake
    echo "set( CMAKE_FIND_ROOT_PATH_MODE_INCLUDE ONLY )" >> ${WORKDIR}/rostoolchain.cmake
    # Use native cmake modules
    echo "set( CMAKE_MODULE_PATH ${STAGING_DIR_NATIVE}/usr/share/cmake-2.8/Modules/ )" >> ${WORKDIR}/rostoolchain.cmake
}

addtask generate_toolchain_file after do_patch before do_configure

INSANE_SKIP_${PN} += "dev-deps"
