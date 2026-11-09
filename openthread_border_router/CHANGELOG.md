# Changelog

## 3.4.0

- Show timestamps in app logs by default
- Update OTBR stable to v2026.10.0
  - Routes to external networks announced by other Border Routers in the Thread network (e.g. Apple/Google) are no longer added to the host, which avoids routing loops and mesh congestion on multi Border Router networks. Routes to Thread devices are not affected
  - Channel changes (pending dataset) are now confirmed with the Thread leader instead of being applied locally
  - Various fixes and stability improvements in OpenThread and OTBR
- Update OTBR beta to v2026.11.0
  - Fix mDNS service resolution retries and subscribe to mDNS on the interface of the request
  - REST API: Support Enhanced Route TLV in network diagnostics
  - Various fixes and stability improvements in OpenThread and OTBR
- Update universal-silabs-flasher to v0.1.3
- Update base image to trixie-2026.11.0
- Fix app URL in config.yaml
- Publish app to GHCR

## 3.3.0

- Bump to OTBR POSIX version fd872ab9 (tag v2026.09.0)
  - Thread 1.4 Credentials Sharing (ePSKc): share Thread network credentials with other devices directly from the Web UI
  - Web UI: QR codes are now generated locally instead of using a remote service
  - Various fixes and stability improvements in OpenThread and OTBR
- Bump beta to OTBR POSIX version cb4bdae2 (tag v2026.10.0)
  - Routes to external networks announced by other Border Routers in the Thread network (e.g. Apple/Google) are no longer added to the host, which avoids routing loops and mesh congestion on multi Border Router networks. Routes to Thread devices are not affected
  - Channel changes (pending dataset) are now confirmed with the Thread leader instead of being applied locally
  - Various fixes and stability improvements in OpenThread and OTBR
- Explicitly request the network permissions the app needs, in preparation for an upcoming Supervisor change

## 3.2.1

- Keep retrying unavailable network RCPs without crashing the app

## 3.2.0

- Bump to OTBR POSIX version 337711e7 (tag v2026.08.0)
  - Improved startup robustness: multicast router setup is retried on transient errors
  - Various fixes and stability improvements in OpenThread
- Bump beta to OTBR POSIX version fd872ab9 (tag v2026.09.0)
  - Thread 1.4 Credentials Sharing (ePSKc): share Thread network credentials with other devices directly from the Web UI
  - Web UI: QR codes are now generated locally instead of using a remote service
  - Upstream DNS resolution for Thread devices is now fixed in OpenThread itself (the workaround from 3.1.2 remains in place for stable)
  - Various fixes and stability improvements in OpenThread and OTBR

## 3.1.2

