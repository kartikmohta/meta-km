require eigen.inc

PR = "r0"

SRC_URI += "file://eigen-disable-tests.patch"

SRC_URI[md5sum] = "7408fce7aefb66cf1cd3ca9518607cd1"
SRC_URI[sha256sum] = "3c64a6792a55d8ee672ce45d5a1d1de1ffc50daaf6e8a3677bf8580ad99f036c"

S = "${WORKDIR}/eigen-eigen-ca142d0540d3"
