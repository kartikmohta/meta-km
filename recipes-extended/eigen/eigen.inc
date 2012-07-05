DESCRIPTION = "Eigen is a C++ template library for linear algebra: matrices, vectors, numerical solvers, and related algorithms."
AUTHOR = "Benoît Jacob and Gaël Guennebaud and others"
HOMEPAGE = "http://eigen.tuxfamily.org/"
LICENSE = "LGPL-3.0"
LIC_FILES_CHKSUM = "file://COPYING.LGPL;md5=50afb8ab0c03b61b94cea40e54c0a07c"

PR = "r0"

SRC_URI = "http://bitbucket.org/eigen/eigen/get/${PV}.tar.bz2"

inherit cmake

OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"

EXTRA_OECMAKE += "-Dpkg_config_libdir=${libdir}"

FILES_${PN} = "${includedir} ${libdir}"
