DESCRIPTION = "Apache logging framework for C++ library"
SECTION = "libs"
DEPENDS = "apr apr-util expat gdbm"
LICENSE = " Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
HOMEPAGE = "http://logging.apache.org/log4cxx/"

PR = "r2"

SRC_URI = "${APACHE_MIRROR}/logging/log4cxx/${PV}/apache-${P}.tar.gz \
    file://log4cxx_0.10.0.patch;apply=yes"

#build this:
S = "${WORKDIR}/apache-${P}"

inherit autotools pkgconfig

FILES_${PN} = "${libdir}/*.so.*"
FILES_${PN}-doc += "${datadir}/log4cxx"

SRC_URI[md5sum] = "b30ffb8da3665178e68940ff7a61084c"
SRC_URI[sha256sum] = "0de0396220a9566a580166e66b39674cb40efd2176f52ad2c65486c99c920c8c"
