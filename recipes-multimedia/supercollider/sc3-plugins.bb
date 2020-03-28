DESCRIPTION = "Compiled scsynth UGen plugins for SuperCollider"
HOMEPAGE = "https://supercollider.github.io/sc3-plugins/"
LICENSE = "GPL-2.0"

SRC_URI = "gitsm://github.com/supercollider/sc3-plugins;protocol=git;branch=3.10 \
	file://remove_sse_flag.patch"
SRCREV = "6d69ae91cbbcd37c63b0e3f3d8d89da71d20960b"

S = "${WORKDIR}/git/"

LIC_FILES_CHKSUM = "file://${S}/license.txt;md5=892f569a555ba9c07a568a7c0c4fa63a"

EXTRA_OECMAKE = "\
	-DSUPERNOVA=OFF \
	-DSYSTEM_STK=OFF \
	-DSC_PATH=${WORKDIR}/recipe-sysroot/usr/include/SuperCollider/ \
	-DCMAKE_BUILD_TYPE=Release \
	-DNATIVE=OFF \
"
inherit cmake

DEPENDS = "supercollider"

FILES_${PN} += " \
  ${libdir}/SuperCollider/plugins/*.so \
  ${datadir}/SuperCollider/Extensions/* \
"

FILES_${PN}-dbg += " \
  ${libdir}/SuperCollider/plugins/.debug/*.so \
"
