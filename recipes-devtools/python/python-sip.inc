DESCRIPTION = "Runtime helper for sip-generated python wrapper libraries"
SECTION = "devel/python"
HOMEPAGE = "http://www.riverbankcomputing.co.uk/sip"
AUTHOR = "Phil Thompson"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE-GPL3;md5=7ea41d866d6638e430db5287a3f66090"
DEPENDS = "python"
RDEPENDS_${PN} = "python-core"

SRC_URI = "${SOURCEFORGE_MIRROR}/pyqt/sip/sip-${PV}.tar.gz"

S = "${WORKDIR}/sip-${PV}"

inherit distutils-base

do_configure(){
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
    BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} \
    python configure.py CC="${CC}" CFLAGS="${CFLAGS}" CXX="${CXX}" CXXFLAGS="${CXXFLAGS}" LINK="${CXX}" LINK_SHLIB="${CXX}" LFLAGS="${LDFLAGS}"
}

do_install(){
    install -d ${D}${PYTHON_SITEPACKAGES_DIR}
    install -m 0755 siplib/sip.so ${D}${PYTHON_SITEPACKAGES_DIR}/
    install -d ${D}${includedir}/${PYTHON_DIR}
    install -m 0644 siplib/sip.h ${D}${includedir}/${PYTHON_DIR}/
    install -d ${D}${bindir}
    install -m 0755 sipgen/sip ${D}${bindir}/
}

do_install_virtclass-native(){
    install -d ${D}${PYTHON_SITEPACKAGES_DIR}
    install -m 0755 siplib/sip.so ${D}${PYTHON_SITEPACKAGES_DIR}/
    install -d ${D}${includedir}/${PYTHON_DIR}
    install -m 0644 siplib/sip.h ${D}${includedir}/${PYTHON_DIR}/
    install -d ${D}${bindir}
    install -m 0755 sipgen/sip ${D}${bindir}/
    install -d ${D}${libdir}/${PYTHON_DIR}
    install -m 0644 sipconfig.py ${D}${libdir}/${PYTHON_DIR}
}

FILES_${PN} = "${libdir}/${PYTHON_DIR}/site-packages/sip.so"
FILES_${PN}-dev = "${bindir}/sip ${includedir}/${PYTHON_DIR}/sip.h"

BBCLASSEXTEND = "native"
