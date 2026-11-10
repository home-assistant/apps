# Changelog

## 1.11.0

### Z-Wave JS 15.31.2...15.32.3

#### Features

- ESPHome encryption keys no longer have to be URL-encoded manually

#### Bugfixes

- OTA firmware updates can now be queued for multiple devices and are transferred one at a time
- Hardened firmware update, download, extraction, and transfer
- Hardened NVM backup and restore
- Improved the data validation and error handling in several command handlers
- Scene labels are now updated automatically without a re-interview
- Fixed several issues with connections to ESPHome based Z-Wave proxies
- Tons of smaller stability improvements

#### Config file changes

- Add Heatit Z-Smoke2 230V and allow Basic Set interconnects
- Add a setpoint range of 4-28 °C to Danfoss LC-13
- Preserve and label endpoints on Qubino Flush Dimmer Plus (ZMNHDD)
- Remove undocumented endpoint labels on Heatit Z-Push Button 4
- Add the missing third switch label on McoHome MH-S513
- Group shutter endpoints on Shelly Wave Shutter (QLSH-001P10EU)
- Correct endpoint 2 and group the blind on Qubino Flush Shutter DC (ZMNHOD)
- Add the digital port mode and endpoint names to Quby 6500-1400-6000
- Add endpoint labels to several Fibaro and Shelly devices
- Add the NOVON manufacturer and five of its devices
- Add Central Scene labels for 61 devices

### Detailed changelogs

