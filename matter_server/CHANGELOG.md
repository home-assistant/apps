# Changelog

## 9.3.0

- Update [Matter Server from 1.4.0 to 1.5.5](https://github.com/matter-js/matterjs-server/blob/main/CHANGELOG.md)
  - Supports Matter 1.6.1 with many optimizations and fixes to the Matter stack
  - Add a convenient camera API for WebRTC stream management
  - Many new Dashboard cluster command panels and endpoint label/semantic tag display
  - Multiple Optimizations and Fixes in WebRTC/camera handling and node availability reporting

## 9.2.0

- Update [Matter Server from 1.3.3 to 1.4.0](https://github.com/matter-js/matterjs-server/blob/main/CHANGELOG.md)
  - Expose Network visualization data to enable external visualization of the networks
  - Multiple Optimizations and Enhancements in the Server Dashboard
  - Add support for custom cluster data from WAGO devices
  - Multiple Optimizations and Fixes in the Matter protocol stack

## 9.1.1

- Update [Matter Server from 1.2.6 to 1.3.3](https://github.com/matter-js/matterjs-server/blob/main/CHANGELOG.md)
  - Optimizations in the Dashboard for Camera, Time-Synchronization, ICD devices and Thread visualization
  - Optimizations and fixes for commissioning and operation of the Matter devices
- Change Matter server panel icon

## 9.1.0

- Update [Matter Server from 1.1.7 to 1.2.6](https://github.com/matter-js/matterjs-server/blob/main/CHANGELOG.md)
  - Supports Matter 1.6.0
  - Synchronize Time to devices that support this
  - Experimental Support for Battery Saving mode of ICD devices
  - Many Optimizations and Fixes
- Add `time_sync` option (`auto`/`on`/`off`, default `auto`) to push the current time to Matter devices via the Matter Server's `--enable-time-sync` flag. `auto` enables time sync only when the host clock is NTP synchronized; `on` always enables it (with a warning if NTP is not synchronized); `off` disables it.
- Add `default_fabric_label` option to pin the fabric label via the Matter Server's `--default-fabric-label` flag. When set, changing the label via the WebSocket API is blocked.

## 9.0.4

- Update [Matter Server from 1.1.2 to 1.1.7](https://github.com/matter-js/matterjs-server/blob/main/CHANGELOG.md#117-2026-07-01) to address reported issues and optimize RAM and CPU usage (a lot)

## 9.0.3

- Update [Matter Server from 1.1.1 to 1.1.2](https://github.com/matter-js/matterjs-server/blob/main/CHANGELOG.md#112-2026-06-25) to address reported issues

## 9.0.2

- Update Matter Server to 1.1.1 with increased Health check timings
- Speed up Beta version installation

## 9.0.1

- Fixes Heath check with default port settings

## 9.0.0

- **The Matter Server now runs on matter.js. Expect the first start to take noticeably longer while your data migrates automatically — this is normal.**
  - **⚠️ It is recommended to take a backup before updating.**
  - **⚠️ If you have enabled the watchdog in HA, please disable for the initial migration to prevent restarts.**
  - The new matter server needs roughly twice the RAM of the old one, so please check free resources before updating.
  - The Python Matter Server has been replaced with a matter.js-based implementation (v1.1.0); your data migrates automatically with no action required
  - Later starts are much faster
- New Matter Server features:
  - The web UI dashboard adds Thread and Wi-Fi network visualizations, plus many other improvements
  - Experimental BLE proxy support via the `ble_proxy` option, for commissioning via BLE proxies from the Matter Server dashboard
- If you enabled the **Beta** flag for the earlier matter.js beta, it stays on; matter.js is now the default, so you can turn it off — keep it on to keep testing pre-releases
- For more details, see the [Migration FAQ](https://github.com/home-assistant/addons/blob/master/matter_server/MIGRATION_FAQ.md)

## 8.5.0

- Add `ble_proxy` option to expose the Matter Server's BLE proxy endpoint, so the Home Assistant Matter integration can drive BLE commissioning through Home Assistant's bluetooth stack (including ESPHome BLE proxies). To actually use this BLE proxy you need Home Assistant 2026.06 or later (the Matter integration support landed there) and the Beta Matter Server (>= 0.7.1, JavaScript-based); mutually exclusive with `bluetooth_adapter_id` (the local adapter is ignored with a warning when `ble_proxy` is enabled).

## 8.4.0

- Skip `--log-level-sdk` for JavaScript Matter Server (beta mode); it is now only passed to the Python server
- Skip `--paa-root-cert-dir` for JavaScript Matter Server (beta mode); it is now only passed to the Python server
- Conditionally pass `--ota-provider-dir` for JavaScript Matter Server (beta mode) only when `enable_test_net_dcl` is also enabled; the Python server continues to receive it unconditionally

## 8.3.0

- Add `matter_server_env_vars` option to export custom environment variables before starting Matter Server
- Respect `matter_server_version` in JavaScript/Beta mode (but only for `0.x.y` and `1.x.y` values; ignore all other values and install latest)

## 8.2.2

- Install make and gcc as well

## 8.2.1

- Install the necessary packages to allow BLE to work

## 8.2.0

- Switch to the new [matter.js-based Matter Server](https://github.com/matter-js/matterjs-server) when enabling the **Beta** option
  - Existing data is migrated automatically with no user action required
  - Users can switch back to the Python-based Matter Server at any time
- Add Node.js to the add-on container

## 8.1.2

- Bump Python Matter Server to [8.1.2](https://github.com/matter-js/python-matter-server/releases/tag/8.1.2)

## 8.1.1

- Bump Python Matter Server to [8.1.1](https://github.com/matter-js/python-matter-server/releases/tag/8.1.1)

## 8.1.0

- Bump Python Matter Server to [8.1.0](https://github.com/home-assistant-libs/python-matter-server/releases/tag/8.1.0)
- Update bashio to 0.17.1

## 8.0.0

- Bump Python Matter Server to [8.0.0](https://github.com/home-assistant-libs/python-matter-server/releases/tag/8.0.0)

## 7.0.0

- Bump Python Matter Server to [7.0.1](https://github.com/home-assistant-libs/python-matter-server/releases/tag/7.0.1)
  - This updates Matter to 1.4
- Update base image components to what is being used in Home Assistant Debian
  base images:
  - Update tempio to 2024.11.2
  - Update s6-overlay to 3.1.6.2
  - Update bashio to 0.16.2

## 6.6.1

- Bump Python Matter Server to [6.6.1](https://github.com/home-assistant-libs/python-matter-server/releases/tag/6.6.1)

## 6.6.0

- Bump Python Matter Server to [6.6.0](https://github.com/home-assistant-libs/python-matter-server/releases/tag/6.6.0)

## 6.5.1

- Bump Python Matter Server to [6.5.1](https://github.com/home-assistant-libs/python-matter-server/releases/tag/6.5.1)

## 6.5.0

- Bump Python Matter Server to [6.5.0](https://github.com/home-assistant-libs/python-matter-server/releases/tag/6.5.0)

## 6.4.2

- Add support for custom Matter Server arguments
- Add support to install custom Matter Server and Matter SDK (CHIP) versions

## 6.4.1

- Bump Python Matter Server to [6.4.0](https://github.com/home-assistant-libs/python-matter-server/releases/tag/6.4.0)

## 6.4.0

- Use add-on config directory as update directory

## 6.3.1

- Fix Matter SDK log level when using beta flag

## 6.3.0

- Bump Python Matter Server to [6.3.0](https://github.com/home-assistant-libs/python-matter-server/releases/tag/6.3.0)

## 6.2.1

- Bump Python Matter Server to [6.2.1](https://github.com/home-assistant-libs/python-matter-server/releases/tag/6.2.1)

## 6.1.2

- Bump Python Matter Server to [6.1.2](https://github.com/home-assistant-libs/python-matter-server/releases/tag/6.1.2)

## 6.1.1

- Bump Python Matter Server to [6.1.1](https://github.com/home-assistant-libs/python-matter-server/releases/tag/6.1.1)

## 6.1.0

- Bump Python Matter Server to [6.1.0](https://github.com/home-assistant-libs/python-matter-server/releases/tag/6.1.0)
  - This update is required for Home Assistant Core 2024.6.0

## 6.0.0

- Bump Python Matter Server to [6.0.0](https://github.com/home-assistant-libs/python-matter-server/releases/tag/6.0.0)
  - This updates Matter to 1.3

## 5.6.0

- Bump Python Matter Server to [5.10.0](https://github.com/home-assistant-libs/python-matter-server/releases/tag/5.10.0)

## 5.5.1

- Fix logging in case fallback method for determining the primary network interface is used

## 5.5.0

- Bump Python Matter Server to [5.9.0](https://github.com/home-assistant-libs/python-matter-server/releases/tag/5.9.0)
- Enable Ingress for the Python Matter Server built-in web interface
- Store PAA root certificates in /data to avoid download on every startup (downloads once a day)

## 5.4.1

- Bump Python Matter Server to [5.8.1](https://github.com/home-assistant-libs/python-matter-server/releases/tag/5.8.1)

## 5.4.0

- Bump Python Matter Server to [5.8.0](https://github.com/home-assistant-libs/python-matter-server/releases/tag/5.8.0)

## 5.3.0

- Bump Python Matter Server to [5.7.0](https://github.com/home-assistant-libs/python-matter-server/releases/tag/5.7.0)
- Add Matter SDK log options

## 5.2.0

- Bump Python Matter Server to [5.6.0](https://github.com/home-assistant-libs/python-matter-server/releases/tag/5.6.0)

## 5.1.2

- Bump Python Matter Server to [5.5.3](https://github.com/home-assistant-libs/python-matter-server/releases/tag/5.5.3)

## 5.1.1

- Bump Python Matter Server to [5.5.2](https://github.com/home-assistant-libs/python-matter-server/releases/tag/5.5.2)

## 5.1.0

- Bump Python Matter Server to [5.5.1](https://github.com/home-assistant-libs/python-matter-server/releases/tag/5.5.1)
- Bind Python WebSocket on internal interface only by default

## 5.0.4

- Correctly bump Python Matter Server to [5.2.1](https://github.com/home-assistant-libs/python-matter-server/releases/tag/5.2.1)

## 5.0.3

- Bump Python Matter Server to [5.2.1](https://github.com/home-assistant-libs/python-matter-server/releases/tag/5.2.1)
- Pass primary interface to Python Matter server

## 5.0.2

- Bump Python Matter Server to [5.1.4](https://github.com/home-assistant-libs/python-matter-server/releases/tag/5.1.4)

## 5.0.1

- Bump Python Matter Server to [5.0.3](https://github.com/home-assistant-libs/python-matter-server/releases/tag/5.0.3)
- Fix matter-server finish script to report exit code
- Attach gdb debugger in beta mode to print stack traces on crash

## 5.0.0

- Bump Python Matter Server to [5.0.1](https://github.com/home-assistant-libs/python-matter-server/releases/tag/5.0.1)
- Bump minimum required Home Assistant core version to 2023.12 due to breaking changes in the schema

## 4.10.2

- Bump Python Matter Server to [4.0.2](https://github.com/home-assistant-libs/python-matter-server/releases/tag/4.0.2)

## 4.10.1

- Bump Python Matter Server to [4.0.1](https://github.com/home-assistant-libs/python-matter-server/releases/tag/4.0.1)

## 4.10.0

- Add beta flag to the add-on which installs Python Matter Server pre-releases at startup.

## 4.9.0

- Bump Python Matter Server to [3.7.0](https://github.com/home-assistant-libs/python-matter-server/releases/tag/3.7.0)

## 4.8.3

- Bump Python Matter Server to [3.6.4](https://github.com/home-assistant-libs/python-matter-server/releases/tag/3.6.4)

## 4.8.2

- Bump Python Matter Server to [3.6.3](https://github.com/home-assistant-libs/python-matter-server/releases/tag/3.6.3)

## 4.8.1

- Bump Python Matter Server to [3.6.2](https://github.com/home-assistant-libs/python-matter-server/releases/tag/3.6.2)

## 4.8.0

- Bump Python Matter Server to [3.6.1](https://github.com/home-assistant-libs/python-matter-server/releases/tag/3.6.1)

## 4.7.0

- Use the Python Matter Server container as base
- Bump Python Matter Server to [3.5.2](https://github.com/home-assistant-libs/python-matter-server/releases/tag/3.5.2)

## 4.6.1

- Bump Python Matter Server to [3.5.1](https://github.com/home-assistant-libs/python-matter-server/releases/tag/3.5.1)
  - Various small bug/stability fixes

## 4.6.0

- Bump Python Matter Server to [3.5.0](https://github.com/home-assistant-libs/python-matter-server/releases/tag/3.5.0)
  - Uses libnl based address selection to avoid using deprecated/temporary IP addresses
  - libnl avoids "Endpoint pool full" errors as well
- Add dependency to support libnl based IP address selection

## 4.5.1

- Bump Python Matter Server to [3.4.2](https://github.com/home-assistant-libs/python-matter-server/releases/tag/3.4.2)

## 4.5.0

- Bump Python Matter Server to [3.4.1](https://github.com/home-assistant-libs/python-matter-server/releases/tag/3.4.1)
- Bump to Python 3.11

## 4.4.0

- Bump Python Matter Server to [3.4.0](https://github.com/home-assistant-libs/python-matter-server/releases/tag/3.4.0)
  - This updates Matter to 1.1
- Update S6 Overlay to v3.1.5.0

## 4.3.1

- Bump Python Matter Server to [3.3.1](https://github.com/home-assistant-libs/python-matter-server/releases/tag/3.3.1)

## 4.3.0

- Bump Matter Server to [3.3.0](https://github.com/home-assistant-libs/python-matter-server/releases/tag/3.3.0)

## 4.2.0

- Bump Matter Server to [3.2.0](https://github.com/home-assistant-libs/python-matter-server/releases/tag/3.2.0)
- Significantly reduced add-on size

## 4.1.0

- Bump Matter Server to [3.1.0](https://github.com/home-assistant-libs/python-matter-server/releases/tag/3.1.0)

## 4.0.0

- Bump Matter Server to [3.0.0](https://github.com/home-assistant-libs/python-matter-server/releases/tag/3.0.0)

## 3.1.0

- Use Python 3.10

## 3.0.4

- Bump Matter Server to [2.1.1](https://github.com/home-assistant-libs/python-matter-server/releases/tag/2.1.1)
- Drop unnecessary Python dependencies from image

## 3.0.3

- Bump Matter Server to [2.1.0](https://github.com/home-assistant-libs/python-matter-server/releases/tag/2.1.0)

## 3.0.2

- Bump Matter Server to [2.0.2](https://github.com/home-assistant-libs/python-matter-server/releases/tag/2.0.2)

## 3.0.1

- Bump Matter Server fabric ID after changing vendor ID

## 3.0.0

- Bump Matter Server to 2.0.1
- Use Nabu Casa Vendor ID by default

### Breaking

- All commissioned devices need to be recommissioned.

## 2.1.0

- Bump Matter Server to 1.1.0

## 2.0.0

- Require Home Assistant Core 2023.1.0b1 to install the add-on. The chip SDK was bumped in [Matter Server 1.0.8](https://github.com/home-assistant-libs/python-matter-server/releases/tag/1.0.8).

## 1.2.0

- Bump Matter Server to 1.0.8
- Bump pre-built Matter SDK wheels to 2022.12.0
- Make sure production PAA certificates work too

## 1.1.2

- Get most recent certificates from master branch

## 1.1.1

- Fix startup when Matter Server WebSocket port is not exposed

## 1.1.0

- Allow to set Matter Server logging level
- Set storage path correctly
- Fix support for custom port

## 1.0.7

- Bump Matter Server to 1.0.7

## 1.0.6

- Bump Matter Server to 1.0.6

## 1.0.5

- Bump Matter Server to 1.0.5

## 1.0.4

- Bump Matter Server to 1.0.4

## 1.0.1

- Bump Matter Server to 1.0.1
- Use pre-built Matter SDK (CHIP) wheels

## 0.4.0

- Add add-on discovery

## 0.3.0

- Bump to CHIP version 989ad8e (2022-09-16 16:52 -0500) (start of the v1 branch!)
- Bump Matter Server to 0.3.0

## 0.2.2

- Bump to CHIP version 5b603f3874 (2022-07-05 21:21:19 -0700)
- Bump Matter Server to 0.2.3
- Avoid cloning not required git repositories during build speedup build process

## 0.2.1

- Bump Matter Server to 0.2.2

## 0.2.0

- Bump to CHIP version 5d8599d195 (2022-06-09 12:57:45 -0400)
- Bump Matter Server to 0.2.1

## 0.1.2

- Bump Matter Server to first official release 0.1.0

## 0.1.1

- Fix Matter Server start location so it can find device certificates
- Bump Matter Server to git version ac5545b (2022-06-11 00:04:34 +0200)

## 0.1.0

- initial version
- CHIP version 55ab764bea (2022-06-06 23:10:48 -0400)
