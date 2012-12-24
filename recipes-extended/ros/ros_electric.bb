require ros.inc
LIC_FILES_CHKSUM = "file://ros/LICENSE/roscheck/BSD-Willow.txt;md5=51a25bf2b127f8eb390aa2c2d5ca028d"

DEPENDS += "libtinyxml eigen cppunit python-sip python-sip-native yaml-cpp"
RDEPENDS_${PN} += "libtinyxml-dev eigen-dev"

PR = "r5"

SRC_URI = "https://code.ros.org/svn/release/download/stacks/ros/ros-1.6.9/ros-1.6.9.tar.bz2;name=ros \
    https://code.ros.org/svn/release/download/stacks/ros_comm/ros_comm-1.6.7/ros_comm-1.6.7.tar.bz2;name=ros_comm \
    https://code.ros.org/svn/release/download/stacks/common_rosdeps/common_rosdeps-1.0.2/common_rosdeps-1.0.2.tar.bz2;name=common_rosdeps \
    https://code.ros.org/svn/release/download/stacks/bond_core/bond_core-1.6.1/bond_core-1.6.1.tar.bz2;name=bond_core \
    https://code.ros.org/svn/release/download/stacks/common_msgs/common_msgs-1.6.0/common_msgs-1.6.0.tar.bz2;name=common_msgs \
    https://code.ros.org/svn/release/download/stacks/common/common-1.6.1/common-1.6.1.tar.bz2;name=common \
    https://code.ros.org/svn/release/download/stacks/driver_common/driver_common-1.2.4/driver_common-1.2.4.tar.bz2;name=driver_common \
    https://code.ros.org/svn/release/download/stacks/eigen/eigen-1.6.0/eigen-1.6.0.tar.bz2;name=eigen \
    https://code.ros.org/svn/release/download/stacks/filters/filters-1.6.0/filters-1.6.0.tar.bz2;name=filters \
    https://code.ros.org/svn/release/download/stacks/bullet/bullet-2.76.5/bullet-2.76.5.tar.bz2;name=bullet \
    https://code.ros.org/svn/release/download/stacks/geometry/geometry-1.6.1/geometry-1.6.1.tar.bz2;name=geometry\
    https://code.ros.org/svn/release/download/stacks/nodelet_core/nodelet_core-1.6.2/nodelet_core-1.6.2.tar.bz2;name=nodelet_core \
    https://code.ros.org/svn/release/download/stacks/orocos_kinematics_dynamics/orocos_kinematics_dynamics-0.2.3/orocos_kinematics_dynamics-0.2.3.tar.bz2;name=orocos_kinematics_dynamics \
    https://code.ros.org/svn/release/download/stacks/pluginlib/pluginlib-1.6.0/pluginlib-1.6.0.tar.bz2;name=pluginlib \
    https://code.ros.org/svn/release/download/stacks/image_common/image_common-1.6.1/image_common-1.6.1.tar.bz2;name=image_common \
    file://serialization_memcpy_instead_of_reinterpret.patch \
    file://bullet-no-demos.patch \
    file://python-orocos-kdl-cmake-findsip.patch \
    file://rosboost_cfg.patch \
    file://rosbuild_private.cmake.patch \
    file://roscpp_use_tcpnodelay.patch \
    file://orocos_kdl-add-rostoolchain.patch \
    file://rosbag_recorder_boost_time_utc.patch \
    file://rosbag_record_boost_system_link.patch \
    file://rostime_boost_system_link.patch \
    file://image_transport_publisher_boost_foreach.patch \
    file://tf_boost_system_link.patch \
    file://fixrpath.py \
    file://setup-env.sh \
    file://bash_profile \
    file://rosconfig.cmake \
"
SRC_URI[ros.md5sum] = "496f78e3e4272bcbc5a67df5acc81cc0"
SRC_URI[ros.sha256sum] = "5ed9fe4468561bf9d9265d4bac08a732916b31b5977ca747babc82d6bf53f2dd"
SRC_URI[ros_comm.md5sum] = "afd8905643da8c7ea0e5a588cc76185e"
SRC_URI[ros_comm.sha256sum] = "b36b307d6445817da848e0124d37108ce5f276f18b4ecae5937b5f7e856d14f8"
SRC_URI[common_rosdeps.md5sum] = "aed24f5418484a472604c0f07da2f54b"
SRC_URI[common_rosdeps.sha256sum] = "a0193ef77585a810dfaa158e1190a158d6099a79866939960aff0c725e084569"
SRC_URI[bond_core.md5sum] = "6eae6aaf440a08d1a32f1f5651f2a8ca"
SRC_URI[bond_core.sha256sum] = "2162b5c34aa7e0dc6ed3b03e1faefad88431ad8ffb8d19fed217ed6750836037"
SRC_URI[common_msgs.md5sum] = "73afcc811737e813692b545d88f86817"
SRC_URI[common_msgs.sha256sum] = "6b7fbcc5f11c92dfb2ece3b0757b6ea8c65c5d5bd920dc7d35de1d7fa096ce0a"
SRC_URI[common.md5sum] = "00e8e4a8f33537ed892f74bb12819fce"
SRC_URI[common.sha256sum] = "759f76c9645028cc95b4d08acf471d2a0fea161f4416566e889c3ca8c045d0e7"
SRC_URI[driver_common.md5sum] = "b5509d0399385723ec7929fe02fdb5d4"
SRC_URI[driver_common.sha256sum] = "367cd4acfe2c748360f110cc3ad7157a9aa1a008db527624cd03d03764c2edf0"
SRC_URI[eigen.md5sum] = "6a32372b575ab4133ec97c28c33a3067"
SRC_URI[eigen.sha256sum] = "2c8c351b5d0b8b2d1ae65a68a50eaaba96f6c0f8264d3991e500bffe8fa49661"
SRC_URI[filters.md5sum] = "0113542399807efd2de0dd7bdafd2400"
SRC_URI[filters.sha256sum] = "f6ec3d317458731fb99b563c51b787ca0c6c81d6f6aae392197019d9acac8930"
SRC_URI[bullet.md5sum] = "59b8a2f1e492be82684c2eac9d7d2264"
SRC_URI[bullet.sha256sum] = "91eaa3a58fb4aa6847330c70fb3767be6278e43fa4bc9e9dbd0359365297aa5d"
SRC_URI[geometry.md5sum] = "2c64c52908558a0d2e56c35aedbf7b72"
SRC_URI[geometry.sha256sum] = "965d268805d7c879faacbc98794ea1058c97f5cdb90119b602ac05f44fcb67f2"
SRC_URI[nodelet_core.md5sum] = "35c34fa5defe1cfb2c6983fbc549d1af"
SRC_URI[nodelet_core.sha256sum] = "bc06ecd6277e50477bc2de369363c77518d4b8cb3cc214942e353a8301666ac4"
SRC_URI[orocos_kinematics_dynamics.md5sum] = "976f56c1023815924226cf50801668ba"
SRC_URI[orocos_kinematics_dynamics.sha256sum] = "50be9da981f4401bb020c8971195fff82c7a47e49b6898ba6d55eabcab64e946"
SRC_URI[pluginlib.md5sum] = "8eb86377fe9b8883e118ba4c70d05640"
SRC_URI[pluginlib.sha256sum] = "127e5f06ff2e8c7c386220123039172cad87f432fcb7b56169a1b9dcbee05357"
SRC_URI[image_common.md5sum] = "05bd577d69090c4c395fc51ea54d1d04"
SRC_URI[image_common.sha256sum] = "a568f6e3833c8fbd344dd7543593e258f1a399b5e2c35ba1f52b7b84d609648f"

