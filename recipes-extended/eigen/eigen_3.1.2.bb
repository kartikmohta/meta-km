require eigen.inc

PR = "r0"

SRC_URI += "file://eigen-disable-tests.patch"

SRC_URI[md5sum] = "e9c081360dde5e7dcb8eba3c8430fde2"
SRC_URI[sha256sum] = "5efddc5b11f651bc531b46e4a00b805b16f8bb356db361a533c92145ecdadcc3"

S = "${WORKDIR}/eigen-eigen-5097c01bcdc4"
