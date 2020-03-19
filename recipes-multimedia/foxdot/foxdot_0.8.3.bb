DESCRIPTION = "Python driven environment for Live Coding."
HOMEPAGE = "http://foxdot.org/"
SRC_URI[md5sum] = "cd17827f67fed38b922362cce58f4463"
SRC_URI[sha256sum] = "1781005194062dd1808f92c674e738d17628b534a8f577d66d01cf15600e941e"
LICENSE="CC-BY-SA-4.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/CC-BY-SA-3.0;md5=3248afbd148270ac7337a6f3e2558be5"
SRC_URI = "file://foxdot.scd \
	file://foxdot.sh"

PYPI_PACKAGE = "FoxDot"
inherit pypi setuptools3

DEPENDS = "supercollider sc3-plugins python3-tkinter"
RDEPENDS_${PN} += "bash"

do_install_append() {
    install -d -m 755 ${D}${docdir}/foxdot/
    install -p -m 644 README.md ${D}${docdir}/foxdot/
    install -d -m 755 ${D}${docdir}/foxdot/demo/
    install -p -m 644 FoxDot/demo/* ${D}${docdir}/foxdot/demo/
    install -p -m 755 ${WORKDIR}/start_foxdot.sh ${D}${bindir}/
    install -p -m 755 ${WORKDIR}/foxdot.py ${D}${bindir}/
    install -d -m 755 ${D}/${datadir}/SuperCollider/Extensions/FoxDot/ 
    install -p -m 644 ${WORKDIR}/foxdot.scd ${D}/${datadir}/SuperCollider/Extensions/FoxDot/foxdot.scd
}

FILES_${PN} += "${bindir}/* \
    ${datadir}/*"

#FILES_${PN}-doc = " \
#    ${docdir}/foxdot/README.md \
#    ${docdir}/foxdot/demo/* \
#"