do_unpack_extra(){
  find ${WORKDIR} -depth -name .svn -exec rm -rf {} \;
  find ${WORKDIR} -depth -name .hg -exec rm -rf {} \;
  find ${WORKDIR} -depth -name .git -exec rm -rf {} \;

  mkdir -p ${S}
  # Special handling of the ros stack
  if [ -d ${WORKDIR}/ros-* ]; then
    mv ${WORKDIR}/ros-* ${S}/ros
  fi

  mkdir -p ${S}/stacks
  for dir in ros_comm common_rosdeps bond_core common_msgs common driver_common eigen filters bullet geometry \
    nodelet_core orocos_kinematics_dynamics pluginlib image_common; do
    find ${WORKDIR} -maxdepth 1 -name "${dir}*" -type d -exec mv {} ${S}/stacks/${dir} \;
  done
}
addtask unpack_extra after do_unpack before do_patch

do_compile() {
    export ROS_ROOT=$(dirname $(which rospack))/..
    export TARGET_SYSROOT=${STAGING_DIR}/${HOST_SYS}
    export OLD_ROS_ROOT=${ROS_ROOT}
    export ROS_ROOT=${S}/ros
    export PYTHONPATH=$ROS_ROOT/core/roslib/src:$PYTHONPATH
    export ROS_PACKAGE_PATH=${S}/stacks
    if [ ! -f $ROS_ROOT/rostoolchain.cmake ]; then
      mv ${WORKDIR}/rostoolchain.cmake $ROS_ROOT/
    fi
    if [ ! -f $ROS_ROOT/rosconfig.cmake ]; then
      mv ${WORKDIR}/rosconfig.cmake $ROS_ROOT/
    fi
    cd $ROS_ROOT/tools/rospack
    if [ ! -f ROS_NOBUILD ]; then
      oe_runmake && touch ROS_NOBUILD
    fi
    if [ ! -f $ROS_ROOT/bin/rospack_gumros ]; then
      mv $ROS_ROOT/bin/rospack $ROS_ROOT/bin/rospack_gumros
    fi
    if [ ! -f $ROS_ROOT/bin/rosstack_gumros ]; then
      mv $ROS_ROOT/bin/rosstack $ROS_ROOT/bin/rosstack_gumros
    fi
    cp $OLD_ROS_ROOT/bin/rospack $ROS_ROOT/bin/
    cp $OLD_ROS_ROOT/bin/rosstack $ROS_ROOT/bin/

    rosmake --bootstrap --disable-logging --status-rate=0 roscpp
    find ${S} -name CMakeCache.txt | sed -e "s+build/CMakeCache.txt+ROS_NOBUILD+g" | xargs -r touch

    rosmake --disable-logging --status-rate=0 tf
    find ${S} -name CMakeCache.txt | sed -e "s+build/CMakeCache.txt+ROS_NOBUILD+g" | xargs -r touch

    #rosmake --disable-logging --status-rate=0 kdl
    #find ${S} -name CMakeCache.txt | sed -e "s+build/CMakeCache.txt+ROS_NOBUILD+g" | xargs -r touch

    rosmake --disable-logging --status-rate=0 pluginlib
    find ${S} -name CMakeCache.txt | sed -e "s+build/CMakeCache.txt+ROS_NOBUILD+g" | xargs -r touch

    rosmake --disable-logging --status-rate=0 nodelet
    find ${S} -name CMakeCache.txt | sed -e "s+build/CMakeCache.txt+ROS_NOBUILD+g" | xargs -r touch

    rosmake --disable-logging --status-rate=0 eigen
    find ${S} -name CMakeCache.txt | sed -e "s+build/CMakeCache.txt+ROS_NOBUILD+g" | xargs -r touch

    rosmake --disable-logging --status-rate=0 nav_msgs
    find ${S} -name CMakeCache.txt | sed -e "s+build/CMakeCache.txt+ROS_NOBUILD+g" | xargs -r touch

    rosmake --disable-logging --status-rate=0 std_srvs
    find ${S} -name CMakeCache.txt | sed -e "s+build/CMakeCache.txt+ROS_NOBUILD+g" | xargs -r touch

    rosmake --disable-logging --status-rate=0 camera_calibration_parsers
    find ${S} -name CMakeCache.txt | sed -e "s+build/CMakeCache.txt+ROS_NOBUILD+g" | xargs -r touch

    rosmake --disable-logging --status-rate=0 image_transport
    find ${S} -name CMakeCache.txt | sed -e "s+build/CMakeCache.txt+ROS_NOBUILD+g" | xargs -r touch

    mv -f $ROS_ROOT/bin/rospack_gumros $ROS_ROOT/bin/rospack
    mv -f $ROS_ROOT/bin/rosstack_gumros $ROS_ROOT/bin/rosstack
    rm -f $ROS_ROOT/rostoolchain.cmake
}

