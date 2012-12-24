DESCRIPTION = "Opencv : The Open Computer Vision Library"
HOMEPAGE = "http://opencv.willowgarage.com/wiki/"
SECTION = "libs"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://include/opencv2/opencv.hpp;endline=41;md5=6d690d8488a6fca7a2c192932466bb14"

ARM_INSTRUCTION_SET = "arm"

DEPENDS = "v4l-utils libtool jpeg bzip2 zlib libpng tiff"

SRC_URI = "${SOURCEFORGE_MIRROR}/opencvlibrary/opencv-unix/${PV}/OpenCV-${PV}.tar.bz2 \
           file://opencv-fix-pkgconfig-generation.patch \
           "

SRC_URI[md5sum] = "c0a5af4ff9d0d540684c0bf00ef35dbe"
SRC_URI[sha256sum] = "f8fbe985978d4eae73e8c3b526ed40a37d4761d2029a5b035233f58146f6f59b"

PR = "r2"

S = "${WORKDIR}/OpenCV-${PV}"

EXTRA_OECMAKE = "-DBUILD_PERF_TESTS=OFF \
                 -DBUILD_TESTS=OFF \
                 -DBUILD_DOCS=OFF \
                 -DWITH_FFMPEG=OFF \
                 -DWITH_GSTREAMER=OFF \
                 -DWITH_V4L=ON \
                 -DWITH_GTK=OFF \
                 -DCMAKE_SKIP_RPATH=ON \
                 -DENABLE_FAST_MATH=ON \
                 "

inherit distutils-base pkgconfig cmake

export BUILD_SYS
export HOST_SYS

TARGET_CC_ARCH += "-I${S}/include "

PACKAGES += "${PN}-apps"

python populate_packages_prepend () {
    cv_libdir = d.expand('${libdir}')
    cv_libdir_dbg = d.expand('${libdir}/.debug')
    do_split_packages(d, cv_libdir, '^lib(.*)\.so$', 'lib%s-dev', 'OpenCV %s development package', extra_depends='${PN}-dev', allow_links=True)
    do_split_packages(d, cv_libdir, '^lib(.*)\.la$', 'lib%s-dev', 'OpenCV %s development package', extra_depends='${PN}-dev')
    do_split_packages(d, cv_libdir, '^lib(.*)\.a$', 'lib%s-dev', 'OpenCV %s development package', extra_depends='${PN}-dev')
    do_split_packages(d, cv_libdir, '^lib(.*)\.so\.*', 'lib%s', 'OpenCV %s library', extra_depends='', allow_links=True)

    pn = d.getVar('PN', 1)
    metapkg =  pn + '-dev'
    d.setVar('ALLOW_EMPTY_' + metapkg, "1")
    blacklist = [ metapkg ]
    metapkg_rdepends = [ ]
    packages = d.getVar('PACKAGES', 1).split()
    for pkg in packages[1:]:
        if not pkg in blacklist and not pkg in metapkg_rdepends and pkg.endswith('-dev'):
            metapkg_rdepends.append(pkg)
    d.setVar('RRECOMMENDS_' + metapkg, ' '.join(metapkg_rdepends))
}

PACKAGES_DYNAMIC += "^libopencv-.*"

FILES_${PN} = ""
FILES_${PN}-apps = "${bindir}/* ${datadir}/OpenCV"
FILES_${PN}-dbg += "${libdir}/.debug"
FILES_${PN}-dev = "${includedir} ${libdir}/pkgconfig ${datadir}/OpenCV/*.cmake"
FILES_${PN}-doc = "${datadir}/OpenCV/doc"

ALLOW_EMPTY_${PN} = "1"

do_install_append() {
	cp ${S}/include/opencv/*.h ${D}${includedir}/opencv/
	sed -i '/blobtrack/d' ${D}${includedir}/opencv/cvaux.h
}
