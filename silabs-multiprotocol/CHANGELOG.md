# Changelog

## 2.4.6

> [!CAUTION]
> This app is deprecated and will be removed in the future. This is a last
> compatibility update to avoid the app breaking with newer Supervisor
> releases; it receives no further updates. If the app is not in use
> (e.g. it is not running), uninstall it. Otherwise, please migrate away from
> multiprotocol: Update to Home Assistant Core 2026.6.0 or newer, which offers
> a repair to migrate your Home Assistant Yellow or Connect ZBT-1 / SkyConnect
> back to Zigbee firmware. Alternatively, follow the procedure to
> [disable multiprotocol](https://connectzbt1.home-assistant.io/procedures/disable-multiprotocol/)
> manually.

- Declare the `NET_RAW` capability, which the app needs but did not request.
- Declare the `/dev/net/tun` device used by OpenThread Border Router.
- The app image is unchanged from 2.4.5.

> [!WARNING]
> Known issue on Home Assistant OS 18 and later: `otbr_firewall: false` makes
> the OpenThread Border Router start script call `ip6tables-legacy`, which
> fails because the kernel no longer provides the legacy IPv6 filter table.
> `otbr-agent` then exits with code 3 in a loop and Thread stops working.
> Keep `otbr_firewall` set to `true` (the default).

## 2.4.5
- Support Home Assistant Connect ZBT-1.

## 2.4.4
- Revert back to Silicon Labs Gecko SDK 4.3.1 while 4.4.0 instability is investigated.
- Backport firmware modifications for improved stability.
- Bump universal SiLabs flasher to 0.0.17

## 2.4.3
- ⚠️ Zigbee2MQTT does not yet support this version of the Gecko SDK. Do not update if you are using Z2M! ⚠️.
- This is a re-release of 2.4.0 that is compatible only with Home Assistant Core 2024.1.0 and above.

## 2.4.2
- Bump universal SiLabs flasher to 0.0.16 so that firmware is successfully installed on startup.

## 2.4.1

- Revert back to Silicon Labs Gecko SDK 4.3.1 to maintain compatibility with Home Assistant Core 2023.12.0 and Zigbee2MQTT. If you are running 2024.1.0 with ZHA, you don't have to downgrade.

## 2.4.0

- Use Silicon Labs Gecko SDK 4.4.0
- Bump universal SiLabs flasher to 0.0.16
- Improved firmware configurations for Home Assistant Yellow and SkyConnect
  for stability (without ZGP, with watchdog)

## 2.3.2

- Update mDNSResponder to 1790.80.10

## 2.3.1

- Use Silicon Labs Gecko SDK 4.3.1

## 2.3.0

- Add patch with new REST API to reset the OTBR
- Bump universal SiLabs flasher to 0.0.13

## 2.2.0

- Use Silicon Labs Gecko SDK 4.3.0
  - With this we get the OTBR version from May 17th, along with Border Agent ID
    support (required for Android and iOS APIs)
- Note: This update needs a new Multi-PAN firmware. Home Assistant SkyConnect and Yellow get automatically updated by this add-on.

## 2.1.0

- Add REST API patches to fix a bugs and support deleting datasets

## 2.0.0

- Update OpenThread REST API to latest upstreamed API variant

## 1.1.3

- Use native zigbeed on x86-64/amd64 architecture
- Avoid deleting otbr-web user content twice

## 1.1.2

- Use Silicon Labs Gecko SDK 4.2.3
- Avoid starting mdnsd when OpenThread Border Router is not enabled

## 1.1.1

- Bugfix: bump universal SiLabs flasher to 0.0.12 for amd64

## 1.1.0

- Use default baudrate of 460800 (WARNING: You MUST update your configuration!)
- Bump universal SiLabs flasher to 0.0.12

## 1.0.2

- Use Silicon Labs Gecko SDK 4.2.2

## 1.0.1

- Use host namespace for hostname (make sure that the BR is announced with the
  systems real hostname)

## 1.0.0

- Remove Web UI via ingress (expose ports to use the Web UI, see documentation)
- Change vendor name to "Home Assistant" and product name to Silicon Labs
  Multiprotocol" (used in OTBR mDNS/DNS-SD announcments)

## 0.13.1

- Set default baudrate 115200 correctly
- Prevent OTBR discovery service from start when OTBR is disabled
- Fix REST API to correctly set the Connection HTTP header on amd64
- Fix network device support (properly start socat if necessary) on amd64

## 0.13.0

- Use Silicon Labs Gecko SDK 4.2.1
- Let the OTBR REST API listen on local interface only by default
- Automatically flash firmware by default
- Disable OTBR web interface by default (see documentation)
- Fix network device support (properly start socat if necessary)

## 0.12.0

- Use Silicon Labs Gecko SDK 4.1.4

## 0.11.4

- Fix REST API to correctly set the Connection HTTP header

## 0.11.3

- Fix REST API to return an HTTP compliant status line

## 0.11.2

- Add OTBR discovery support

## 0.11.1

- Update REST API with full active and pending dataset as well as state support

## 0.11.0

- Use Silicon Labs Gecko SDK 4.2.0

## 0.10.0

- Add REST API to get and set the active dataset to the OpenThrad Border Router

## 0.9.1

- Avoid start error in case multiple primary interfaces are returned
- Fix zigbeed argument parsing for 32-bit add-on
- Remove unnecessary error message "Cannot open file /usr/local/etc/zigbeed.conf"

## 0.9.0

- Allow IPv6 forwarding explicitly (required for HAOS 9.x without firewall)
- Add OTBR firewall option (enabled by default, requires HAOS 9.4 or newer)
- Add egress firewall rules for forwarding
- Add fine grained OTBR log level control
- Fix service stop (finish) scripts

## 0.8.1

- Bugfix: give GPIO permissions to container to allow flashing Yellow

## 0.8.0

- Initial AMD64/x86-64 support (zigbeed via QEMU)
- Increase multicast table size to 16 (as expected by ZHA by default)

## 0.7.2

- Fix OTBR enable flag (allow to disable the OTBR)
- Fix zigbeed and cpcd finish scripts
- Start banner after initialization scripts

## 0.7.1

- Bump universal SiLabs flasher to 0.0.7
- Use baudrate 115200 by default
- Add Docker health check to monitor zigbeed

## 0.7.0

- Support firmware flashing for Home Assistant SkyConnect/Yellow
- Allow quick reconnects by ZHA (required during config flow)

## 0.6.2

- Use Silicon Labs Gecko SDK 4.1.3

## 0.6.1

- Use Silicon Labs Gecko SDK 4.1.2

## 0.6.0

- Implement native TCP/IP support for zigbeed (requires bellows 0.34.0 or newer)
- Bind only to add-ons local address

## 0.5.1

- Use Silicon Labs Gecko SDK 4.1.1
- Readd aarch64 support

## 0.5.0

- Use Silicon Labs Gecko SDK 4.1.0
- Build zigbeed from source (as binaries are no longer provided)
- Bump OTBR to Silicon Labs forked version of Gecko SDK v4.1.0
  (based on OTBR POSIX version 3a98779dc9 (2022-06-02 09:34:58 -0700))
- Use s6-overlay v3 style services
- Drop aarch64 support (all CPC communication blocks on aarch64 since 4.1.0)

## 0.4.1

- Support network device (CPC daemon via TCP/IP socket)

## 0.4.0

- Use Silicon Labs Gecko SDK 4.0.2
- Enable native aarch64 support
- Support baudrate and hardware flow control

## 0.3.1

- Fix permissions to make otbr-agent start correctly
- Add OpenThread Border Router web frontend via ingress

## 0.3.0

- Initial OpenThread support

## 0.2.0

- Use Silicon Labs Gecko SDK 4.0.1
- Fix port description

## 0.1.0

- initial version
