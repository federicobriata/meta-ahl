DESCRIPTION = "Orca Live Programming Environmenti (C Port)"
HOMEPAGE = "http://wiki.xxiivv.com/orca"
LICENSE = "MIT"

SRC_URI = "git://github.com/hundredrabbits/Orca-c"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git/"

LIC_FILES_CHKSUM = "file://${S}/LICENSE.md;md5=74fa93ddba06bcfd03f2f695dfb3d7be"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

DEPENDS = "portmidi ncurses"

do_compile() {
    rm -rf build && mkdir build
    ${CC} ${LDFLAGS} -std=c99 -pipe -finput-charset=UTF-8 -Wall -Wpedantic -Wextra -Wwrite-strings -DNDEBUG -O2 -g0 -U_FORTIFY_SOURCE -D_FORTIFY_SOURCE=0 -s -D_XOPEN_SOURCE_EXTENDED=1 -isystem thirdparty -D_POSIX_C_SOURCE=200809L -DFEAT_PORTMIDI -o build/orca gbuffer.c field.c vmio.c sim.c osc_out.c term_util.c sysmisc.c thirdparty/oso.c tui_main.c -lrt -lmenuw -lformw -lncursesw -lportmidi -lasound -lpthread
}

do_install() {
    install -d -m 755 ${D}${bindir}/
    install -p -m 755 ${S}/build/orca ${D}${bindir}/
}
