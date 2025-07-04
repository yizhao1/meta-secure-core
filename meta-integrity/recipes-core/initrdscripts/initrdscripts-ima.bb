DESCRIPTION = "The initrd script for Linux Integrity Measurement Architecture (IMA)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "\
    file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
"

SRC_URI = "\
    file://init.ima \
"

S = "${UNPACKDIR}"

ALLOW_EMPTY:${PN} = "1"

do_install() {
    install -m 0500 "${S}/init.ima" "${D}"
}

FILES:${PN} += "\
    /init.ima \
"

# Install the minimal stuffs only, and don't care how the external
# environment is configured.

# @coreutils: echo, printf
# @grep: grep
# @gawk: awk
# @util-linux: mount, umount
# @ima-evm-utils: evmctl
RDEPENDS:${PN} += "\
    coreutils \
    grep \
    gawk \
    util-linux-mount \
    util-linux-umount \
    keyutils \
    ima-policy \
"

RRECOMMENDS:${PN} += "\
    key-store-ima-cert \
"
