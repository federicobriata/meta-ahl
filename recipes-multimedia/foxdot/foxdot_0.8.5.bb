DESCRIPTION = "Python driven environment for Live Coding."
HOMEPAGE = "http://foxdot.org/"
SRC_URI[md5sum] = "853ed58e49a13bbc0e37cce3301d8217"
SRC_URI[sha256sum] = "a9b87f9d0581e0d0304ebfb8e18f6d6bb01174c43d1cd5363410c25fa97462cc"
LICENSE="CC-BY-SA-4.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/CC-BY-SA-3.0;md5=3248afbd148270ac7337a6f3e2558be5"
SRC_URI = "file://foxdot.scd \
	file://start_foxdot.sh \
	file://foxdot.py"

PYPI_PACKAGE = "FoxDot"
inherit pypi setuptools3

DEPENDS = "supercollider sc3-plugins ${PYTHON_PN}-setuptools-scm-native"
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
