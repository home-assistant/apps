# Changelog

## 1.0.0

- Update base image to 3.14-alpine3.24-2026.11.1
- Print flashing progress as plain log lines
- Use bashio::app functions and app wording
- Update universal-silabs-flasher to v1.3.0 and rework options
- Move the s6 user bundle to user-bundles.d
- Publish app to GHCR

## 0.5.0

- Detect Home Assistant Yellow correctly on latest HAOS versions
- Add additional log messages for download and flashing
- Update universal-silabs-flasher to 0.0.37
- Upgrade to Alpine 3.23
- Remove unsupported architectures (armhf, armv7, i386)

## 0.4.0

- Upgrade to Alpine 3.22
- Update universal-silabs-flasher to v0.0.36

## 0.3.4

- Make custom ezsp baudrate a truly optional configuration

## 0.3.3

- Allow to start universal-silabs-flasher with custom ezsp baudrate

## 0.3.2

- Update flasher script to work with Home Assistant Yellow with CM5

## 0.3.1
- Update firmwares to EmberZNet 7.4.4
- Update universal-silabs-flasher to v0.0.25

## 0.3.0
- Update firmwares to EmberZNet 7.4.3
- Update universal-silabs-flasher to v0.0.22

## 0.2.3

- Upgrade to Alpine 3.19

## 0.2.2

- Update universal-silabs-flasher to v0.0.19

## 0.2.1

- Support flashing the Connect ZBT-1.

## 0.2.0

- Update universal-silabs-flasher to v0.0.13
- Update firmware for Home Assistant Yellow and SkyConnect to v7.3.1.0
- Use Alpine 3.17/Python 3.11 base image

## 0.1.1

- Fix firmware installation from URL
- Exit add-on after flashing completed
- Allow to start universal-silabs-flasher in verbose mode

## 0.1.0

- initial version