do_install() {
    find ${S} -depth -name build -exec rm -rf {} \;
    find ${S} -depth -name CMakeFiles -exec rm -rf {} \;
    install -d ${D}/opt/ros/${PV}
    install -d ${D}/opt/ros/${PV}/stacks
    if [ -d ${S}/ros ]; then
	cp -Rf ${S}/ros ${D}/opt/ros/${PV}
    fi
    for dir in $(ls ${S}/stacks/); do
        cp -Rf ${S}/stacks/${dir} ${D}/opt/ros/${PV}/stacks/
    done
    ${WORKDIR}/fixrpath.py ${D}/opt/ros/${PV} ${S} /opt/ros/${PV}
    install -m 755 ${WORKDIR}/setup-env.sh ${D}/opt/ros/${PV}
    sed -i 's:/opt/ros:/opt/ros/${PV}:' ${D}/opt/ros/${PV}/setup-env.sh
    install -d ${D}/home/root
    install -m 644 ${WORKDIR}/bash_profile ${D}/home/root/.bash_profile
    sed -i 's:/opt/ros:/opt/ros/${PV}:' ${D}/home/root/.bash_profile
    sed -i 's/ARM_FP_OPT/${ARM_FP_OPT}/' ${D}/home/root/.bash_profile
}

FILES_${PN} = "/*"

