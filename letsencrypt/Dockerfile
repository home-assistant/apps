ARG BUILD_FROM
FROM $BUILD_FROM

# Allow pip to install packages system-wide on Debian
ENV PIP_BREAK_SYSTEM_PACKAGES=1

# Log the full date next to the time, bashio defaults to "%T" (time only)
ENV LOG_TIMESTAMP="%Y-%m-%d %H:%M:%S"

# setup base
# certbot-dns-multi replaces most individual DNS plugins using lego
# Only legacy plugins are kept for providers not supported by lego: gehirn, eurodns, noris
# Azure and HE is also kept as legacy for backward compatibility (will be removed in future version)
ARG \
    BUILD_ARCH \
    ACME_VERSION \
    CERTBOT_DNS_AZURE_VERSION \
    CERTBOT_DNS_EURODNS_VERSION \
    CERTBOT_DNS_HURRICANE_ELECTRIC_VERSION \
    CERTBOT_DNS_MULTI_VERSION \
    CERTBOT_DNS_NORISNETWORK_VERSION \
    CERTBOT_VERSION \
    CRYPTOGRAPHY_VERSION

RUN \
    set -x \
    && apt-get update \
    && apt-get install -y --no-install-recommends \
        build-essential \
        ca-certificates \
        cargo \
        golang \
        libffi8 \
        libffi-dev \
        libssl-dev \
        openssl \
        python3 \
        python3-dev \
        python3-pip \
        rustc \
    && pip3 install --no-cache-dir \
        acme==${ACME_VERSION} \
        certbot==${CERTBOT_VERSION} \
        certbot-dns-azure==${CERTBOT_DNS_AZURE_VERSION} \
        certbot-dns-eurodns==${CERTBOT_DNS_EURODNS_VERSION} \
        certbot-dns-gehirn==${CERTBOT_VERSION} \
        certbot-dns-hurricane-electric==${CERTBOT_DNS_HURRICANE_ELECTRIC_VERSION} \
        certbot-dns-multi==${CERTBOT_DNS_MULTI_VERSION} \
        certbot-dns-norisnetwork==${CERTBOT_DNS_NORISNETWORK_VERSION} \
        cryptography==${CRYPTOGRAPHY_VERSION} \
    && apt-get purge -y --auto-remove \
        build-essential \
        cargo \
        golang \
        libffi-dev \
        libssl-dev \
        python3-dev \
        python3-pip \
        rustc \
    && rm -rf /var/lib/apt/lists/* \
    && rm -rf /root/.cache

# Copy data
COPY rootfs /
