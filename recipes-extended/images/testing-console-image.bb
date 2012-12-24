# Personal testing console image

inherit image

IMAGE_FEATURES += "package_management"
IMAGE_FEATURES += "tools-sdk dev-pkgs ssh-server-openssh debug-tweaks"


BASE_INSTALL = " \
  ${MACHINE_EXTRA_RRECOMMENDS} \
  base-files \
  base-passwd \
  bash \
  bzip2 \
  coreutils \
  dbus \
  devmem2 \
  findutils \
  gawk \
  grep \
  gzip \
  iputils \
  less \
  linux-firmware-sd8686 \
  netbase \
  net-tools \
  openssh-ssh openssh-keygen openssh-scp openssh-sshd-systemd \
  sed \
  shadow tinylogin \
  systemd systemd-compat-units\
  tar \
  tzdata \
  udev \
  update-alternatives-cworth \
  util-linux \
  wget \
  which \
  zypper \
 "


TOOLS_INSTALL = " \
  cpufrequtils \
  dhcp-client \
  dosfstools \
  e2fsprogs \
  e2fsprogs-e2fsck \
  git \
  hdparm \
  htop \
  i2c \
  i2c-tools \
  i2c-tools-dev \
  iw \
  nano \
  ntpdate \
  packagegroup-sdk-target \
  procps \
  rsync \
  screen \
  strace \
  subversion \
  systemd-analyze \
  vim \
  wpa-supplicant wpa-supplicant-systemd \
  zip \
 "
#  gdb \
#    mercurial \
#    omap3-writeprom \
#    u-boot-utils \


IMAGE_EXTRA_INSTALL += " \
  media-ctl \
  opencv-dev \
  ros \
  yavta \
 "
#  rtklib \

USB_INSTALL = " \
  ${@base_contains("MACHINE_FEATURES", "usbhost", "usbutils", "", d)} \
  usb-gadget-serial \
  usb-gadget-serial-getty \
 "
IMAGE_INSTALL = " \
  ${BASE_INSTALL} \
  ${IMAGE_EXTRA_INSTALL} \
  ${TOOLS_INSTALL} \
  ${USB_INSTALL} \
 "

export IMAGE_BASENAME = "testing-console-image"
IMAGE_LINGUAS = ""

# this section removes remnants of legacy sysvinit support
# for packages installed above
IMAGE_FILE_BLACKLIST += " \
                        /etc/init.d/NetworkManager \
                        /etc/init.d/avahi-daemon \
                        /etc/init.d/alsa-state \
                        /etc/init.d/dbus-1 \
                        /etc/init.d/dnsmasq \
                        /etc/init.d/ifup \
                        /etc/init.d/networking \
                        /etc/init.d/ntpd \
                        /etc/init.d/sshd \
                        /etc/init.d/udev \
                        /etc/init.d/udev-cache \
                       "

remove_blacklist_files() {
        for i in ${IMAGE_FILE_BLACKLIST}; do
                rm -rf ${IMAGE_ROOTFS}$i
        done

}

ROOTFS_POSTPROCESS_COMMAND =+ "remove_blacklist_files ; "
