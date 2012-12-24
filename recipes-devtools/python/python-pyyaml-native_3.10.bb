DESCRIPTION = "Python support for YAML"
HOMEPAGE = "http://www.pyyaml.org"
SECTION = "devel/python"
DEPENDS = "python-cython-native libyaml-native"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6015f088759b10e0bc2bf64898d4ae17"
PR = "0"

SRC_URI = "http://pyyaml.org/download/pyyaml/PyYAML-${PV}.tar.gz \
           file://setup.py \
          "

SRC_URI[md5sum] = "74c94a383886519e9e7b3dd1ee540247"
SRC_URI[sha256sum] = "e713da45c96ca53a3a8b48140d4120374db622df16ab71759c9ceb5b8d46fe7c"

S = "${WORKDIR}/PyYAML-${PV}"

inherit native
inherit distutils

#do_configure_prepend() {
#	# upstream setup.py overcomplicated, use ours
#	install -m 0644 ${WORKDIR}/setup.py ${S}
#}

#do_stage() {
#    PYTHONPATH=${STAGING_BINDIR} BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} \
#    STAGING_LIBDIR=${STAGING_LIBDIR} STAGING_INCDIR=${STAGING_INCDIR} \
#        ${STAGING_BINDIR}/python setup.py install --prefix=${STAGING_BINDIR}/.. --install-data=${STAGING_DATADIR}
#}