FILES_${PN}-dbg = " \
    /opt/ros/${PV}/ros/bin/.debug \
    /opt/ros/${PV}/ros/core/roslib/lib/.debug \
    /opt/ros/${PV}/ros/tools/rospack/lib/.debug \
    /opt/ros/${PV}/stacks/bond_core/bondcpp/lib/.debug \
    /opt/ros/${PV}/stacks/bullet/lib/.debug \
    /opt/ros/${PV}/stacks/common_msgs/sensor_msgs/lib/.debug \
    /opt/ros/${PV}/stacks/geometry/tf/bin/.debug \
    /opt/ros/${PV}/stacks/geometry/tf/lib/.debug \
    /opt/ros/${PV}/stacks/image_common/camera_calibration_parsers/bin/.debug \
    /opt/ros/${PV}/stacks/image_common/camera_calibration_parsers/lib/.debug \
    /opt/ros/${PV}/stacks/image_common/image_transport/bin/.debug \
    /opt/ros/${PV}/stacks/image_common/image_transport/lib/.debug \
    /opt/ros/${PV}/stacks/nodelet_core/nodelet/bin/.debug \
    /opt/ros/${PV}/stacks/nodelet_core/nodelet/lib/.debug \
    /opt/ros/${PV}/stacks/orocos_kinematics_dynamics/python_orocos_kdl/lib/.debug \
    /opt/ros/${PV}/stacks/pluginlib/lib/.debug \
    /opt/ros/${PV}/stacks/ros_comm/clients/cpp/roscpp/lib/.debug \
    /opt/ros/${PV}/stacks/ros_comm/clients/cpp/roscpp_serialization/lib/.debug \
    /opt/ros/${PV}/stacks/ros_comm/test/perf_roscpp/bin/.debug \
    /opt/ros/${PV}/stacks/ros_comm/test/perf_roscpp/lib/.debug \
    /opt/ros/${PV}/stacks/ros_comm/test/test_roscpp_serialization_perf/.debug \
    /opt/ros/${PV}/stacks/ros_comm/tools/rosbag/bin/.debug \
    /opt/ros/${PV}/stacks/ros_comm/tools/rosbag/lib/.debug \
    /opt/ros/${PV}/stacks/ros_comm/tools/rosconsole/examples/.debug \
    /opt/ros/${PV}/stacks/ros_comm/tools/rosconsole/lib/.debug \
    /opt/ros/${PV}/stacks/ros_comm/tools/rosout/.debug \
    /opt/ros/${PV}/stacks/ros_comm/tools/topic_tools/bin/.debug \
    /opt/ros/${PV}/stacks/ros_comm/tools/topic_tools/lib/.debug \
    /opt/ros/${PV}/stacks/ros_comm/utilities/cpp_common/lib/.debug \
    /opt/ros/${PV}/stacks/ros_comm/utilities/message_filters/lib/.debug \
    /opt/ros/${PV}/stacks/ros_comm/utilities/rostime/lib/.debug \
    /opt/ros/${PV}/stacks/ros_comm/utilities/xmlrpcpp/lib/.debug \
  "
