ARG BUILD_FROM
FROM $BUILD_FROM

# Add env
ENV LANG C.UTF-8

# Setup base
RUN \
    apk add --no-cache samba wsdd glib \
    && mkdir -p /var/lib/samba \
    && touch \
        /etc/samba/lmhosts \
        /var/lib/samba/account_policy.tdb \
        /var/lib/samba/registry.tdb \
        /var/lib/samba/winbindd_idmap.tdb

# Copy data
COPY rootfs /

HEALTHCHECK --start-period=3s \
    CMD smbclient -L '\\localhost' -U '%' -m SMB3

ENV \
    S6_STAGE2_HOOK=/etc/s6-overlay/scripts/enable-check.sh