- [Z-Wave JS UI 11.26.2](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.26.2)
- [Z-Wave JS UI 11.26.1](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.26.1)
- [Z-Wave JS UI 11.26.0](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.26.0)
- [Z-Wave JS UI 11.25.2](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.25.2)
- [Z-Wave JS 15.32.3](https://github.com/zwave-js/zwave-js/releases/tag/v15.32.3)
- [Z-Wave JS 15.32.2](https://github.com/zwave-js/zwave-js/releases/tag/v15.32.2)
- [Z-Wave JS 15.32.1](https://github.com/zwave-js/zwave-js/releases/tag/v15.32.1)
- [Z-Wave JS 15.32.0](https://github.com/zwave-js/zwave-js/releases/tag/v15.32.0)
- [Z-Wave JS Server 3.12.0](https://github.com/zwave-js/zwave-js-server/releases/tag/3.12.0)

## 1.10.0

### Z-Wave JS 15.31.1...15.31.2

#### Bugfixes

- Reject invalid statuses in Powerlevel Test Node Reports
- Set the device class to Static Controller when migrating controllers to the 700 or 800 series

#### Config file changes

- Group whole-device control aggregates on Zipato/Philio PAN04
- Group whole-device control aggregates on Vemmio DS100
- Group whole-device totals on Zipato/Philio PAB01 energy meters
- Group whole-device totals on Qubino 3-Phase Smart Meter (ZMNHXD)
- Group all endpoints on Aeotec Indoor Siren 6 (ZW164)
- Group variable-speed pump endpoints for Intermatic PE653
- Group shutter endpoints for Shelly Wave Shutter (QNSH-001P10)
- Group shutter endpoints for Qubino Flush Shutter DC (ZMNHCD)
- Correct the Merten 506004 device configuration
- Send Multilevel Switch v1 frames to the Springs RSZ1

### Z-Wave JS UI 11.24.3...11.25.1

#### Features

- Add an option to enable Configuration CC entities by default
- Limit column filter choices to values in the filtered rows
- Show minimum, maximum, and step values in value hints

#### Bugfixes

- Allow boolean actuators on broadcast and multicast nodes to be turned off
- Correct Home Assistant discovery for kVAh and pulse count electric meters
- Use the circuit 4 state topic for Intermatic PE653 circuit 4
- Generate valid color temperature value templates for warm and cold white lights
- Clear retained MQTT discovery and value topics with an empty payload
- Explain that SmartStart names and locations are shared with integrations
- Improve firmware warning grammar
- Preserve network graph filters when clicking the background
- Scroll navigation tabs when their labels do not fit
- Wrap long option labels in value dropdowns

### Detailed changelogs

- [Z-Wave JS UI 11.25.1](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.25.1)
- [Z-Wave JS UI 11.25.0](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.25.0)
- [Z-Wave JS 15.31.2](https://github.com/zwave-js/zwave-js/releases/tag/v15.31.2)

## 1.9.1

### Z-Wave JS 15.31.0...15.31.1

#### Bugfixes

- Resolved an issue preventing `restoreNVM()` and 500-series OTW updates from aborting during soft reset
- Retry the original command after a delay when nodes respond with "Application Busy" instead of the expected response
- Fixed an issue where `maxDataRate` could become `-Infinity` for ready nodes without a known data rate
- Prevent multiple network-wide route rebuilds from running simultaneously

#### Config file changes

- Name and group the endpoints of the Aeotec HEM 8
- Add a manual value refresh delay for Leviton VRI06
- Add manual refresh delays for Leviton VRMX1 and VRS15

### Detailed changelogs

- [Z-Wave JS UI 11.24.3](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.24.3)
- [Z-Wave JS 15.31.1](https://github.com/zwave-js/zwave-js/releases/tag/v15.31.1)

## 1.9.0

### Z-Wave JS 15.29.0...15.31.0

#### Features

- Add support for grouping endpoints

#### Config file changes

- Add a manual refresh delay for Leviton DZ6HD
- Correct Shelly Wave Shutter moving time units
- Update the Aeotec ZWA056 Water Sensor 8 configuration
- Correct the acceleration sensor unit factor for Aeotec ZWA055 Door / Window Sensor 8
- Add Aeotec ZWA066 MultiSensor 8
- Add Shenzhen Neo NAS-WS02Z Water Sensor
- Add Nice FGD-223 Double Dimmer-Control
- Fix several Qubino ZMNHTD parameter errors
- Correct the value size of Qubino ZMNHTD parameter 40
- Map root reports to endpoint 1 on Remotec ZXT-800 and add a fingerprint
- Fix configuration conditions with invalid firmware version formatting that never matched

### Detailed changelogs

- [Z-Wave JS UI 11.24.2](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.24.2)
- [Z-Wave JS 15.31.0](https://github.com/zwave-js/zwave-js/releases/tag/v15.31.0)
- [Z-Wave JS 15.30.0](https://github.com/zwave-js/zwave-js/releases/tag/v15.30.0)
- [Z-Wave JS Server 3.11.0](https://github.com/zwave-js/zwave-js-server/releases/tag/3.11.0)

## 1.8.1

### Z-Wave JS Server 3.10.2

#### Bugfixes

- Fixes an issue that could prevent clients from receiving "node removed" events
- Refuse new client connections while the driver is temporarily not ready

### Detailed changelogs

- [Z-Wave JS UI 11.24.1](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.24.1)
- [Z-Wave JS Server 3.10.2](https://github.com/zwave-js/zwave-js-server/releases/tag/3.10.2)

## 1.8.0

### Z-Wave JS 15.27.1...15.29.0

#### Features

- Queued commands that are redundant are now deduplicated automatically

#### Bugfixes

- Fixed an issue preventing controller firmware updates from starting properly
- Work around an issue where some controllers on Z-Wave SDK 8.0.0 that had migrated from an old 500 series controller would behave like sleeping nodes
- Prevent SONOFF controllers from entering the bootloader during startup on Windows
- Correct signal-to-noise margin units from dBm to dB
- Fixed how some commands were handled internally to improve spec compliance
- Fields in incoming commands that are unexpected for the version supported by the end device are now ignored
- Fixed an issue where spurious "unknown" notification sensor entities could be created
- Fixed an issue where the regular background RSSI measurements could prevent refreshing the status of some legacy devices in some scenarios

#### Config file changes

- Fix malformed notifications from HomeSeer FS100 devices
- Add labels to several devices' endpoints
- Correct external sensor resistance options for Heatit Z-TRM7
- Add fingerprint `0x0c02:0x3002` to Fibargroup FGSD-002
- Update Zooz ZEN32 for firmware 3.30
- Add Aeotec ZWA056 Water Sensor 8
- Add Aeotec ZWA065 Siren 8
- Add Aeotec ZWA057 aërQ Temperature and Humidity Sensor 8
- Add Aeotec ZWA055 Door / Window Sensor 8
- Update Inovelli VZW32-SN P50 and P107 for firmware 2.4
- Add Zooz ZEN12 800LR Motion Dimmer
- Add Zooz ZEN37 parameter 10 for firmware 2.40
- Add an Off option for Heatit Z-TRM7 standby display brightness
- Update Zooz configurations for new firmware parameters
- Add Simon 100 Battery Master Roller Blind
- Update Inovelli VZW32-SN P111 to match the public documentation

### Z-Wave JS UI 11.22.3...11.24.0

#### Features

- Add a speed column to the control panel
- Add environment metadata to debug capture sessions

### Detailed changelogs

- [Z-Wave JS UI 11.24.0](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.24.0)
- [Z-Wave JS UI 11.23.0](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.23.0)
- [Z-Wave JS 15.29.0](https://github.com/zwave-js/zwave-js/releases/tag/v15.29.0)
- [Z-Wave JS 15.28.0](https://github.com/zwave-js/zwave-js/releases/tag/v15.28.0)

## 1.7.1

### Z-Wave JS 15.27.0...15.27.1

#### Bugfixes

- Fixes an issue with older Z-Wave.me controllers becoming unresponsive during startup

#### Config file changes

- Add a fingerprint for the Climax SDCO smoke and carbon monoxide detector

### Detailed changelogs

- [Z-Wave JS UI 11.22.3](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.22.3)
- [Z-Wave JS 15.27.1](https://github.com/zwave-js/zwave-js/releases/tag/v15.27.1)

## 1.7.0

This release includes performance improvements for the startup phase of large networks

### Z-Wave JS 15.26.0...15.27.0

#### Features

- Added support for opening PTI Zniffer trace captures

#### Bugfixes

- Fixed an issue where zero-valued enums could be restored incorrectly from the network cache
- Continue the User Code CC interview when User Credential CC capabilities are unknown

#### Config file changes

- Add Heatit Z-TRM7 and standardize Heatit config parameters across devices
- Add product ID `0x5600` for YRM276 with the ZW3 module (700 series)
- Remove Multi Channel CC support for the Vero Duco CO2 sensor
- Update the manual URL for Lamp-ZW2

### Detailed changelogs

- [Z-Wave JS UI 11.22.2](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.22.2)
- [Z-Wave JS UI 11.22.1](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.22.1)
- [Z-Wave JS 15.27.0](https://github.com/zwave-js/zwave-js/releases/tag/v15.27.0)
- [Z-Wave JS Server 3.10.1](https://github.com/zwave-js/zwave-js-server/releases/tag/3.10.1)

## 1.6.1

Fixes the add-on taking 30 seconds to stop and exiting with code 137

## 1.6.0

This release extends the credential management functionality with a dedicated UI with support for more credential types, credential learning, and admin code support.

### Z-Wave JS 15.25.0...15.26.0

#### Features

- Ongoing interviews are now paused during inclusion, security bootstrapping, and exclusion, greatly improving reliability when adding multiple devices at once

#### Bugfixes

- Added a workaround for some locks that send an incorrect report immediately after starting credential learning
- Increased timeouts for bulk-deleting users and credentials
- Fixed several issues that could lead to stale credentials being cached

#### Config file changes

- Add UltraPro 800 Series On/Off Switch
- Add UltraPro 800 Series dimmer
- Add GR-105N device configuration
- Add Nexa ZPR-111 parameters
- Corrected and cleaned up all Fibaro device files
- Fix broken link to Honeywell T6 Pro manual

### Z-Wave JS UI 11.21.0...11.22.0

#### Features

- The statistics opt-in popup is no longer shown - this setting is fully managed in Home Assistant now

#### Bugfixes

- Improved security of the API
- Refresh broadcast virtual nodes after node removal to avoid querying removed nodes
- Separated virtual and physical devices in the nodes table
- Show group ID instead of the redundant endpoint in the association group dropdown

### Detailed changelogs

- [Z-Wave JS UI 11.22.0](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.22.0)
- [Z-Wave JS UI 11.21.1](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.21.1)
- [Z-Wave JS 15.26.0](https://github.com/zwave-js/zwave-js/releases/tag/v15.26.0)

## 1.5.0

### Z-Wave JS 15.24.2...15.25.0

#### Features

- Support reporting a node's interview progress as a percentage (0–100%)

#### Bugfixes

- Fixed an issue where Z-Wave JS could silently get stuck with a closed/failed serial port
- Fixed an issue where Scene Activation CC could be missing for some devices
- Improved handling of reports that are split across multiple frames, sometimes causing weird configuration parameter descriptions
- Fixed a driver crash that could occur when receiving certain malformed Notification Reports
- Improved compatibility with locks that support both User Code CC and User Credential CC
- Fixed an issue where setting PIN codes on older door locks could fail with a non-descriptive error message

#### Config file changes

- Add fingerprints to Kwikset HC620
- Correct label of "Twist Assist" parameter on Danalock V3-BTZE, limit to firmware < 0.22
- Add AUS/NZ fingerprint to Aeotec Water Sensor 7 Pro
- Update Zooz ZEN35 for firmware 1.40 and correct some labels
- Add Jasco 76592 (ZWN4016) In-Wall Smart Switch

### Z-Wave JS UI 11.19.1...11.21.0

#### Features

- Added support for multicast/broadcast groups
- Show a node's interview progress as a percentage

#### Bugfixes

- Apply imported node metadata correctly across both wrapped and legacy `nodes.json` formats
- Add the LZW45 to the Inovelli RGBW Home Assistant discovery template
- Keep the node index map consistent after a node is removed
- Several security improvements

### Detailed changelogs

- [Z-Wave JS UI 11.21.0](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.21.0)
- [Z-Wave JS UI 11.20.0](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.20.0)
- [Z-Wave JS 15.25.0](https://github.com/zwave-js/zwave-js/releases/tag/v15.25.0)
- [Z-Wave JS 15.24.3](https://github.com/zwave-js/zwave-js/releases/tag/v15.24.3)
- [Z-Wave JS Server 3.10.0](https://github.com/zwave-js/zwave-js-server/releases/tag/3.10.0)

## 1.4.0

### Z-Wave JS 15.24.0...15.24.2

#### Features

- Added bulk-delete APIs for credentials

#### Bugfixes

- Fixed an issue where local/remote protection state would not update in the UI after changing it
- Fix: adding users was not possible on locks using User Code CC
- Added a workaround for an issue with some controllers that could not enter inclusion mode because the SUC was missing from the network

#### Config file changes

- Map Basic Set to Binary Sensor for Fibaro FGMS001
- Add lifeline association and remove Binary Switch CC for iBlinds v2
- Add new fingerprint for Honeywell TH6320ZW2007

### Z-Wave JS UI 11.17.0...11.19.1

#### Features

- Added a **Last Awake** column for battery-powered nodes, shown as a localized date and time

#### Bugfixes

- Fixed a socket reconnection loop and a trust proxy validation error
- Restore the debug log level on driver restart during a capture session
- Fixed performance issues and glitches in the nodes table

### Detailed changelogs

- [Z-Wave JS UI 11.19.1](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.19.1)
- [Z-Wave JS UI 11.19.0](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.19.0)
- [Z-Wave JS UI 11.18.0](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.18.0)
- [Z-Wave JS UI 11.17.0](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.17.0)
- [Z-Wave JS 15.24.2](https://github.com/zwave-js/zwave-js/releases/tag/v15.24.2)
- [Z-Wave JS 15.24.0](https://github.com/zwave-js/zwave-js/releases/tag/v15.24.0)
- [Z-Wave JS Server 3.9.0](https://github.com/zwave-js/zwave-js-server/releases/tag/3.9.0)

## 1.3.0

### Z-Wave JS 15.23.2...15.23.5

#### Features

- Added a new API to manage credentials across a range of legacy and modern devices

#### Bugfixes

- Fixed an issue where connection to encrypted ESPHome Z-Wave proxies would fail when unrelated commands were received during the handshake
- Interviewed Notification CC capabilities are no longer overwritten when applying alarm mappings from compat flags

#### Config file changes

- Update parameters for Zooz ZSE44 firmware 2.40
- Add Philio PAC03 Mitsubishi IT adapter

### Z-Wave JS Server 3.8.0

#### Features

- Support the new credential API in Z-Wave JS
- Bump schema to 48

### Z-Wave JS Server 3.7.0

#### Features

- Bump schema to 47
- Add several low-level commands

### Detailed changelogs

- [Z-Wave JS UI 11.16.2](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.16.2)
- [Z-Wave JS UI 11.16.1](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.16.1)
- [Z-Wave JS 15.23.5](https://github.com/zwave-js/zwave-js/releases/tag/v15.23.5)
- [Z-Wave JS 15.23.4](https://github.com/zwave-js/zwave-js/releases/tag/v15.23.4)
- [Z-Wave JS 15.23.3](https://github.com/zwave-js/zwave-js/releases/tag/v15.23.3)
- [Z-Wave JS 15.23.2](https://github.com/zwave-js/zwave-js/releases/tag/v15.23.2)
- [Z-Wave JS Server 3.7.0](https://github.com/zwave-js/zwave-js-server/releases/tag/3.7.0)
- [Z-Wave JS Server 3.8.0](https://github.com/zwave-js/zwave-js-server/releases/tag/3.8.0)

## 1.2.0

This release corrects the Z-Wave logfile path to be consistent with the defaults used by Z-Wave JS UI.

### Z-Wave JS 15.23.0

#### Bugfixes

- Fixed an issue where Z-Wave.me UZB controllers could hang during NVM backup

#### Config file changes

- Add configuration for Inovelli VZW30-SN
- Improve configuration files for Inovelli VZW30-SN, VZW31-SN, and VZW32-SN
- Standardize **Control Associated Device** triggers across 7x series Zooz switches

### Detailed changelogs

- [Z-Wave JS 15.23.0](https://github.com/zwave-js/zwave-js/releases/tag/v15.23.0)

## 1.1.0

This release includes an improvement to how Window/Door sensors are represented. Previously exposed as several binary sensors, which did not all work for all devices, they are now exposed as a single **Opening state** sensor with three states: Closed/Open/Tilted. The Tilted state is only exposed after a device has reported this.

The old binary sensors are still supported, but will be hidden by default and removed in a future release.
Switch to the new **Opening state** sensor as soon as possible.

Note that this feature will only come into effect in Home Assistant 2026.4.0.

### Z-Wave JS 15.22.1

#### Bugfixes

- Fixes an issue where the moving state of certain covers could be stuck on "opening" or "closing"

### Z-Wave JS 15.22.0

#### Features

- Add a new synthetic **Opening state** variable with 3 states to represent door/window state: Closed/Open/Tilt

#### Bugfixes

- Reduce network congestion when automatically polling devices
- Fixed an issue where Alarm Sensor CC was not interviewed when Notification CC is supported in version 1
- User Code CC values (user codes and statuses) are no longer updated optimistically
- Reduced the memory footprint by 3-5 MB

#### Config file changes

- Improved support for Hoppe eHandle window and handle states

### Z-Wave JS UI 11.15.1

#### Features

- Simplified config parameter management for multiple similar devices using configuration templates
- The debug capture wizard can now be used to diagnose startup issues
- Optimized frontend API communication
- Setting destructive configuration parameters now requires confirmation
- Added a setting to show labels on all navigation tabs
- The network graph is now always updated live, and no longer re-layouts everything on updates
- Support value ranges with gaps in number inputs

#### Bugfixes

- Display **unknown** for null/undefined values with units and fix battery level null display
- Warn when trying to create associations for LR nodes
- Fix broken UI snackbar
- Fix background RSSI chart showing blank on second open
- Prevent logging to file when log is disabled
- Display **unknown** for CC values instead of **null** when the value represents an unknown state
- Prevent last seen time from being cut off in compact view

### Detailed changelogs

- [Z-Wave JS 15.22.1](https://github.com/zwave-js/zwave-js/releases/tag/v15.22.1)
- [Z-Wave JS 15.22.0](https://github.com/zwave-js/zwave-js/releases/tag/v15.22.0)
- [Z-Wave JS UI 11.15.1](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.15.1)
- [Z-Wave JS UI 11.15.0](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.15.0)
- [Z-Wave JS UI 11.14.0](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.14.0)
- [Z-Wave JS UI 11.13.0](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.13.0)

## 1.0.1

- Migrate security keys from the OZW format to the Z-Wave JS format automatically
- Configure Z-Wave JS's device config priority dir correctly

### Z-Wave JS 15.21.0

#### Bugfixes

- Most changes to configuration files are now applied without needing to re-interview devices
- Disconnected batteries no longer expose a battery level of 0% and instead show as unavailable
- Hide unnecessary Basic CC and Multilevel Switch CC values on some devices
- Fixed a rare communication issue that could cause unnecessary re-transmissions, mark devices as dead, or fail to send sleeping devices back to sleep

#### Config file changes

- Update Zooz ZSE42 config to firmware 2.30
- Update Zooz ZEN32 config to the latest firmware
- Add Zooz ZEN56, update ZEN32, 71, 72, 77
- Complete device config for Contec/Da Vinci Touch Panel (FW 10.10)
- Updated several config files to use value ranges with gaps and step sizes instead of mentioning the allowable range in the parameter description
- Unified the definition of "Basic Set Value" parameters across device files

### Z-Wave JS UI 11.12.0

#### Bugfixes

- Minor UI tweaks to dialogs
- Prevent fetching Github releases when related features are disabled

### Detailed changelogs

- [Z-Wave JS 15.21.0](https://github.com/zwave-js/zwave-js/releases/tag/v15.21.0)
- [Z-Wave JS UI 11.12.0](https://github.com/zwave-js/zwave-js-ui/releases/tag/v11.12.0)

## 1.0.0

**NOTE: It is strongly recommended to make a backup before updating to this version.**

This release includes [Z-Wave JS UI](https://github.com/zwave-js/zwave-js-ui) as an optional management UI to support advanced use-cases.

### Breaking changes

- Version 1.0.0 of the add-on requires version 2025.12.0 or higher of Home Assistant Core.
- Drop support for armhf, armv7 and i386 architectures
- Remove `emulate_hardware` configuration option

### Other changes

- Update base image to Alpine 3.23

## 0.29.1

### Z-Wave JS 15.20.1

#### Bugfixes

- Clean up unnecessary "device config changed" repairs that could appear after updating to Z-Wave JS 15.20.0 / addon version 0.29.0 without skipping Z-Wave JS 15.20.0 / addon version 0.28.0.

#### Config file changes

- Add Zooz Zen57 240V XS Relay
- Add MCO Home MH-5900 thermostat
- Update Zooz ZEN35 configuration for firmware 1.10 and later
- Update Zooz ZEN14 configuration for firmware 2.20

### Detailed changelogs

- [Z-Wave JS 15.20.0...15.20.1](https://github.com/zwave-js/zwave-js/compare/v15.20.0...v15.20.1)

## 0.29.0

### Z-Wave JS 15.20.0

#### Features

- Sound Switch CC: Reset the current tone back to none when done playing
- Support connecting to ESPHome Z-Wave proxies with API encryption
- Try to find Z-Wave QR code strings in longer strings

#### Bugfixes

- Avoid false positive detections for changed device configs after upgrading from a version before 15.19.0

#### Config file changes

- Update Zooz ZEN16 to support 800 series version

### Detailed changelogs

- [Z-Wave JS 15.19.0...15.20.0](https://github.com/zwave-js/zwave-js/compare/v15.19.0...v15.20.0)

## 0.28.0

### Z-Wave JS 15.19.0

#### Features

- Add option to force associations without checking if they are valid/allowed
- Devices that failed to include with Security S2 are no longer interviewed

#### Bugfixes

- During the initial interview after inclusion, user codes are now cleared unless `queryAllUserCodes` driver option is set
- The `ConfigurationCCDefaultReset` command now uses Supervision if supported
- Correct log messages for `SoundSwitchCCConfigurationSet`
- Fixed an issue where `setValue` calls with `disableOptimisticValueUpdate` would cause the next `value updated` event to have an incorrect previous value
- Fixed an issue where some 500 series controllers could hang during an NVM backup

#### Config file changes

- Add missing parameter for latest VZW31-SN firmware
- Correct manual link metadata for Inovelli VZW31-SN and VZW32-SN
- Label endpoints of Shelly Wave Shutter
- Remove unnecessary firmware version check from Zooz ZEN35
- Add fingerprint for Kwikset HC620
- Add Zooz Zen58 Low Voltage XS Relay
- Hide VZW32-SN test parameter from production use
- Add Aeotec ZWA050 SmokeShield for Ei Smoke Detectors

### Z-Wave JS 15.18.0

#### Features

- Device configuration parameters can now be marked as hidden
- Allow setting either `defaultToneId` or `defaultVolume` in Sound Switch CC

#### Bugfixes

- Remove overly strict ASCII event data padding validation in Entry Control CC
- Fixed an issue where an (unexpected) "Node ID added" notification during an ongoing inclusion would cause security bootstrapping to be skipped
- The `lastSeen` field is now restored when initializing node statistics
- Spec compliance: use `Extended User Code Set` to control V2+ devices

#### Config file changes

- Omit `dimmingDuration` field for TKBHome Dimmer
- Add Heatit Z-TRM6 DC Thermostat

### Z-Wave JS 15.17.1

#### Bugfixes

- Fixed an error that could happen when receiving an S0 Nonce Report before the request acknowledgement

### Z-Wave JS 15.17.0

#### Features

- Add rudimentary support for Application Status Command Class
- Implement `refreshValues` for Window Covering CC

#### Bugfixes

- Add missing "Panic alert" event to "Emergency Alarm" notification
- Fixed an issue where Basic CC values were incorrectly exposed after including a device
- Fixed an error that could happen when receiving an S2 Nonce Report before the request acknowledgement
- Cached user codes are now cleared when an "All user codes deleted" notification is received
- For notification sensors operating in push mode, the notification state is now queried during the interview
- Fixed a regression where value changes were not verified on slow devices after immediately successful supervised commands

#### Config file changes

- Add Shelly Wave Shutter, update Wave 1, Wave 1PM, Wave 2PM, Wave Plug S
- Add product id `0x03b9` to Kwikset 918
- Update documentation link for Eurotronic Comet Z
- Add Philips DDL240X Touchscreen Deadbolt
- Add US variant to Shelly Wave 2PM

### Z-Wave JS 15.16.0

#### Features

- Config parameter values can now be marked as recommended and automatically be set during the interview
- Config parameters can now be marked as destructive, allowing applications to confirm before setting them
- Add API to enable more frequent background RSSI measurements

#### Bugfixes

- Battery CC reports with invalid levels are now discarded

#### Config file changes

- Add fingerprint to Kwikset HC-620
- Add Zooz ZSE11 800LR
- Add version conditionals and correct parameters for Enbrighten 55258
- Replace wrong troubleshooting link in 700 series firmware warning template
- Add Kwikset 918
- Correct user code slot bit field for BE468ZP/BE469/BE469ZP
- Add parameters 3, 40 and 84 for Enbrighten 55258, firmware version 5.51

### Z-Wave JS 15.15.2

#### Bugfixes

- Fixes a rare issue with the cache serialization of certain values that could lead to out-of-memory crashes, often immediately or shortly after startup

#### Config file changes

- Add Namron 4512774 Remote Controller

### Z-Wave JS 15.15.1

#### Bugfixes

- Fixed a warning in bundlers about an unexpected `node:net` import
- Fixed an issue where the device class of newly joined devices would not be persisted, causing legacy secure devices not to be automatically included with encryption

#### Config file changes

- Update parameters for HomeSeer WS300
- Add Zooz ZEN78 High Power Relay

### Detailed changelogs

- [Z-Wave JS 15.15.0...15.19.0](https://github.com/zwave-js/zwave-js/compare/v15.15.0...v15.19.0)

## 0.27.0

### Changes

- Revert automatic reconnection when communication with adapter is lost. Home Assistant already handles this.

### Detailed changelogs

- [Z-Wave JS Server 3.4.0](https://github.com/zwave-js/zwave-js-server/releases/tag/3.4.0)

## 0.26.0

### Features

- Support creating mixed LR and non-LR "multicast" groups

### Bugfixes

- IP based connections no longer block the process for several minutes on connection failures/timeouts
- Disable optimistic value updates for slow device classes, like shades and gates
- Fixed an edge case where support for EU Long Range is not inferred correctly
- During route rebuilds, invalid and non-existing association targets are now skipped instead of failing the whole process

### Detailed changelogs

- [Z-Wave JS 15.15.0](https://github.com/zwave-js/zwave-js/releases/tag/v15.15.0)

## 0.25.0

### Features

- Try re-establishing connection when communication with adapter is lost

### Detailed changelogs

- [Z-Wave JS Server 3.3.0](https://github.com/zwave-js/zwave-js-server/releases/tag/3.3.0)

## 0.24.0

### Features

- Allow configuring a socket as an alternative to a device

### Bugfixes

- Fixed an issue where converting NVMs with unknown objects would fail due to unknown NVM section

### Detailed changelogs

- [Z-Wave JS 15.14.0](https://github.com/zwave-js/zwave-js/releases/tag/v15.14.0)

## 0.23.0

### Features

- Support checking for all firmware updates at once, and support detecting devices unknown to the firmware update service

### Bugfixes

- Fixed an edge case preventing the migration of some controllers
- Clean up Battery "isLow" values that are no longer updated by the Z-Wave JS driver

### Config file changes

- Added support for Zooz ZEN75
- Updated Inovelli VZW32-SN device support to match latest firmware

### Detailed changelogs

- [Z-Wave JS 15.13.0](https://github.com/zwave-js/zwave-js/releases/tag/v15.13.0)

## 0.22.0

### Features

- Firmware updates that fail due to an XMODEM communication error are now retried automatically, reducing the risk to get stuck in bootloader until a new firmware is flashed (#8086)

### Bugfixes

- Fixes an issue where the controller would indefinitely be considered as recovering from a jammed state, preventing commands from being re-transmitted (#8052)
- Fixed an issue where the key up event would be force-emitted too early on legacy devices that incorrectly report not to support the "slow refresh" capability (#8087)
- Canceling a "replace failed node" operation no longer prevents other inclusion/exclusion operations from being started (#8084)

### Config file changes

- Add HomeSeer WS300 (#8074)

### Detailed changelogs

- [Z-Wave JS 15.12.0](https://github.com/zwave-js/zwave-js/releases/tag/v15.12.0)

## 0.21.0

### Features

- Z-Wave JS: Add support for defining Scene labels in config files
- Z-Wave JS: Disable SmartStart provisioning entries after 5 failed inclusion attempts

### Bug fixes

- Z-Wave JS: Fixed an issue where Aeotec Z-Stick 5 would become unresponsive during NVM backup
- Z-Wave JS: Fixed firmware update progress jumping back and forth
- Z-Wave JS: Fixed incorrect long-term averaging of RSSI values
- Z-Wave JS: Ensure failures during NVM migration are surfaced to the application

### Config file changes

- Prepare Inovelli VZW31-SN for future firmware upgrade
- Add productID `0x0111` to Fakro AMZ Solar awning
- Add ECO-DIM.07 800 series version
- Update Aeotec Trisensor 8 to firmware 2.8.4
- Remove non-existent parameter 107 for Shelly Wave Plus S
- Fix typo in Shelly dimmer output label

### Detailed changelogs

- [Z-Wave JS 15.11.0](https://github.com/zwave-js/zwave-js/releases/tag/v15.11.0)

## 0.20.0

### Features

- Z-Wave JS Server: Bump schema to 44
- Z-Wave JS Server: Support OTW updates through the FW update service

### Detailed changelogs

- [Z-Wave JS Server 3.2.1](https://github.com/zwave-js/zwave-js-server/releases/tag/3.2.1)
- [Z-Wave JS Server 3.2.0](https://github.com/zwave-js/zwave-js-server/releases/tag/3.2.0)

## 0.19.0

### Features

- Z-Wave JS: Convert Battery CC `isLow` value to a notification
- Z-Wave JS: Removed several unnecessary Indicator CC values and fixed several remaining ones

### Bug fixes

- Z-Wave JS: Use configured RF region as fallback for firmware update checks on older controllers
- Z-Wave JS: When turning on a Multilevel Switch with supervision, the actual value is now queried immediately instead of 5s later

### Config file changes

- Add fingerprint to FireAngel ZHT-630, add FireAngel ZST-630
- Remove unlock mapping for Schlage lock FE599
- Add Fantem FT117 range extender
- Add Zooz ZEN35
- Remove proprietary RGB functionality for ZWA-2
- Update label and description for ZWA-2
- Add missing parameter 117 (Reboot) on Shelly Wave Plug S EU (QNPL-0A112)

### Detailed changelogs

- [Z-Wave JS 15.10.0](https://github.com/zwave-js/zwave-js/releases/tag/v15.10.0)

## 0.18.0

### Features

- Z-Wave JS: Automatically correct the transmit power of adapters set to the SDK default powerlevels
- Z-Wave JS: Reduced the need to re-interview devices after a configuration file update
- Z-Wave JS: Avoid multi-second communication delays when pinging unreachable devices

### Bug fixes

- Z-Wave JS: The progress for rebuilding routes ignores Long Range devices
- Z-Wave JS: Improved reliability of inclusion, exclusion, removing and replacing failed devices

### Config file changes

- Add First Alert Smart Smoke & CO Alarm
- Add Inovelli VZW32-SN mmWave Switch
- Update and correct Leviton device metadata
- Add params for Enbrighten (Jasco) 59337 and 59338
- Add fingerprint `0x8101:0x4a36` to McoHome MH4936
- Improve accuracy of N4002/N4012 rate parameter labels
- Add Aeotec Z-Stick 10 Pro
- Fixed an issue with Yale YRD226 and similar locks where the number of user codes was not stored during the interview
- Add Shelly Wave Dimmer, Motion and H&T
- Clean up inclusion/exclusion/reset instructions in many config files

### Detailed changelogs

- [Z-Wave JS 15.9.0](https://github.com/zwave-js/zwave-js/releases/tag/v15.9.0)
- [Z-Wave JS 15.8.0](https://github.com/zwave-js/zwave-js/releases/tag/v15.8.0)
- [Z-Wave JS 15.7.0](https://github.com/zwave-js/zwave-js/releases/tag/v15.7.0)

## 0.17.0

### Features

- Z-Wave JS Server: Add command to enable/disable the radio

### Detailed changelogs

- [Z-Wave JS Server 3.1.0](https://github.com/zwave-js/zwave-js-server/releases/tag/3.1.0)

## 0.16.0

### Features

- Add radio frequency power level driver configuration.

## 0.15.0

### Features

- Z-Wave JS: Add options to set powerlevel within legal limits on region change during startup
- Z-Wave JS: Allow the application to disable support for specific CCs
- Z-Wave JS: Support OTW updates for the controller via the firmware update service
- Z-Wave JS: Update Notification definitions to 2024B-3 specs
- Z-Wave JS: Add static methods to query Door Lock CC capabilities
- Z-Wave JS: The hardware watchdog no longer gets enabled by default, since this is now handled by recent firmwares. The corresponding driver option and preset have been deprecated.

### Bug fixes

- Z-Wave JS: When the serialport closes unexpectedly, try to reopen it first before throwing an error
- Z-Wave JS: Work around missing protocol version file in NVM backed up from SDK 7.23.0 and .1
- Z-Wave JS: The default region is no longer considered to be Europe for firmware updates
- Z-Wave JS: Make the device ID check during OTA updates actually do something
- Z-Wave JS: Fixed a regression from v15 where Z-Wave JS would immediately soft-reset the controller instead of retrying after an ACK timeout
- Z-Wave JS: Fixed a type error after OTW firmware upgrade
- Z-Wave JS: Prevent the interview of battery-powered devices to stop after the first stage when re-interviewing after a firmware update
- Z-Wave JS: Omit empty fields from TX reports, ignore missing RSSI in routing statistics
- Z-Wave JS: Use local time for logging to file

### Config file changes

- Add/update several Simon iO devices
- Add Enbrighten (Jasco) 58446 / ZWA4013 Fan Control
- Add Aeotec ZWA046 Home Energy Meter 8
- Add PE653 endpoints for VSP speeds and P5043ME pool/spa mode
- Add ZVIDAR WM25C
- Add MCO Home MH-S314-7102
- Add McoHome thermostats MH4936, MH5-2D and MH5-4A
- Update Inovelli VZW31-SN to FW 1.04
- Add param 29 (load sense) to HomePro ZDP100
- Add Yale YDM3109A Smart Lock

### Detailed changelogs

- [Z-Wave JS 15.6.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v15.6.0)
- [Z-Wave JS 15.5.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v15.5.0)
- [Z-Wave JS 15.4.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v15.4.2)
- [Z-Wave JS 15.4.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v15.4.1)
- [Z-Wave JS 15.4.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v15.4.0)

## 0.14.0

### Breaking changes

- Version 0.14.0 of the add-on requires version 2025.5.0 or higher of Home Assistant Core.

### Features

- Add radio frequency region option to the add-on.

## 0.13.1

### Bug fixes

- Z-Wave JS Server: Fix to reuse the driver's ConfigManager instance instead of creating a new one
- Z-Wave JS: Fixed a regression from v15 where command delivery verification wouldn't work on S2-capable devices without Supervision
- Z-Wave JS: Fixed an issue where some CCs could be missing when Z-Wave JS was bundled

### Config file changes

- Disallow manual entry for param 3 on Zooz ZSE70

### Detailed changelogs

- [Z-Wave JS Server 3.0.2](https://github.com/zwave-js/zwave-js-server/releases/tag/3.0.2)
- [Z-Wave JS 15.3.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v15.3.2)
- [Z-Wave JS 15.3.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v15.3.1)

## 0.13.0

### Bug fixes

- Z-Wave JS: Fixed an issue where incorrect device info for the controller was exposed until restarting after migration from different hardware
- Z-Wave JS Server: Support omitting optional data while restoring NVM backups

### Config file changes

- Add Ness Smart Plug ZA-216001
- Add fingerprint for FortrezZ LLC SSA1/SSA2

### Detailed changelogs

- [Z-Wave JS Server 3.0.1](https://github.com/zwave-js/zwave-js-server/releases/tag/3.0.1)
- [Z-Wave JS 15.3.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v15.3.0)
- [Z-Wave JS 15.2.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v15.2.1)
- [Z-Wave JS 15.2.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v15.2.0)

## 0.12.1

### Bug fixes

- Z-Wave JS: Fixed an issue where some controllers could lock up when retrying a command to an unresponsive node
- Z-Wave JS: Several fixes for legacy Multi Channel devices

### Config file changes

- Add fingerprint for FortrezZ LLC SSA1/SSA2

### Detailed changelogs

- [Z-Wave JS 15.1.3](https://github.com/zwave-js/node-zwave-js/releases/tag/v15.1.3)
- [Z-Wave JS 15.1.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v15.1.2)
- [Z-Wave JS 15.1.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v15.1.1)

## 0.12.0

### Features

- Z-Wave JS: Add support for proprietary controller functionality

### Bug fixes

- Z-Wave JS: Fixed two issues that could cause commands to fail with "transmit queue full" errors

### Config file changes

- Add ZWA-2

### Detailed changelogs

- [Z-Wave JS 15.1.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v15.1.0)
- [Z-Wave JS 15.0.6](https://github.com/zwave-js/node-zwave-js/releases/tag/v15.0.6)

## 0.11.0

### Breaking changes

- Version 0.11.0 of the add-on requires version 2021.3.0 or higher of Home Assistant Core.

### Features

- Z-Wave JS / Z-Wave JS Server: Add API to query supported notification events of a device
- Z-Wave JS Server: Support for zwave-js v15

### Bug fixes

- Z-Wave JS: Improved spec compliance
- Z-Wave JS: Fixed an issue where multi-stage firmware updates would fail after the first stage
- Z-Wave JS: Fixes an issue where no firmware updates would show as available when the controller region is set to EU_LR

### Config file changes

- Add alarmType 132 mapping for Yale YRD4x0 locks
- Add fingerprint for ZVIDAR Z-TRV-V01
- Add missing parameters to Qubino Smart Plug 16A
- Add missing parameters for the MCO MH-C221 shutter
- Correct Fibaro FGMS001 association groups
- Add multi-click detection parameter to Zooz ZEN51/52
- Add Shelly Door/Window Sensor, Wave Plug S, Wave PRO Dimmer 1PM/2PM
- Add SmartWings WB04V
- Add new parameters for Zooz ZEN72 firmware 3.40 and 3.50
- Add new Zooz ZEN32 parameter 27
- Update New One N4002 to correct parameters and other information
- Update Zooz ZSE44 based on latest docs
- Add SmartWings WM25L Smart Motor
- Update Zooz ZEN04 to firmware 2.30
- Update Zooz ZEN30 to Firmware v4.20
- Update Zooz ZEN20 to firmware 4.20
- Update Zooz ZEN17 800LR to firmware 2.0
- Update to TKB Home TZ88
- Add missing and new parameters for Zooz ZEN15
- Add fingerprint to Yale YRL210
- Add Springs Window Fashions CRBZ motorized blinds
- Add Jasco ZWN4015 In-Wall Smart Switch
- Add config parameters to Schlage PIR Motion Sensor
- Add Lockly Secure Plus
- Update Zooz ZEN74 to firmware 2.10
- Preserve endpoints for Namron 16A thermostats
- Allow setting arbitrary Motion Sensitivity for ZSE70
- Update config file for 500 series controllers

### Detailed changelogs

- [Z-Wave JS Server 3.0.0](https://github.com/zwave-js/zwave-js-server/releases/tag/3.0.0)
- [Z-Wave JS 15.0.5](https://github.com/zwave-js/node-zwave-js/releases/tag/v15.0.5)
- [Z-Wave JS 15.0.4](https://github.com/zwave-js/node-zwave-js/releases/tag/v15.0.4)
- [Z-Wave JS 15.0.3](https://github.com/zwave-js/node-zwave-js/releases/tag/v15.0.3)
- [Z-Wave JS 15.0.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v15.0.2)
- [Z-Wave JS 15.0.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v15.0.1)
- [Z-Wave JS 15.0.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v15.0.0)
- [Z-Wave JS 14.3.13](https://github.com/zwave-js/node-zwave-js/releases/tag/v14.3.13)
- [Z-Wave JS 14.3.12](https://github.com/zwave-js/node-zwave-js/releases/tag/v14.3.12)
- [Z-Wave JS 14.3.11](https://github.com/zwave-js/node-zwave-js/releases/tag/v14.3.11)
- [Z-Wave JS 14.3.10](https://github.com/zwave-js/node-zwave-js/releases/tag/v14.3.10)
- [Z-Wave JS 14.3.9](https://github.com/zwave-js/node-zwave-js/releases/tag/v14.3.9)

## 0.10.0

### Features

- Z-Wave JS Server: Forward driver ready event
- Z-Wave JS Server: Support controller.cancelSecureBootstrapS2
- Z-Wave JS Server: Support zwave-js v14
- Z-Wave JS: Allow specifying RF region for OTA firmware updates if the region is unknown or cannot be queried
- Z-Wave JS: Add tryUnzipFirmwareFile utility to support zipped OTA firmware files

### Bug fixes

- Z-Wave JS Server: Fix stringify Uint8Arrays like Buffers
- Z-Wave JS: Fixed firmware updates fail to start on some devices with error "invalid hardware version"
- Z-Wave JS: Fixed another issue where some CC API methods would incorrectly fail validation of their arguments, causing the node interview to fail
- Z-Wave JS: Fixed an issue that prevented the nvmedit CI utility from starting
- Z-Wave JS: Fixed an issue where some CC API methods would incorrectly fail validation of their arguments
- Z-Wave JS: Fixed an issue where CC classes would have a different name when zwave-js was loaded as CommonJS, changing how those CCs were handled
- Z-Wave JS: Fix parsing of some older 500 series NVM formats
- Z-Wave JS: Fixed an issue where mock-server would not start due to an incorrect module format
- Z-Wave JS: Fixed an issue where the auto-generated argument validation for CC API methods would not work correctly in some cases when zwave-js was bundled
- Z-Wave JS: Fixed an issue where encoding a buffer as an ASCII string would throw an error on Node.js builds without full ICU
- Z-Wave JS: Parse negative setback state consistently
- Z-Wave JS: Ignore LR nodes when computing neighbor discovery timeout
- Z-Wave JS: Automatically fall back to Europe when setting region to Default (EU)

### Config file changes

- Preserve all endpoints for Fibaro FGFS101, FW 26.26
- Preserve all endpoints for Fibaro FGFS101, FW 25.25
- Updates to AEON Labs Minimote
- Auto-assign Lifeline for Trane XL624
- Disable Supervision for Everspring SP817 Motion Sensor
- Add wakeup instructions for ZSE43
- Add wakeup instructions for ZSE42
- Add wakeup instructions for ZSE41
- Add Zooz ZSE70 800LR
- Add new device config for Philips DDL240X-15HZW lock
- Add Z-Wave.me Z-Station
- Add HomeSys HomeMech-2001/2
- Ignore setpoint range for Ecolink TBZ500
- Add Aeotec TriSensor 8
- Disable Supervision for Everspring SE813

### Detailed changelogs

- [Z-Wave JS Server 1.40.3](https://github.com/zwave-js/zwave-js-server/releases/tag/1.40.3)
- [Z-Wave JS Server 1.40.2](https://github.com/zwave-js/zwave-js-server/releases/tag/1.40.2)
- [Z-Wave JS Server 1.40.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.40.0)
- [Z-Wave JS 14.3.8](https://github.com/zwave-js/node-zwave-js/releases/tag/v14.3.8)
- [Z-Wave JS 14.3.7](https://github.com/zwave-js/node-zwave-js/releases/tag/v14.3.7)
- [Z-Wave JS 14.3.6](https://github.com/zwave-js/node-zwave-js/releases/tag/v14.3.6)
- [Z-Wave JS 14.3.5](https://github.com/zwave-js/node-zwave-js/releases/tag/v14.3.5)
- [Z-Wave JS 14.3.4](https://github.com/zwave-js/node-zwave-js/releases/tag/v14.3.4)
- [Z-Wave JS 14.3.3](https://github.com/zwave-js/node-zwave-js/releases/tag/v14.3.3)
- [Z-Wave JS 14.3.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v14.3.2)
- [Z-Wave JS 14.3.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v14.3.1)
- [Z-Wave JS 14.2.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v14.2.0)
- [Z-Wave JS 14.1.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v14.1.0)
- [Z-Wave JS 14.0.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v14.0.0)
- [Z-Wave JS 13.10.3](https://github.com/zwave-js/node-zwave-js/releases/tag/v13.10.3)

## 0.9.0

### Features

- Z-Wave JS: mock-server now supports putting the simulated controller into add and remove mode
- Z-Wave JS Server: Support get_raw_config_parameter_value
- Z-Wave JS Server: Support all signatures of node.manuallyIdleNotificationValue

### Bug fixes

- Z-Wave JS: Fixed an issue where preferred scales were not being found when set as a string
- Z-Wave JS: Correct unit of Meter CC values
- Z-Wave JS: Bootloader mode is now detected even when short chunks of data are received
- Z-Wave JS: Corrected the wording of idle/busy queue logging

### Config file changes

- Add Heatit Z-TEMP3
- Add new parameters 17 and 18 for HeatIt TF016_TF021 FW 1.92
- Disable Supervision for Heatit TF021
- Add ZVIDAR WB04V Smartwings Day Night Shades
- Add ZVIDAR WM25L Smartwings Smart Motor
- Add ZVIDAR ZW881 Multi-Protocol Gateway
- Add include, exclude, and wakeup instructions for VCZ1
- Add new Product ID to Namron 16A Switch
- Add Minoston MP24Z 800LR Outdoor Smart Plug - 2 Outlet
- Disable Supervision for Everspring SE813

### Detailed changelogs

- [Z-Wave JS Server 1.39.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.39.0)
- [Z-Wave JS 13.10.3](https://github.com/zwave-js/node-zwave-js/releases/tag/v13.10.3)
- [Z-Wave JS 13.10.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v13.10.2)
- [Z-Wave JS 13.10.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v13.10.1)
- [Z-Wave JS 13.10.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v13.10.0)
- [Z-Wave JS 13.9.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v13.9.1)

## 0.8.1

Rename Z-Wave watchdog option to avoid confusion with add-on watchdog.

## 0.8.0

### Features

- Add-on: Add `disable_watchdog` configuration option. When enabled, the driver will not enable the hardware watchdog of the Z-Wave controller. This is an advanced configuration option that should not be adjusted in most cases and is therefore hidden from the default view.
- Z-Wave JS: Multiple parallel firmware updates are now supported

### Bug fixes

- Z-Wave JS: Fixed an issue where open/close for some covers was inverted

### Config file changes

- Update Z-Wave SDK warnings to mention recommended versions
- Update Zooz device labels
- Add fingerprint to Aeotec ZWA024
- Correct max. value of SKU parameters for Kwikset locks
- Add fingerprint to Remotec ZXT-800
- Add incompatibility warning to UZB1
- Override Central Scene CC version for Springs Window Fashions VCZ1
- Add manual and reset metadata for Danfoss LC-13

### Detailed changelogs

- [Z-Wave JS 13.4.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v13.4.0)
- [Z-Wave JS 13.5.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v13.5.0)
- [Z-Wave JS 13.6.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v13.6.0)
- [Z-Wave JS 13.7.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v13.7.0)
- [Z-Wave JS 13.8.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v13.8.0)
- [Z-Wave JS 13.9.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v13.9.0)

## 0.7.2

### Bug fixes

- Z-Wave JS: Fixed the identification of the primary controller role on some older controllers
- Z-Wave JS: Fixed an issue where passing a custom log transport to updateOptions would cause a call stack overflow
- Z-Wave JS: Implement deserialization for more WindowCoveringCC commands to be used in mocks

### Config file changes

- Add Philio Technology Smart Keypad
- Add LED indication parameter for Inovelli NZW31 dimmer

### Detailed changelogs

- [Z-Wave JS 13.3.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v13.3.1)

## 0.7.1

### Bug fixes

- Add-on: Fix the soft reset driver option that was moved in driver v.13.

## 0.7.0

### Features

- Z-Wave JS: Add support for EU Long Range
- Z-Wave JS: Support learn mode to become a secondary controller
- Z-Wave JS: Add method to query supported RF regions and their info
- Z-Wave JS: Support Firmware Update Meta Data CC v8
- Z-Wave JS: Implement 32-bit addressed NVM operations
- Z-Wave JS: Add methods to reset SPAN of one or all nodes
- Z-Wave JS: Add method to enumerate all device classes
- Z-Wave JS: Update list of manufacturers and existing CCs
- Z-Wave JS: Add inclusion state changed event
- Z-Wave JS: Add support for new notifications
- Z-Wave JS: Bump version of Association CC and Multi Channel Association CC
- Z-Wave JS: Add link reliability check feature
- Z-Wave JS: Enable hardware watchdog on 700/800 series controllers
- Z-Wave JS: Add method to query supported RF regions
- Z-Wave JS: Add notification variable for Door/Window tilt state

### Bug fixes

- Z-Wave JS: Fix missing values in endpoint dump
- Z-Wave JS: Preserve granted security classes of provisioning entries when switching protocols
- Z-Wave JS: Version of Humidity Control Mode CC is 1, not 2
- Z-Wave JS: Abort S2 bootstrapping when KEXSetEcho has reserved bits set
- Z-Wave JS: Fixed an issue causing non-implemented CCs to be dropped before applications could handle them
- Z-Wave JS: Fixed an issue causing all ZWLR multicast groups to be considered identical
- Z-Wave JS: Fixed a startup crash on Zniffers older than FW 2.55
- Z-Wave JS: Fixed latency calculation in link reliability check, distinguish between latency and RTT
- Z-Wave JS: Fixed a regression that could cause incorrect units and missing sensor readings
- Z-Wave JS: Don't verify delivery of S2 frames in link reliability check
- Z-Wave JS: Reset aborted flags when starting link reliability or route health check
- Z-Wave JS: Supported CCs of endpoints are now reset during a re-interview
- Z-Wave JS: Basic CC is no longer automatically marked as supported if included in the list of securely supported commands
- Z-Wave JS: Set highest version also for Basic CC if Version CC is not supported
- Z-Wave JS: Fixed an issue where CC values could be returned for the controller node
- Z-Wave JS: Fixed a regression from v12.12.3 would result in Basic CC values being exposed unnecessarily for some devices
- Z-Wave JS: Fixed an issue where Basic CC values would be exposed unnecessarily for devices with a compat flag that maps Basic CC Set to a different CC
- Z-Wave JS: When responding to Version CC Get queries, Z-Wave JS's own version is now included as the Firmware 1 version
- Z-Wave JS: When receiving a notification with an unknown notification type, the created "unknown" value now correctly has metadata set
- Z-Wave JS: When receiving an idle notification, the values for unknown notification events are now also reset to idle
- Z-Wave JS: Auto-enable all supported Barrier Operator signaling subsystem during the interview
- Z-Wave JS: Fixed an issue where the watchdog feature could cause Z-Wave JS to stall after attempting controller recovery
- Z-Wave JS: Reset controller again when transmitting to a problematic node makes the controller become unresponsive again after automatic recovery
- Z-Wave JS: Node interviews are now aborted in more cases when node is determined to be dead
- Z-Wave JS: Expose Basic CC currentValue when certain compat flags are set
- Z-Wave JS: Fixed an issue where value metadata for unknown notification events with known notification types would only be created if the CC version was exactly 2

### Config file changes

- Add new fingerprint for TZ45 thermostat
- Add alarm mapping for Schlage lock CKPD FE599
- Add fingerprint for Climax Technology SDCO-1
- Add Shelly Wave Pro 3 and Wave Pro Shutter
- Remove endpoint workaround for Zooz ZEN30, FW 3.20+
- Add ZVIDAR ZW872 800 series Pi Module
- Add ZVIDAR ZW871 800 series USB Controller
- Rename Zvidar config file name Z-PI to Z-PI.json
- Update Zooz ZEN30 to latest revisions
- Support MCO Home MH-S412 parameters properly
- Add Ring Flood Freeze Sensor
- Override user code count for Yale ZW2 locks to expose admin code
- Add GDZW7-ECO Ecolink 700 Series Garage Door Controller
- Correct label for Remote 3-Way Switch parameter on Zooz ZEN32
- Add UltraPro 700 Series Z-Wave In-Wall Smart Dimmer
- Add Yale Assure 2 Biometric Deadbolt locks
- Add iDevices In-Wall Smart Dimmer
- Support Comet parameters properly
- Update label of Nortek GD00Z-6, -7, -8
- Disable Supervision for Zooz ZSE11
- Clarify parameters and units for Everspring AN158
- Force-add support for Multilevel Switch CC to FGRM-222, remove Binary Switch CC
- Add ZVIDAR Z-PI 800 Series PI Module

### Detailed changelogs

- [Z-Wave JS 13.3.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v13.3.0)
- [Z-Wave JS 13.2.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v13.2.0)
- [Z-Wave JS 13.1.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v13.1.0)
- [Z-Wave JS 13.0.3](https://github.com/zwave-js/node-zwave-js/releases/tag/v13.0.3)
- [Z-Wave JS 13.0.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v13.0.2)
- [Z-Wave JS 13.0.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v13.0.1)
- [Z-Wave JS 13.0.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v13.0.0)
- [Z-Wave JS 12.13.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.13.0)
- [Z-Wave JS 12.12.5](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.12.5)
- [Z-Wave JS 12.12.4](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.12.4)
- [Z-Wave JS 12.12.3](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.12.3)
- [Z-Wave JS 12.12.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.12.2)
- [Z-Wave JS 12.12.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.12.1)
- [Z-Wave JS 12.12.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.12.0)

## 0.6.2

### Bug fixes

- Z-Wave JS: Fixed a regression causing commands to sleeping nodes to block communication with other nodes

### Detailed changelogs

- [Z-Wave JS 12.11.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.11.2)

## 0.6.1

### Bug fixes

- Z-Wave JS: When attempting communication with a node that's considered dead, the command is now sent immediately instead of pinging first
- Z-Wave JS: Fixed prioritization of queued transactions once a node wakes up

### Config file changes

- Remove endpoint workaround for Zooz ZEN30 800LR
- Encode CCs using target's CC version for TKB Home TZ67

### Detailed changelogs

- [Z-Wave JS 12.11.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.11.1)

## 0.6.0

### Features

- Z-Wave JS: Map more Basic CC values to more useful command classes
- Z-Wave JS: Automatically prefer ZWLR-capable RF regions over their non-ZWLR counterparts
- Z-Wave JS: Add driver option to configure vendor-specific constants Z-Wave JS uses to reply to requests from other nodes, including manufacturer ID, product type/ID and hardware version

### Bug fixes

- Z-Wave JS: NVM restore now works around an issue that affects some 800 series controllers
- Z-Wave JS: More gracefully handle scenario where inclusion couldn't be completed due to missing security keys
- Z-Wave JS: Fixed an issue where excluded ZWLR nodes were not removed from the list of nodes until restart
- Z-Wave JS: Always query Basic CC version as part of the interview
- Z-Wave JS: Add support for Z-Wave Long Range devices in NVM backup and restore
- Z-Wave JS: Abort S2 bootstrapping when CSA is requested (not supported in Z-Wave JS)
- Z-Wave JS: Implement workaround to recover jammed controller by soft-resetting
- Z-Wave JS: Fixed a race condition that would cause a timeout error to be shown after an actually successful OTW update

### Config file changes

- Add HomeSeer PS100 presence sensor, fix broken links
- Fix value size for Fibaro FGWCEU-201, params 150/151
- Disable Supervision for Heatit Z-Temp2, firmware 1.2.1
- Use specific float encoding for Namron 4512757
- Add fingerprint for Aeotec MultiSensor 7
- Override CC versions for Wayne Dalton WDTC-20
- Disable Supervision for Everspring EH403
- Add parameter 117 to Shelly Wave Plug US and UK
- Add params 12, 20, 254 for Aeotec DSB09
- Use HomeSeer template for LED Indicator (parameter 3) for all HomeSeer switches
- Add Fibaro FGR-224 Roller Shutter 4
- Parameter update for Zooz Zen16 v2.0 and v2.10
- Override Central Scene CC version for Springs Window Fashions BRZ
- Add fingerprint 0x0004:0xffff to "Yale YRD210"
- Correct config parameters for Minoston MP21ZD Dimmer Plug

### Detailed changelogs

- [Z-Wave JS 12.11.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.11.0)
- [Z-Wave JS 12.10.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.10.1)
- [Z-Wave JS 12.10.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.10.0)
- [Z-Wave JS 12.9.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.9.1)
- [Z-Wave JS 12.9.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.9.0)
- [Z-Wave JS 12.8.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.8.1)
- [Z-Wave JS 12.8.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.8.0)
- [Z-Wave JS 12.7.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.7.0)
- [Z-Wave JS 12.6.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.6.0)
- [Z-Wave JS 12.5.6](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.5.6)

## 0.5.0

### Features

- Z-Wave JS: Map more Basic CC values to more useful command classes
- Z-Wave JS: Add Z-Wave Long Range support
- Z-Wave JS Server: Add Z-Wave Long Range support
- Addon: Add support for collecting Z-Wave Long Range security keys

### Bug fixes

- Z-Wave JS: Fixed an issue that caused additional invalid values to be discovered
- Z-Wave JS: Fixed a crash that could happen in some cases during the Configuration CC interview
- Z-Wave JS: Fixed an issue where provisioning entries could disappear
- Z-Wave JS: Fixed an infinite loop during NVM migration which could happen in rare cases
- Z-Wave JS: Firmware updates on Z-Wave Long Range now utilize the larger frame size better
- Z-Wave JS: Fixed an issue with multicast setValue response
- Z-Wave JS: Disallow associating a node with itself and skip self-associations when rebuilding routes

### Config file changes

- Always map Basic CC to Binary Sensor CC for Aeotec ZW100 Multisensor 6
- Fix versioning logic for parameter 26 of Zooz ZEN72
- Add new Leviton 800 series devices
- Add UltraPro Z-Wave Plus In-Wall Toggle Switch, 700S
- Rename generic 700 series controller to include 800 series
- Add fingerprint and config parameters for UltraPro 700 Switch
- Add Zooz Zen37 800LR Wall Remote
- Added 11 Shelly Qubino Wave devices
- Add Heatit Leakage Water Stopper
- Add Ring Smoke/CO Listener
- Add ZVIDAR Z-TRV-V01 thermostatic valve
- Add Safe Grow NSG-AB-02 Z-Wave Plus Smart Outlet Plug
- Add a new productId and add parameters to 14297/ZW1002 outlet
- Remove Association Groups 2 & 3 from AEON Labs DSB09
- Correct group 3 label for GE/Enbrighten 26931/ZW4006
- Add new Fingerprint for Ring Contact sensor
- Preserve root endpoint in Vision ZL7432
- Add new Product ID to Fibaro Smoke Detector
- Add Product ID for Benext Energy Switch FW1.6
- Add fingerprint for Ring Glass Break Sensor EU
- Change MH9-CO2 Temperature Reporting Threshold step size to 0.1
- Add new product ID to Fibaro FGS-213
- Add units, improve descriptions for Everspring ST814
- Label and parameter definitions for Sensative Drip 700
- Override supported sensor scales for HELTUN HE-ZW-THERM-FL2

### Detailed changelogs

- [Z-Wave JS Server 1.35.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.35.0)
- [Z-Wave JS 12.5.5](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.5.5)
- [Z-Wave JS 12.5.4](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.5.4)
- [Z-Wave JS 12.5.3](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.5.3)
- [Z-Wave JS 12.5.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.5.2)
- [Z-Wave JS 12.5.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.5.1)
- [Z-Wave JS 12.5.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.5.0)

## 0.4.5

### Bug fixes

- Z-Wave JS: NVM backups can now be restored onto 800 series controllers

### Config file changes

- Use Color Switch V2 for Inovelli LZW42
- Correct Zooz ZEN1x timer config params

### Detailed changelogs

- [Z-Wave JS 12.4.4](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.4.4)

## 0.4.4

### Bug fixes

- Z-Wave JS: Reduce idle CPU load

### Config file changes

- Add 2nd product ID for Ring Panic Button Gen2
- Disable Supervision for Alfred DB1 Digital Deadbolt Lock to work around battery drain issue
- Extend version range for Vesternet VES-ZW-DIM-001

### Detailed changelogs

- [Z-Wave JS 12.4.3](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.4.3)
- [Z-Wave JS 12.4.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.4.2)

## 0.4.3

### Features

- Z-Wave JS Server: Enable server to listen on IPv6 interfaces

### Bug fixes

- Z-Wave JS: Handle more cases of unexpected Serial API restarts

### Config file changes

- Add wakeup instructions for Nexia ZSENS930
- Correct parameter 5 size for Zooz ZEN34

### Detailed changelogs

- [Z-Wave JS 12.4.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.4.1)
- [Z-Wave JS Server 1.34.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.34.0)

## 0.4.2

### Features

- Z-Wave JS: Expose rebuild routes progress as a controller property

### Bug fixes

- Z-Wave JS: On devices that should/must not support `Basic CC`, but use it for reporting, only the `currentValue` is now exposed. This allows applications to consider it a sensor, not an actor

### Config file changes

- Correct firmware version condition for Zooz ZSE40 v3.0

### Detailed changelogs

- [Z-Wave JS 12.4.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.4.0)
- [Z-Wave JS 12.3.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.3.2)

## 0.4.1

### Bug fixes

- Z-Wave JS: Fixed an issue where the unresponsive controller recovery could do the wrong thing and block all outgoing communication.

### Config file changes

- Add missing units and firmware condition for Heatit Z-Temp2
- Correct device label for Airzone Aidoo Control HVAC unit

### Detailed changelogs

- [Z-Wave JS 12.3.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.3.1)

## 0.4.0

### Features

- Add-On: Provide access to Z-Wave JS cache files for debugging in `/addon_configs/core_zwave_js/cache`
- Add-On: Add configuration option to log to file. When enabled, logs will be written to `/addon_configs/core_zwave_js` with the `.log` file extension

## 0.3.0

### Features

- Add-On: Add `disable_controller_recovery` configuration option. When enabled, the driver will not attempt to automatically recover from an unresponsive controller and will instead either let the controller recover on its own or wait for the user to restart the add-on to attempt recovery. This is an advanced configuration option that should not be adjusted in most cases and is therefore hidden from the default view.

### Bug fixes

- Z-Wave JS: Ensure the default Basic CC values are only exposed if they should be
- Z-Wave JS: Auto-remove failed SmartStart nodes when bootstrapping times out
- Z-Wave JS: Improve how unresponsive controllers are handled

### Config file changes

- Tweak Heatit Z-TRM6 options
- Add Ring Alarm Panic Button Gen2
- Update fingerprints for Vesternet device

### Detailed changelogs

- [Z-Wave JS 12.3.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.3.0)

## 0.2.1

### Config file changes

- Treat Binary Switch Set and Thermostat Mode Set as reports for SRT321 HRT4-ZW
- Override supported Thermostat modes for Eurotronics Spirit TRV
- Correct firmware warnings for Zooz controllers
- Correct overridden thermostatMode metadata for ZME_FT
- Add MCOHome C521/C621 shutters, fix C321, make shutters consistent
- Correct product id for Fakro ZWS12
- add PM-B400ZW-N
- Ensure kWh is written consistently in parameter units

### Detailed changelogs

- [Z-Wave JS 12.2.3](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.2.3)
- [Z-Wave JS 12.2.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.2.2)
- [Z-Wave JS 12.2.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.2.1)
- [Z-Wave JS Server 1.33.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.33.0)

## 0.2.0

### Features

- Add-on: Add `safe_mode` configuration option to put Z-Wave network in safe mode. This can be used help with troubleshooting network issues, such as being unable to start it, but will likely slow down your network and should therefore be used sparingly. This is an advanced configuration option that should not be adjusted in most cases and is therefore hidden from the default view.
- Add-on: Switch to [semantic versioning](https://semver.org/). With this change, major version changes to the addon will now reflect e.g. a major version release of Z-Wave JS or a significant change to the add-on structure. This should help users better understand the potential impact of an upgrade.

### Bug fixes

- Z-Wave JS: Includes several more fixes and workarounds for the problematic interaction between some controller firmware bugs and the automatic controller recovery introduced in the `v12` release

### Config file changes

- Add NEO Cool Cam Repeater
- Increase report timeout for Aeotec Multisensor 6 to 2s

### Detailed changelogs

- [Z-Wave JS 12.2.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.2.0)
- [Z-Wave JS Server 1.32.2](https://github.com/zwave-js/zwave-js-server/releases/tag/1.32.2)

## 0.1.98

### Bug fixes

- Z-Wave JS: Fixed an issue with multi-target firmware updates that prevented updates from being applied correctly

### Config file changes

Almost 1000 device configuration files have been reworked to be more consistent, mostly affecting device labels, parameter labels, descriptions and predefined options. After updating, you should expect to see several notifications for changed device configurations, prompting you to re-interview the affected nodes. Unless the device is mentioned below, there's no need to do this immediately.

- Add parameter 26 to Inovelli VZW31-SN
- Always set time for Namron 16A thermostats as UTC
- Add Alloy (Zipato) devices
- Parameter 21 of Inovelli VZW31-SN is readonly
- Add Shelly Wave Shutter
- Add Eurotronic Comet Z (700 series)
- Add params 7, 18, 19 to Zooz ZEN71 FW 10.20
- Add Qubino Shades Remote Controller
- Add fingerprint for new MH8-FC version, add new option for param 1
- Add Hank HKZW-SO08
- Add link to manual of Honeywell T6 Pro Thermostat

### Detailed changelogs

- [Z-Wave JS 12.1.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.1.0)
- [Z-Wave JS 12.1.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.1.1)

## 0.1.97

### Bug fixes

- Z-Wave JS: Fixed a crash that could happen while logging dropped sensor readings.
- Z-Wave JS: Change the default timeout to handle slow 500 series controllers.

### Config file changes

- Treat Basic Set as events for TKB TZ35S/D and TZ55S/D
- Add Zooz ZAC38 Range Extender
- Corrected the label of the notification event `0x0a` to be `Emergency Alarm`

### Detailed changelogs

- [Z-Wave JS 12.0.4](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.0.4)

## 0.1.96

### Bug fixes

- Add-on: Make `soft_reset` configuration option optional since, when required, it breaks add-on installations done through the `zwave_js` integration.

## 0.1.95

### Bug fixes

- Z-Wave JS: Fixes or works around multiple issues with 500 series controllers that could trigger the unresponsive controller detection in Z-Wave JS 12 in situations where it was not necessary, causing restart loops.

### Bug fixes

- [Z-Wave JS 12.0.3](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.0.3)

## 0.1.94

### Features

- Add-on: Add a `soft_reset` configuration option to choose how to handle soft-reset functionality for 500 series controllers.
- Add-on: Extend timeout from 3 seconds to 30 to give Z-Wave JS more time to commit things to disk.

### Bug fixes

- Z-Wave JS: The workaround from v12.0.0 for the 7.19.x SDK bug was not working correctly when the command that caused the controller to get stuck could be retried. This has now been fixed.
- Z-Wave JS: Ignore when a node reports Security S0/S2 CC to have version 0 (unsupported) although it is using that CC

### Config file changes

- Add Shelly to manufacturers
- Add Shelly Wave 1, Wave 2PM, update Wave 1PM association labels
- Add Sunricher SR-ZV2833PAC

### Detailed changelog

- [Z-Wave JS 12.0.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.0.1)
- [Z-Wave JS 12.0.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.0.2)

## 0.1.93

### Bug fixes

- Z-Wave JS Server: For users that have opted in to data collection in their Home Assistant Z-Wave configuration, a missing return caused the server to try to soft reset the controller during Home Assistant startup for Home Assiststant versions 2023.9.x or less. This has now been resolved.

### Detailed changelog

- [Z-Wave JS Server 1.32.1](https://github.com/zwave-js/zwave-js-server/releases/tag/1.32.1)

## 0.1.92

### Bug fixes

- Add-on: Revert change to stop rebuilding @serialport/bindings-cpp from source as the problem is fixed on some CPU platforms but not all

## 0.1.91

### Breaking changes

- Z-Wave JS: Firmware updates may no longer work properly in Home Assistant versions 2023.9.x and earlier due to a breaking change upstream that couldn't be made backward compatible, but will work once again starting in 2023.10.0. This breaking change ultimately improves firmware updates, as checking for updates no longer requires communication with the device, therefore reducing the risk of corrupting manufacturer information. This also means that updates for battery-powered devices can be detected without waking up the devices.

### Features

- Z-Wave JS: Unresponsive controllers are now detected and automatically restarted if possible.
- Z-Wave JS: Battery-powered devices are sent back to sleep after 250 ms with no command (down from 1000 ms). This should result in significant battery savings for devices that frequently wake up.
- Add-on: We no longer rebuild the @serialport/bindings-cpp package from source.

### Bug fixes

- Z-Wave JS: A bug in the 7.19.x SDK has surfaced where the controller gets stuck in the middle of a transmission. Previously, this would go unnoticed because the failed commands would cause the nodes to be marked dead until the controller finally recovered. Since v11.12.0, however, Z-Wave JS would consider the controller jammed and retry the last command indefinitely. This situation is now detected, and Z-Wave JS attempts to recover by soft resetting the controller when this happens.
- Z-Wave JS: Fixed an issue where supporting controllers would no longer be automatically restarted after failing to do so once.
- Z-Wave JS: Devices that send notifications from endpoints, like Aeotec Wallmote, are now properly supported.

### Config file changes

- Add warnings about broken controller firmware versions
- Add Heatit Z-Water 2
- Add Shelly Wave 1PM
- Add Heatit Z-TRM6
- Increase poll delay for ZW500D
- Add fingerprint for Simon IO Master Roller Blind
- Add HOPPE eHandle ConnectSense
- Add parameters to Zooz ZEN17 from firmware 1.30
- Update Zooz ZEN32 config to the latest firmware, include 800 series

### Detailed changelogs

- [Z-Wave JS 11.14.3](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.14.3)
- [Z-Wave JS 12.0.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v12.0.0)
- [Z-Wave JS Server 1.32.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.32.0)

## 0.1.90

### Bug fixes

- Z-Wave JS: Fixed an issue causing commands that have previously been moved to the wakeup queue for sleeping nodes to no longer be handled correctly on wakeup and block the send queue for an extended amount of time

### Detailed changelogs

- [Z-Wave JS 11.14.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.14.1)
- [Z-Wave JS 11.14.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.14.2)

## 0.1.89

### Features

- Z-Wave JS: Optimized the order of node communication during startup to ensure responsive nodes are ready first

### Bug fixes

- Z-Wave JS: The start/stop time and date values in `Schedule Entry Lock` CC commands are now validated
- Z-Wave JS: Fixed an issue where `hasDeviceConfigChanged` would return the opposite of what it should, triggering repair issues for users on HA version >= 2023.9.0b0.

### Config file changes

- Delay value refresh for ZW500D
- Update several Zooz devices to their 800 series revisions
- Extend version range for Vesternet VES-ZW-DIM-001

### Detailed changelogs

- [Z-Wave JS 11.14.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.14.0)

## 0.1.88

### Features

- Z-Wave JS: Applications can now report on controller status
- Z-Wave JS Server: Added support for controller identify event

### Bug fixes

- Z-Wave JS: Fixed a regression from v11.10.1 where the controller's firmware version was not fully queried
- Z-Wave JS: Change order of commands so the startup does not fail when a controller is already set to use 16-bit node IDs and soft-reset is disabled
- Z-Wave JS: Soft-reset is now always enabled on 700+ series controllers
- Z-Wave JS: Queried user codes and their status are now preserved during re-interview when they won't be re-queried automatically
- Z-Wave JS: Fixed an issue where nodes were being marked as dead because the controller couldn't transmit.
- Z-Wave JS: Fixed an issue where 700 series controllers were not soft-reset after NVM backup when soft-reset was disabled via config
- Z-Wave JS: Discard Meter CC and Multilevel Sensor CC reports when the node they supposedly come from does not support them
- Z-Wave JS: Abort inclusion when a node with the same ID is already part of the network
- Z-Wave JS: Fixed a startup crash that happens when the controller returns an empty list of nodes
- Z-Wave JS: Fixed an issue where API calls would be rejected early or incorrectly resolved while the driver was still retrying a command to an unresponsive node
- Z-Wave JS: Fixed an issue where the controller would be considered jammed if it responds with a Fail status, even after transmitting

### Config file changes

- Disable Supervision for Kwikset HC620 to work around a device bug causing it to flood the network
- Add fingerprint for Ring Outdoor Contact Sensor
- Remove unnecessary endpoint functionality for CT100
- Correct reporting frequency parameter values for Sensative AB Strips Comfort / Drips Multisensor

### Detailed changelogs

- [Bump Z-Wave JS Server to 1.31.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.31.0)
- [Bump Z-Wave JS to 11.11.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.11.0)
- [Bump Z-Wave JS to 11.12.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.12.0)
- [Bump Z-Wave JS to 11.13.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.13.0)
- [Bump Z-Wave JS to 11.13.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.13.1)

## 0.1.87

### Bug fixes

- Z-Wave JS: Fixed a bug where firmware links that redirected to another URL were not supported
- Z-Wave JS: Change order of commands so the startup does not fail when a controller is already set to use 16-bit node IDs and soft-reset is disabled
- Z-Wave JS: Soft-reset is now always enabled on 700+ series controllers
- Z-Wave JS: Queried user codes and their status are now preserved during re-interview when they won't be re-queried automatically

### Config file changes

- Add parameters 9-13 to Minoston MP21ZP / MP31ZP
- Add fingerprint to Yale YRD446-ZW2
- Add and update Yale Assure ZW3 series locks
- Remove unnecessary endpoint functionality for CT101

### Detailed changelogs

- [Bump Z-Wave JS to 11.10.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.10.0)
- [Bump Z-Wave JS to 11.10.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.10.1)

## 0.1.86

### Bug fixes

- Z-Wave JS: Fixed an issue where a delayed endpoint capability report could be associated with the wrong query
- Z-Wave JS: During NVM migration, some invalid/unexpected bytes in the 500 series NVM can now be corrected
- Z-Wave JS: Hide configuration values for Door Lock CC v4 functionality that is not supported by a lock
- Z-Wave JS: When a CC version query times out, the CC version is now actually assumed to be 1
- Z-Wave JS: Recover from Security S2 collisions in a common scenario where nodes send a supervised command at the same time Z-Wave JS is trying to control them
- Z-Wave JS: During NVM migration, an incorrect flag for "on other network" is now automatically corrected instead of raising an error
- Z-Wave JS: Fixed an issue where turning on a Multilevel Switch with transition duration could update the currentValue to an illegal value
- Z-Wave JS: Improve heuristic to refresh values from legacy nodes when receiving a node information frame
- Z-Wave JS: Fixed an issue where no control values were exposed for devices that do not support/advertise Version CC
- Z-Wave JS: Fixed a regression introduced in 11.9.1 that would sometimes cause the startup process to hang

### Config file changes

- Add Leviton RZM10-1L
- Force use of Multi Channel CC v1 for all versions of PE653
- Correct state after power failure for Minoston MP21Z/31Z
- Add Namron 4512757
- Preserve endpoint 0 for Zooz ZEN14 to toggle both outlets at once
- Correct value size for some Nortek PD300EMZ5-1 params that were previously swapped
- Add new MCOHome MH-S411/S412 models

### Detailed changelogs

- [Bump Z-Wave JS to 11.7.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.7.0)
- [Bump Z-Wave JS to 11.8.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.8.0)
- [Bump Z-Wave JS to 11.8.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.8.1)
- [Bump Z-Wave JS to 11.9.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.9.0)
- [Bump Z-Wave JS to 11.9.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.9.1)
- [Bump Z-Wave JS to 11.9.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.9.2)

## 0.1.85

### New features

- Z-Wave JS Server: Add support for inclusions that are started outside of Z-Wave JS Server
- Z-Wave JS Server: Add support for lastSeen property
- Z-Wave JS: Add support for identifying on request of other nodes
- Z-Wave JS: Improved auto-discovery of config parameters

### Bug fixes

- Z-Wave JS Server: Fix hard reset support in Z-Wave JS Server
- Z-Wave JS: Increased OTA update timeout, which can help with firmware updates in busy/unstable networks
- Z-Wave JS: Fixed a crash that could happen when including a device with an inclusion controller
- Z-Wave JS: Improved the automatic removal of factory-reset devices that are slow to leave the network
- Z-Wave JS: Devices that failed to join using SmartStart are now automatically removed
- Z-Wave JS: Fix an issue where Z-Wave JS could get stuck when removing a node from the network failed

### Config file changes

- Correct config parameters for Duwi ZW ESJ 300
- Add new FW3.6 parameters to Aeotec ZW141 Nano Shutter
- Add metadata to HANK Electronics Ltd. HKZW-SO01
- Hide Binary Switch CC in favor of Window Covering CC on iBlinds v3
- Remove unnecessary endpoints for RTC CT32
- Update Swidget devices to match their June 8th 2023 spec
- Add endpoint configuration parameters to SES 302
- Disable Window Covering CC for ZVIDAR Roller Blind
- Add missing product type to Aeotec Water Sensor 7 Basic ZWA018
- Override endpoint indizes for heatapp! floor
- Override schedule slot count for P-KFCON-MOD-YALE
- Override supported color channels for Zipato RGBW Bulb2
- Override supported thermostat modes for Z-Wave.me ZME_FT
- Add Heatit ZM Dimmer
- Add Heatit Z-HAN2
- Add Remotec ZXT-800
- Clarify Hand Button action for ZVIDAR Z-CM-V01 Smart Curtain Motor
- Add MCOHome MH-S220 FW 3.2
- Add another device ID for Switch IO On/Off Power Switch
- Add/fix params for Intermatic PE653
- Add ShenZhen Sunricher Technology Multisensor SR-ZV9032A-EU
- Add new fingerprint for Zooz ZST10-700
- Fix Zooz ZSE40 parameters 7 and 8
- Correct parameters of Zooz ZEN05
- Override supported setpoint types for Intermatic PE653
- Update Inovelli LZW31 parameter 52 for FW 1.54
- Add new product id to Fakro ZWS12
- Disable Supervision for NICE Spa IBT4ZWAVE
- Add variant of Inovelli NZW31T with manufacturer ID 0x015d
- Split and correct Minoston MP21Z/MP31Z/MP21ZP/MP31ZP config files
- Add EVA LOGIK (NIE Tech) ZKS31 Rotary Dimmer

### Detailed changelogs

- [Bump Z-Wave JS Server to 1.29.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.29.0)
- [Bump Z-Wave JS Server to 1.29.1](https://github.com/zwave-js/zwave-js-server/releases/tag/1.29.1)
- [Bump Z-Wave JS Server to 1.30.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.30.0)
- [Bump Z-Wave JS to 10.23.4](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.23.4)
- [Bump Z-Wave JS to 10.23.5](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.23.5)
- [Bump Z-Wave JS to 10.23.6](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.23.6)
- [Bump Z-Wave JS to 11.0.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.0.0)
- [Bump Z-Wave JS to 11.1.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.1.0)
- [Bump Z-Wave JS to 11.2.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.2.0)
- [Bump Z-Wave JS to 11.3.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.3.0)
- [Bump Z-Wave JS to 11.4.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.4.0)
- [Bump Z-Wave JS to 11.4.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.4.1)
- [Bump Z-Wave JS to 11.4.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.4.2)
- [Bump Z-Wave JS to 11.5.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.5.0)
- [Bump Z-Wave JS to 11.5.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.5.1)
- [Bump Z-Wave JS to 11.5.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.5.2)
- [Bump Z-Wave JS to 11.5.3](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.5.3)
- [Bump Z-Wave JS to 11.6.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v11.6.0)

## 0.1.84

### Bug fixes

- Fixed an issue which could cause temperature to be shown in Celsius instead of Fahrenheit
- Fixed an issue which could cause devices to be incorrectly considered to be awake
- Verify state change for barrier devices without support for Supervision CC instead of assuming commands to succeed

### Config file changes

- Correct config parameters for Duwi ZW ESJ 300

### Detailed changelogs

- [Bump Z-Wave JS to 10.23.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.23.0)
- [Bump Z-Wave JS to 10.23.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.23.1)
- [Bump Z-Wave JS to 10.23.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.23.2)

## 0.1.83

### Bug fixes

- Fixed an issue introduced in Z-Wave JS `10.21.0` where some optimistic value updates would no longer happen after successful multicast commands

### Detailed changelogs

- [Bump Z-Wave JS to 10.22.3](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.22.3)

## 0.1.82

### Bug fixes

- Fixed a crash scenario
- Fixed an issue that caused device values to stop updating

### Config file changes

- Add LG U+ smart switches
- Add/correct config files for iSurpass J1825
- Added another variant of Kwikset 914C
- Add Dawon PM-S140-ZW, PM-S340-ZW and KR frequencies

### Detailed changelogs

- [Bump Z-Wave JS to 10.22.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.22.1)
- [Bump Z-Wave JS to 10.22.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.22.2)

## 0.1.81

### Bug fixes

- Fixed several crashes
- Expose some device functionality that would previously be hidden as redundant
- Auto-discovered config parameters (for new devices) can now be edited
- Properly support config parameters above number 255
- Optimized the config parameter queries during the interview to take much less time in many cases
- Some minor changes to better comply with the Z-Wave specification

### Config file changes

- Add configuration for Zooz ZEN53, 54, 55
- Extend version range for Vesternet VES-ZW-HLD-016
- Add 700 series variant of SimonTech Roller Blind
- Updated instructions for Leviton VRS15 and ZW15R

### Detailed changelogs

- [Bump Z-Wave JS to 10.21.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.21.0)
- [Bump Z-Wave JS to 10.20.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.20.0)
- [Bump Z-Wave JS to 10.19.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.19.0)
- [Bump Z-Wave JS to 10.18.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.18.0)
- [Bump Z-Wave JS to 10.17.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.17.1)

## 0.1.80

- [Bump Z-Wave JS to 10.17.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.17.0)

## 0.1.79

- [Bump Z-Wave JS to 10.16.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.16.0)

## 0.1.78

- [Bump Z-Wave JS Server to 1.28.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.28.0)
- [Bump Z-Wave JS to 10.15.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.15.0)
- [Bump Z-Wave JS to 10.14.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.14.1)
- [Bump Z-Wave JS to 10.14.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.14.0)
- [Bump Z-Wave JS to 10.13.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.13.0)

## 0.1.77

- [Bump Z-Wave JS Server to 1.27.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.27.0)
- [Bump Z-Wave JS to 10.12.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.12.0)
- [Bump Z-Wave JS to 10.11.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.11.1)
- [Bump Z-Wave JS to 10.11.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.11.0)

## 0.1.76

- [Bump Z-Wave JS Server to 1.26.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.26.0)
- [Bump Z-Wave JS to 10.10.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.10.0)

## 0.1.75

- [Bump Z-Wave JS Server to 1.25.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.25.0)
- [Bump Z-Wave JS to 10.5.4](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.5.4)

## 0.1.74

- [Bump Z-Wave JS Server to 1.24.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.24.0)
- [Bump Z-Wave JS to 10.3.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.3.0)

## 0.1.73

- [Bump Z-Wave JS Server to 1.23.1](https://github.com/zwave-js/zwave-js-server/releases/tag/1.23.1)
- [Bump Z-Wave JS to 10.2.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.2.0)
- Bump Z-Wave JS to test build to try to address memory leak
- Revert to default base image

## 0.1.72

- Use same base image as community add-on zwave-js-ui

## 0.1.71

- [Bump Z-Wave JS to 10.1.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.1.0)

## 0.1.70

- [Bump Z-Wave JS to 10.0.4](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.0.4)

## 0.1.69

- Use edge version of NodeJS (16.17.0)
- Bump Alpine to 3.16

## 0.1.68

- [Bump Z-Wave JS to 10.0.3](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.0.3)

## 0.1.67

- [Bump Z-Wave JS to 10.0.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.0.2)

## 0.1.66

- [Bump Z-Wave JS Server to 1.22.1](https://github.com/zwave-js/zwave-js-server/releases/tag/1.22.1)
- [Bump Z-Wave JS to 10.0.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v10.0.1)

## 0.1.65

- [Bump Z-Wave JS Server to 1.21.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.21.0)
- [Bump Z-Wave JS to 9.6.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v9.6.2)

## 0.1.64

- Fix finish script for S6 V3

## 0.1.63

- [Bump Z-Wave JS Server to 1.20.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.20.0)

## 0.1.62

- [Bump Z-Wave JS Server to 1.19.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.19.0)

## 0.1.61

- [Bump Z-Wave JS to 9.4.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v9.4.0)
- [Bump Z-Wave JS Server to 1.18.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.18.0)

## 0.1.60

- Fix permissions issue with startup scripts

## 0.1.59

- [Bump Z-Wave JS to 9.3.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v9.3.0)
- [Bump Z-Wave JS Server to 1.17.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.17.0)

## 0.1.58

- [Bump Z-Wave JS to 9.0.7](https://github.com/zwave-js/node-zwave-js/releases/tag/v9.0.7)
- [Bump Z-Wave JS Server to 1.16.1](https://github.com/zwave-js/zwave-js-server/releases/tag/1.16.1)

## 0.1.57

- [Bump Z-Wave JS to 9.0.4](https://github.com/zwave-js/node-zwave-js/releases/tag/v9.0.4)

## 0.1.56

- [Bump Z-Wave JS to 9.0.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v9.0.2)
- [Bump Z-Wave JS Server to 1.16.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.16.0)

## 0.1.55

- [Bump Z-Wave JS to 8.11.9](https://github.com/zwave-js/node-zwave-js/releases/tag/v8.11.9)

## 0.1.54

- [Bump Z-Wave JS to 8.11.6](https://github.com/zwave-js/node-zwave-js/releases/tag/v8.11.6)
- [Bump Z-Wave JS Server to 1.15.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.15.0)

## 0.1.53

- [Bump Z-Wave JS to 8.11.5](https://github.com/zwave-js/node-zwave-js/releases/tag/v8.11.5)

## 0.1.52

- [Bump Z-Wave JS to 8.10.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v8.10.2)
- [Bump Z-Wave JS Server to 1.14.1](https://github.com/zwave-js/zwave-js-server/releases/tag/1.14.1)

## 0.1.51

- [Bump Z-Wave JS to 8.9.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v8.9.2)
- [Bump Z-Wave JS Server to 1.14.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.14.0)

## 0.1.50

- [Bump Z-Wave JS to 8.8.3](https://github.com/zwave-js/node-zwave-js/releases/tag/v8.8.3)

## 0.1.49

- [Bump Z-Wave JS to 8.7.7](https://github.com/zwave-js/node-zwave-js/releases/tag/v8.7.7)
- [Bump Z-Wave JS Server to 1.12.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.12.0)

## 0.1.48

- [Bump Z-Wave JS to 8.7.6](https://github.com/zwave-js/node-zwave-js/releases/tag/v8.7.6)
- [Bump Z-Wave JS Server to 1.11.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.11.0)

## 0.1.47

- Disable soft-reset if VM is detected

## 0.1.46

- [Bump Z-Wave JS to 8.7.5](https://github.com/zwave-js/node-zwave-js/releases/tag/v8.7.5)
- [Bump Z-Wave JS Server to 1.10.8](https://github.com/zwave-js/zwave-js-server/releases/tag/1.10.8)

## 0.1.45

- [Bump Z-Wave JS Server to 1.10.7](https://github.com/zwave-js/zwave-js-server/releases/tag/1.10.7)

## 0.1.44

- Fix casing issues with security keys
- Fix `emulate_hardware` configuration option

## 0.1.43

- [Bump Z-Wave JS Server to 1.10.6](https://github.com/zwave-js/zwave-js-server/releases/tag/1.10.6)

## 0.1.42

- Retain legacy network_key config option to stay backwards compatible.

## 0.1.41

- [Bump Z-Wave JS Server to 1.10.5](https://github.com/zwave-js/zwave-js-server/releases/tag/1.10.5)
- [Bump Z-Wave JS to 8.4.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v8.4.1)
- Add support for S2 keys in the addon configuration (check the Security Keys section of the configuration docs for more details)

## 0.1.40

- [Bump Z-Wave JS to 8.3.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v8.3.0)

## 0.1.39

- [Bump Z-Wave JS to 8.2.3](https://github.com/zwave-js/node-zwave-js/releases/tag/v8.2.3)

## 0.1.38

- [Bump Z-Wave JS Server to 1.10.3](https://github.com/zwave-js/zwave-js-server/releases/tag/1.10.3)
- [Bump Z-Wave JS to 8.2.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v8.2.1)

## 0.1.37

- [Bump Z-Wave JS Server to 1.10.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.10.0)

## 0.1.36

- [Bump Z-Wave JS to 8.1.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v8.1.1)

## 0.1.35

- [Bump Z-Wave JS Server to 1.9.3](https://github.com/zwave-js/zwave-js-server/releases/tag/1.9.3)
- [Bump Z-Wave JS to 8.0.8](https://github.com/zwave-js/node-zwave-js/releases/tag/v8.0.8)

## 0.1.34

- [Bump Z-Wave JS Server to 1.9.2](https://github.com/zwave-js/zwave-js-server/releases/tag/1.9.2)

## 0.1.33

- [Bump Z-Wave JS to 8.0.6](https://github.com/zwave-js/node-zwave-js/releases/tag/v8.0.6)

## 0.1.32

- [Bump Z-Wave JS to 8.0.5](https://github.com/zwave-js/node-zwave-js/releases/tag/v8.0.5)

## 0.1.31

- [Bump Z-Wave JS Server to 1.9.1](https://github.com/zwave-js/zwave-js-server/releases/tag/1.9.1)

## 0.1.30

- [Bump Z-Wave JS to 8.0.3](https://github.com/zwave-js/node-zwave-js/releases/tag/v8.0.3)
- [Bump Z-Wave JS Server to 1.9.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.9.0)

## 0.1.29

- [Bump Z-Wave JS to 7.12.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v7.12.0)

## 0.1.28

- [Bump Z-Wave JS to 7.10.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v7.10.0)
- [Bump Z-Wave JS Server to 1.8.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.8.0)

## 0.1.27

- [Bump Z-Wave JS to 7.9.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v7.9.0)

## 0.1.26

- [Bump Z-Wave JS to 7.7.4](https://github.com/zwave-js/node-zwave-js/releases/tag/v7.7.4)

## 0.1.25

- [Bump Z-Wave JS to 7.7.3](https://github.com/zwave-js/node-zwave-js/releases/tag/v7.7.3)

## 0.1.24

- [Bump Z-Wave JS to 7.7.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v7.7.0)
- Create persistent directory for device config files to allow for future config updating functionality through the Home Assistant UI.

## 0.1.23

- [Bump Z-Wave JS Server to 1.7.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.7.0)
- [Pin Z-Wave JS to 7.6.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v7.6.0)

## 0.1.22

- [Bump Z-Wave JS Server to 1.6.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.6.0)
- [Pin Z-Wave JS to 7.5.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v7.5.2)

## 0.1.21

- [Pin Z-Wave JS to 7.3.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v7.3.0)

## 0.1.20

- [Bump Z-Wave JS Server to 1.5.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.5.0)
- [Pin Z-Wave JS to 7.2.4](https://github.com/zwave-js/node-zwave-js/releases/tag/v7.2.4)

## 0.1.19

- [Pin Z-Wave JS to 7.2.3](https://github.com/zwave-js/node-zwave-js/releases/tag/v7.2.3)
- Make log level a configuration option

## 0.1.18

- [Pin Z-Wave JS to 7.2.2](https://github.com/zwave-js/node-zwave-js/releases/tag/v7.2.2)

## 0.1.17

- [Bump Z-Wave JS Server to 1.4.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.4.0)
- [Pin Z-Wave JS to 7.1.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v7.1.1)

## 0.1.16

- [Bump Z-Wave JS Server to 1.3.1](https://github.com/zwave-js/zwave-js-server/releases/tag/1.3.1)

## 0.1.15

- [Pin Z-Wave JS to version 7.0.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v7.0.1)

## 0.1.14

- [Bump Z-Wave JS Server to 1.3.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.3.0)
- [Pin Z-Wave JS to version 7.0.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v7.0.0)

## 0.1.13

- [Bump Z-Wave JS Server to 1.2.1](https://github.com/zwave-js/zwave-js-server/releases/tag/1.2.1)
- [Pin Z-Wave JS to version 6.6.3](https://github.com/zwave-js/node-zwave-js/releases/tag/v6.6.3)
- Unpin Z-Wave JS dependencies

## 0.1.12

- [Bump Z-Wave JS to 6.5.1](https://github.com/zwave-js/node-zwave-js/releases/tag/v6.5.1)
- Pin Z-Wave JS dependencies

## 0.1.11

- [Bump Z-Wave JS Server to 1.1.1](https://github.com/zwave-js/zwave-js-server/releases/tag/1.1.1)

## 0.1.10

- [Bump Z-Wave JS Server to 1.1.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.1.0) This is the same code as 2.0.0. Home Assistant 2021.2 rejects any ZJS Server version that is v2+

## 0.1.9

- Bump Z-Wave JS Server to 2.0.0

## 0.1.8

- [Bump Z-Wave JS Server to 1.0.0](https://github.com/zwave-js/zwave-js-server/releases/tag/1.0.0)
- [Pin Z-Wave JS to version 6.5.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v6.5.0)

## 0.1.7

- [Bump Z-Wave JS Server to 1.0.0-beta.6](https://github.com/zwave-js/zwave-js-server/releases/tag/1.0.0-beta.6)

## 0.1.6

- [Update Z-Wave JS to version 6.2.0](https://github.com/zwave-js/node-zwave-js/releases/tag/v6.2.0)

## 0.1.5

- Update hardware configuration for Supervisor 2021.02.5
- [Upgrade Z-Wave JS Server to 1.0.0-beta.5](https://github.com/zwave-js/zwave-js-server/releases/tag/1.0.0-beta.5)
- [Pin Z-Wave JS to version 6.1.3](https://github.com/zwave-js/node-zwave-js/releases/tag/v6.1.3)

## 0.1.4

- [Bump Z-Wave JS Server to 1.0.0-beta.4](https://github.com/zwave-js/zwave-js-server/releases/tag/1.0.0-beta.4)

## 0.1.3

- [Bump Z-Wave JS Server to 1.0.0-beta.3](https://github.com/zwave-js/zwave-js-server/releases/tag/1.0.0-beta.3)

## 0.1.2

- [Bump Z-Wave JS Server to 1.0.0-beta.2](https://github.com/zwave-js/zwave-js-server/releases/tag/1.0.0-beta.2)

## 0.1.1

- [Bump Z-Wave JS Server to 1.0.0-beta.1](https://github.com/zwave-js/zwave-js-server/releases/tag/1.0.0-beta.1)

## 0.1.0

- Initial release
