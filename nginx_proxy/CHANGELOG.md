# Changelog

## 4.6.0

- Add an optional second HTTPS port that requires a client certificate (mTLS), for example for Cloudflare Authenticated Origin Pulls, with an optional trusted real IP header on that port only

## 4.5.1

- Fix nginx failing to start when the client max body size option is present (`incompatible types for comparison` in the config template)

## 4.5.0

- Allow setting the client max request body size from the UI (to be able to upload large files, such as a KNX project file through the proxy)

## 4.4.0

- Fix HTTP/3 requests with Home Assistant 2026.7.0 and newer

## 4.3.0

- Update base image to Alpine 3.24 (base image tag 3.24-2026.06.1) with nginx 1.30.x

## 4.2.0

- update SSL/TLS configuration and add PQC key exchange following Mozilla guidelines

## 4.1.0

- add use_ssl_backend option to support cases where the http section is using the ssl_certificate, ssl_key options

## 4.0.0

- Drop builds of unsupported architectures
- Update base image to Alpine 3.23 (base image tag 3.23-2025.12.2)

## 3.15.0

- Support HTTP/3 (QUIC)

## 3.14.0

- Listen over IPv6, since true IPv6 support for add-ons is now available

## 3.13.0

- Update Alpine Linux to 3.22 (nginx 1.28.x)
- Update to current Mozilla intermediate SSL config

## 3.12.0

- Add origin and X-Forwarded-Proto headers to fix origin issues affecting Portainer and other addons

## 3.11.1

- Update to new nginx http2 directive. This also suppress a deprecation warning.

## 3.11.0

- Update Alpine Linux to 3.20 (nginx 1.26.x)

## 3.10.1

- Make `real_ip_from` optional through an empty default value

## 3.10.0

- Supporting TCP Proxy Protocol

## 3.9.0

- Add `map_hash_bucket_size` to add support for longer matches in `map`

## 3.8.0

- Update Alpine Linux to 3.19

## 3.7.0

- Modify `server_names_hash_bucket_size` to add support for longer domain names

## 3.6.0

- Add port to Host header to fix origin issues affecting ESPHome and other addons

## 3.5.0

- Update Alpine to 3.18 (nginx 1.24.x)

## 3.4.2

- Decrease crond log level

## 3.4.1

- Avoid logging to system console

## 3.4.0

- Add X-Forwarded-Host to fix origin issues affecting VSCode and other addons

## 3.3.0

- Check certificate renewal daily and reload nginx if necessary
- Migrate add-on layout to S6 Overlay

## 3.2.0

- Update Alpine to 3.16 (nginx 1.22.x)

## 3.1.5

- Fixed container environment

## 3.1.4

- Fixed init config

## 3.1.3

- Reject SSL on unknown domains instead of responding with an invalid certificate

## 3.1.2

- Fix TLSv1.3 support

## 3.1.1

- Hide server version banner

## 3.1.0

- Allow use of ports other than 8123 in Home Assistant Core

## 3.0.2

- Update Alpine to 3.14
- Use images from ghcr

## 3.0.1

- Fix the use of subfolders with certificate files

## 3.0

- Update Alpine to 3.11
- Use mozilla Recommended SSL settings

## 2.6

- Remove ipv6 listener because we run only inside virtual network on a ipv4 range

## 2.5

- Migrate to Bashio

## 2.4

- Added Cloudflare mechanism for creating auto-generated ipv4/ipv6 list for real visitor ip

## 2.3

- Fix issue with nginx warning for ssl directive

## 2.2

- Fix issue with `homeassistant` connection
- Update nginx to version 1.16.1

## 2.1

- Update nginx to version 1.14.2

## 2.0

- Update nginx to version 1.14.0

## 1.2

- Modify `server_names_hash_bucket_size` to add support for longer domain names

## 1.1

- Update run.sh info messages
- Make HSTS configurable and optional

## 1.0

- Add customization mechanism using included config snippets from /share
- Optimize logo.png
- Update base image
