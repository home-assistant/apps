# Home Assistant App: Silicon Labs Flasher App

## Installation

Follow these steps to get the app installed on your system:

1. Navigate in your Home Assistant frontend to **Settings** > **Apps** > **App Store**.
2. Find the "Silicon Labs Flasher" app and click it.
3. Click on the "INSTALL" button.

## How to use

The app needs a Silicon Labs based wireless module accessible through a
serial port (like the module on Home Assistant Yellow, Home Assistant
Connect ZBT-1/ZBT-2 or other USB based wireless adapters).

The app does not ship any firmware. It always flashes the firmware from
`firmware_url`, no matter which version is currently installed.

1. Select the correct `device` in the app configuration tab.
2. Set `firmware_url` to the firmware you want to flash.
3. If your device is listed under `profile`, select it.
4. Press `Save` and start the app.

Home Assistant Yellow, Connect ZBT-1 and Connect ZBT-2 can also be updated
directly from Home Assistant, without this app.

## Configuration

App configuration:

| Configuration            | Description                                                              |
| ------------------------ | ------------------------------------------------------------------------ |
| device (mandatory)       | Serial service where the Silicon Labs radio is attached                  |
| firmware_url (mandatory) | URL of the firmware to flash (GBL file, or a ZIP archive containing one) |
| profile                  | Predefined flashing profile of a known device                            |
| probe_methods            | Application type and baudrate pairs used to detect the running firmware  |
| bootloader_reset         | Reset methods used to enter the bootloader                               |
| verbose                  | Start universal-silabs-flasher in verbose mode                           |

### Option: `profile`

Selects how the bootloader is entered and which baudrates are probed for a
known device: `yellow`, `zbt1`, `zbt2`, `ihost`, `slzb07` or `rts_dtr`.
Cannot be combined with `probe_methods` or `bootloader_reset`.

### Option: `probe_methods`

Comma-separated list of `<application_type>:<baudrate>` pairs, tried in
order, for example `bootloader:115200,ezsp:115200,spinel:460800`. Valid
application types are `bootloader`, `cpc`, `ezsp`, `spinel`,
`spinel_ziggurat`, `router` and `zwave`. Use this if your firmware or
bootloader runs at a non-default baudrate.

### Option: `bootloader_reset`

Comma-separated list of reset methods used to enter the bootloader:
`yellow`, `ihost`, `slzb07`, `rts_dtr` or `baudrate`. On Home Assistant
Yellow the `yellow` reset is used automatically.

## Support

Got questions?

You have several options to get them answered:

- The [Home Assistant Discord Chat Server][discord].
- The Home Assistant [Community Forum][forum].
- Join the [Reddit subreddit][reddit] in [/r/homeassistant][reddit]

In case you've found a bug, please [open an issue on our GitHub][issue].

[discord]: https://www.home-assistant.io/join-chat
[forum]: https://community.home-assistant.io
[reddit]: https://reddit.com/r/homeassistant
[issue]: https://github.com/home-assistant/app-silabs-flasher/issues