- Fix upstream DNS/DNS64 resolution for Thread devices by not binding the upstream DNS resolver socket to the infra interface (fixes #3947, regression since 2.12.0)

## 3.1.1

- Bump beta to OTBR POSIX version d83ddc62 to test ePSKc / Thread 1.4 Credentials Sharing support ahead of the upstream `release-v2026.09.0` tag

## 3.1.0

- Bump to OTBR POSIX version ec16e396 (tag v2026.07.0)
- Bump beta to OTBR POSIX version 337711e7 (tag v2026.08.0)

## 3.0.2

- Honor the configured `otbr_log_level` for the OTBR web interface (previously always logged at info level)
- Bump beta to OTBR POSIX version ec16e396 (tag v2026.07.0)

## 3.0.1

- Backport fix for [CVE-2026-8369](https://github.com/advisories/GHSA-f6vh-g7gh-wh6h) to stable. This only affects users who have enabled NAT64 and use an untrusted network.

## 3.0.0

- Thread 1.4 is now stable and OpenThread's built-in mDNS is now the default
- The beta toggle has been changed back to stable. If you want to run beta again, please turn it back on.
- Bump beta to OTBR POSIX version 78d9c289 (2026-05-19 23:38:25 -0700)
- Bump serialx to 1.8.0

## 2.16.8

- Use regular hostname with "-otbr" suffix in beta mode to make OTBR recognizable

## 2.16.7

- Print a warning if IPv6 routing is not enabled

## 2.16.6

- Fix and improve NAT64 firewall rules
- Enable recovery mechanism from "radio tx timeout" errors for beta
- Narrow non-firewall forwarding rules to Thread interface

## 2.16.5

- Add `backbone_interface` option to override the network interface used for IPv6 routing.

## 2.16.4

- Fix race condition during startup if web frontend is enabled

## 2.16.3

- Ignore ephemeral temporary settings files in migration

## 2.16.2

- Fix TREL being disabled by default in beta mode

## 2.16.1

- Fix listen address of OTBR Web UI

## 2.16.0

- Add beta toggle to switch between Thread 1.3 (stable) and Thread 1.4 (beta)
- Beta mode uses OpenThread's built-in mDNS instead of mDNSResponder

## 2.15.3

- Fix inconsistent startup for adapters that remap hardware flow control pins for firmware flashing.

## 2.15.2

- Add baudrate list option 1000000 (Nordic Semiconductor nRF Connect SDK firmware)

## 2.15.1

- Make radio spinel recovery more reliable by clearing source match tables before restoring

## 2.15.0

- Automatically migrate the active dataset to a new adapter when changing the addon serial port path.

## 2.14.0

- Remove firmware flashing from the addon, this is now handled by Core 2025.7.0.

## 2.13.0

- Bump to OTBR POSIX version b067e5ac (2025-01-13 22:32:22 -0500)
- Bump universal-silabs-flasher to 0.0.28
- Remove dataset deletion REST API backwards compatibility patch. The minimum Core version for this add-on is now 2023.9.0

## 2.12.4

- Fix OTBR addon does not start after updating containerd.io to 1.7.24-1

## 2.12.3

- Enable recovery mechanism from "radio tx timeout" errors
- Increase the number of mesh header fragmentation tag entries to address
  "Failed to get forwarded frame priority" notice messages in logs. Note that
  these types of messages are non-critical (default priority will be applied in
  that case).
- Make some compile time configurations via project header file

## 2.12.2

- Update flasher script to work with Home Assistant Yellow with CM5

## 2.12.1

- Fix possible race condition between otbr-agent-configure and otbr-agent-rest-discovery
  services causing failed startup ([#3826](https://github.com/home-assistant/addons/issues/3826))

## 2.12.0

- Bump universal-silabs-flasher to 0.0.23
- Bump OTBR firmwares to latest versions
- Bump to OTBR POSIX version b041fa52daa (2024-11-14 08:18:28 -0800)
- Add radio firmware version to discovery information

## 2.11.1

- Fix issue with USB TI CC2652 based devices

## 2.11.0

- Bump to OTBR POSIX version ff7227ea9a2 (2024-09-25 14:54:08 -0700)
- Make log output unbuffered
- Avoid ipset errors when firewall is disabled

## 2.10.0

- Bump to OTBR POSIX version b66cabfaa0 (2024-08-14 08:01:56 -0700)
- Avoid OTBR Web spamming system console
- Bump universal SiLabs flasher to 0.0.22

## 2.9.1

- Abort firmware flasher if network device is selected

## 2.9.0

- Avoid triggering reset/boot loader on TI CC2652 based devices

## 2.8.0

- Bump to OTBR POSIX version 41474ce29a (2024-06-21 08:41:31 -0700)

## 2.7.0

- Support auto firmware updates for Sonoff ZBDongle-E
- Support auto firmware updates for SMLIGHT SLZB-07
- Bump universal SiLabs flasher to 0.0.20

## 2.6.0

- Add support for network sockets using socat

## 2.5.1

- Support Home Assistant Connect ZBT-1.

## 2.5.0

- Bump to OTBR POSIX version 2279c02f3c (2024-02-28 22:36:55 -0800)
- Bump base image to Debian bookworm

## 2.4.7

- Better fix for container shutdown in case of OTBR agent failures

## 2.4.6

- Bump to OTBR POSIX version 9bdaa91016 (2024-02-15 08:50:34 -0800)
- Bump universal SiLabs flasher to 0.0.18
- Fix container shutdown in case OTBR agent fails to startup
- Shutdown mDNS daemon after OTBR agent (allows the OTBR service to
  properly sign off on the network)

## 2.4.5

- Set default transmit power on startup
- Enable DNS when NAT64 is enabled
- Bump universal SiLabs flasher to 0.0.17
- Bump to OTBR POSIX version 13d583e361 (2024-01-26 09:51:26 -0800)

## 2.4.4

- Fix Thread network interface (wpan0) route metric
  This fixes devices becoming unreachable when operating the OTBR with other TBRs
- Bump to OTBR POSIX version 02421b0ea6 (2024-01-19 15:58:03 -0800)

## 2.4.3

- Enable TREL support on infrastructure link
- Enable Channel Monitor support (disabled by default)
- Bump to OTBR POSIX version 657e775cd9 (2024-01-05 17:10:13 -0800)

## 2.4.2

- Update firmare for Home Assistant SkyConnect and Yellow to the latest version
  built from Gecko SDK v4.4.0.0.
- Bump universal SiLabs flasher to 0.0.16

## 2.4.1

- Fix NAT64 enable script

## 2.4.0

- Enable TREL
- Enable NAT64 (disabled by default)
- Bump to OTBR POSIX version 27ed99f375 (2023-12-13 10:11:52 -0800)
- Bump universal SiLabs flasher to 0.0.15
- Shutdown add-on on otbr-agent crash (use Supervisor Watchdog functionality
  for automatic restarts)

## 2.3.2

- Bump to OTBR POSIX version 9e50efa8de (2023-08-23 21:28:30 -0700)
  This updates mDNSResponder to 1790.80.10

## 2.3.1

- Update firmare for Home Assistant SkyConnect and Yellow to the latest version
  built from Gecko SDK v4.3.1.0.

## 2.3.0

- Bump to OTBR POSIX version 8d12b242db (2023-07-13 20:00:34 +0200)
  This update includes the new REST API to reset the OTBR
- Bump universal SiLabs flasher to 0.0.13
- Use add-on hostname to connect to OTBR REST API

## 2.2.0

- Update firmare for Home Assistant SkyConnect and Yellow to the latest version
  built from Gecko SDK v4.3.0.0.

## 2.1.0

- Add REST API patches to fix a bugs and support deleting datasets

## 2.0.0

- Bump to OTBR POSIX version f46f68956b (2023-05-23 09:28:30 -0700)
  This update includes the new REST API part of upstream OTBR

## 1.2.0

- Fix firmware flashing on Home Assistant Yellow
- Bump universal SiLabs flasher to 0.0.12
- Bump to OTBR POSIX version cbeaf817c5 (2023-03-29 11:06:31 -0700)
- Don't start Web interface unnecessarily

## 1.1.0

- Automatically flash firmware for Home Assistant SkyConnect and Yellow
- Update serial port defaults to match latest firmware builds
- Drop armv7 support

## 1.0.0

- Bump to OTBR POSIX version d83fee189a (2023-02-28 08:48:56 -0800)
- Remove Web UI via ingress (expose ports to use the Web UI, see documentation)
- Change vendor name to "Home Assistant" and product name to Silicon Labs
  Multiprotocol" (used in OTBR mDNS/DNS-SD announcments)
- Set default baudrate 115200 correctly
- Let the OTBR REST API listen on local interface only by default
- Fix REST API to correctly set the Connection HTTP header
- Fix REST API to return an HTTP compliant status line
- Add OTBR discovery support

## 0.3.0

- Bump to OTBR POSIX version 079bbce34a (2022-12-22 19:00:41 -0800)
- Add REST API with full active and pending dataset as well as state support
- Avoid start error in case multiple primary interfaces are returned
- Add fine grained OTBR log level control
- Fix service stop (finish) scripts

## 0.2.6

- Accept IPv6 forwarding explicitly (required for HAOS 9.x)
- Add egress firewall rules for forwarding if firewall is enabled

## 0.2.5

- Bump to OTBR POSIX version 110eb2507c (2022-11-24 14:36:14 -0800)

## 0.2.4

- Bump to OTBR POSIX version 0e15296792 (2022-11-07 12:33:00 +0100)

## 0.2.3

- Fix Firewall shutdown

## 0.2.2

- Bump to OTBR POSIX version 9fea68cfbe (2022-06-03 11:53:19 -0700)
- Use s6-overlay v3 style services

## 0.2.1

- Fix missing common script

## 0.2.0

- Support OpenThread Border Router firewall to avoid unnecessary traffic in the
  OpenThread network.

## 0.1.4

- Enable OpenThread diagnostic mode

## 0.1.3

- Fix startup without hardware flow control

## 0.1.2

- Bump OTBR to ot-br-posix git f8399eb08/openthread git 7dfde1f12

## 0.1.1

- Add baudrate and hardware flow control configurations

## 0.1.0

- initial version
