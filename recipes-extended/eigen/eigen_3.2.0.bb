require eigen.inc

PR = "r0"

SRC_URI += "file://eigen-disable-tests.patch"

SRC_URI[md5sum] = "894381be5be65bb7099c6fd91d61b357"
SRC_URI[sha256sum] = "011f78960d939227f9276173d0c4cc0053bb9e0a7356539a9a6c7c89d984fab6"

S = "${WORKDIR}/eigen-eigen-ffa86ffb5570"
