require eigen.inc

PR = "r0"

SRC_URI += "file://eigen-disable-tests.patch"

SRC_URI[md5sum] = "a045db8c3812188e841d4740362a3792"
SRC_URI[sha256sum] = "531a97c3d96d151c72951e6f295b5e5f3f68f668fd04c9b1a0d84187547121ab"

S = "${WORKDIR}/eigen-eigen-43d9075b23ef"
