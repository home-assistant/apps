# Changelog

## 8.8.1

- Update base image to trixie-2026.11.1
- Publish app to GHCR

## 8.8.0

- Upgrade base image from bookworm to trixie
- Fix timestamps in log messages during shutdown

## 8.7.2

- Bump deCONZ to 2.33.2 [[CHANGELOG](https://github.com/dresden-elektronik/deconz-rest-plugin/releases/tag/v2.33.2)]

## 8.7.1

- Avoid generating additional API keys upon HTTP/JSON errors
- Update DOCS.md with an explanation for manual API key removal

## 8.7.0

- Drop unsupported architectures

## 8.6.1

- Align ingress colors with Home Assistant (toolbar color)

## 8.6.0

- Bump deCONZ to 2.32.5 [[CHANGELOG](https://github.com/dresden-elektronik/deconz-rest-plugin/releases/tag/v2.32.5)]
- Renaming from add-on to app complete
- HTTPS disabled

## 8.5.3

- Align ingress colors with Home Assistant (link color)

## 8.5.2

- Add configurable OTA update switches for Bosch, IKEA and OSRAM/LEDVANCE (default is off)
- Add Bosch Smart Home OTA update script (Official repo)

## 8.5.1

- Add more debug options

## 8.5.0

- Fix discovery script

## 8.4.0

- Ingress entry page revised (for example, light and dark mode)
- Update DOCS.md and a few naming corrections
- Expand English translation

## 8.3.0

- Bump deCONZ to 2.31.2 [[CHANGELOG](https://github.com/dresden-elektronik/deconz-rest-plugin/releases/tag/v2.31.2)]

## 8.2.0

- Bump deCONZ to 2.30.2 [[CHANGELOG](https://github.com/dresden-elektronik/deconz-rest-plugin/releases/tag/v2.30.2)]

## 8.1.0

- Bump deCONZ to 2.29.5 [[CHANGELOG](https://github.com/dresden-elektronik/deconz-rest-plugin/releases/tag/v2.29.5)]

## 8.0.0

- Use openbox instead of dwm as window manager

## 7.0.0

- Bump deCONZ to 2.28.1
- Use debian bookworm for all arch types
- Use dwm instead of wmii as window manager

## 6.23.0

- Bump deCONZ to 2.25.3

## 6.22.0

- Revert deCONZ to 2.22.2 due to a Phoscon bug: https://forum.phoscon.de/t/phoscon-de-pwa-login-html-does-not-work-anymore/3967

## 6.21.0

- Bump deCONZ to 2.23.1

## 6.20.0

- Bump deCONZ to 2.22.2

## 6.19.0

- Bump deCONZ to 2.21.2

## 6.18.0

- Bump deCONZ to 2.20.1

## 6.17.1

- Bump deCONZ to 2.19.3

## 6.17.0

- Bump deCONZ to 2.19.1

## 6.16.0

- Bump deCONZ to 2.18.2

## 6.15.0

- Bump deCONZ to 2.17.1

## 6.14.2

- Fix finish script for S6 V3

## 6.14.1

- Version bump to fix S6 service permissions

## 6.14.0

- Bump deCONZ to 2.16.1

## 6.13.0

- Bump deCONZ to 2.15.3

## 6.12.1

- Fix Phoscon App gateway discovery with FQDN over Ingress
- Improve Phoscon App subnet probing block when using Ingress

## 6.12.0

- Bump deCONZ to 2.14.1

## 6.11.1

- Add missing libqt5qml5 dependency
- Do not force install of deCONZ packages

## 6.11.0

- Bump deCONZ to 2.13.4

## 6.10.0

- Bump deCONZ to 2.12.6

## 6.9.0

- Bump deCONZ to 2.11.5

## 6.8.0

- Bump deCONZ to 2.10.4
- Cleanup privileged for new kernel module options

## 6.7.2

- Revert restart nginx service on error

## 6.7.1

- Restart nginx service on error

## 6.7.0

- Bump deCONZ to 2.9.3

## 6.6.5

- Update hardware configuration for Supervisor 2021.02.5

## 6.6.4

- Fix errors with new Supervisor as transit update

## 6.6.3

- Use hostname for discovery instead of IP

## 6.6.2

- Fixes issues where the `otau` directory was not excluded from snapshots

## 6.6.1

- Small cleanup with s6-overlay

## 6.6.0

- Bump deCONZ to 2.7.1

## 6.5.0

- Bump deCONZ to 2.05.88

## 6.4.1

- Enable autoscale for ingress noVNC

## 6.4.0

- Bump deCONZ to 2.05.84

## 6.3.0

- Bump deCONZ to 2.05.81

## 6.2.3

- Add background color to the ingress entry page

## 6.2.2

- Add styling to the ingress entry page

## 6.2.1

- Fix old fashon VNC access

## 6.2.0

- Enable VNC per default
- Ingress entry page to select noVNC or Phoscon

## 6.1.2

- Disable default init system

## 6.1.1

- Fix LEDVANCE / OSRAM otau firmware downloader to restart each 65 seconds
- Fix issue with VNC not starting on armhf, armv7 & aarch64 based systems

## 6.1.0

- Fix issue with armhf / move back to raspbian
- Add wiringPi to aarch64

## 6.0.1

- Fix wiringPi and built it from source

## 6.0.0

- Use debian buster for all arch types
- Migrate to new S6-Overlay
- Fix LEDVANCE / OSRAM otau firmware downloader
- Bump deCONZ to 2.05.79
- New deCONZ firmware management on startup
- Exclude OTAU folder from snapshot

## 5.3.6

- Bump deCONZ to 2.05.78

## 5.3.5

- Downgrade deCONZ to 2.05.75, since it has been reported that 2.05.77, and possibly also 2.05.76, is causing issues for several users.

## 5.3.4

- Bump deCONZ to 2.05.77

## 5.3.3

- Bump deCONZ to 2.05.76

## 5.3.2

- Bump deCONZ to 2.05.75

## 5.3.1

- Increase wait time for show device

## 5.3.0

- Bump deCONZ to 2.05.74

## 5.2.0

- Bump deCONZ to 2.05.73
- Small adjustments to NGINX configuration

## 5.1.0

- Add LEDVANCE / OSRAM otau firmware downloader, respecting max 10 DL per minute Ratelimits

## 5.0.0

- Fix additional gateway visible on Phoscon login on Ingress
- Fix Phoscon device scanning/probing triggering IP bans
- Fix redirect to login page when Phoscon session expires
- Fix incorrect manifest request from Phoscon frontend
- Fix and improve API key handling with Hass.io discovery
- Change Hass.io discovery to use add-on IP instead of hostname
- Improve Phoscon discovery to work different and faster with Ingress
- Add Websocket support to Ingress for instant and snappy UI updates
- Re-instate direct access capabilities to the Phoscon/deCONZ API

_Please note: This release works best with Home Assistant 0.103.4 or newer,
that release contains fixes/optimizations for the add-on as well._
