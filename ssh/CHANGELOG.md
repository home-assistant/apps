# Changelog

## 10.6.0

This release updates OpenSSH to 10.3_p1-r2, which fixes a password authentication bypass in the SSH server ([see OpenSSH release notes](https://www.openssh.org/releasenotes.html#10.6p2)). Note that the issue should not be exploitable with the default setup of this app, even when password authentication is enabled.

- Update base image to 3.24-2026.10.3
- Enable screen reader mode in the web terminal
- Update home-assistant/cli to v5.6.0
- Publish app to GHCR

## 10.5.0

- Update Home Assistant CLI to 5.5.0
- Rename the `/addons` and `/addon_configs` bind mounts to `/local_apps` and `/app_configs` to match Home Assistant's app terminology.

## 10.4.0

- Update to Alpine 3.24
- Update Home Assistant CLI to 5.3.1

## 10.3.0

- Update Home Assistant CLI to 5.2.0

## 10.2.0

- Update Home Assistant CLI to 5.1.0
- Update base image to 3.23-2026.04.0

## 10.1.0

- Update Home Assistant CLI to 5.0.0
- Update base image to 3.23-2026.03.1

## 10.0.2

- Remove advanced flag in the app config

## 10.0.1

- Fix default shell

## 10.0.0

- Upgrade to Alpine 3.23
- Upgrade Home Assistant CLI to 4.46.0
- Use ttyd from Alpine package repository

## 9.22.0

- Upgrade Home Assistant CLI to 4.45.0

## 9.21.0

- Remove support for armhf, armv7, and i386 architectures
- Upgrade Home Assistant CLI to 4.44.0

## 9.20.1

- Fix default shell

## 9.20.0

- Upgrade Home Assistant CLI to 4.41.0
- Upgrade to Alpine Linux 3.22
- Upgrade libwebsockets to 4.4.1

## 9.19.0

- Disable keyboard interactive authentication method if keys are used

## 9.18.0

- Upgrade Home Assistant CLI to 4.39.0

## 9.17.0

- Upgrade Home Assistant CLI to 4.38.0
- Upgrade libwebsockets to 4.3.5

## 9.16.0

- Upgrade ttyd to 1.7.7 (fixes copy to clipboard using shift and drag)

## 9.15.0

- Upgrade Home Assistant CLI to 4.36.0

## 9.14.0

- Upgrade Home Assistant CLI to 4.34.0

## 9.13.0

- Enable ha command completion for non-login shell (e.g. the web terminal)

## 9.12.0

- Install completions for ha commands
- Fix bash_history file check in startup

## 9.11.0

- Upgrade Home Assistant CLI to 4.32.0

## 9.10.0

- Upgrade Home Assistant CLI to 4.31.0

## 9.9.0

- Upgrade to Alpine Linux 3.19
- Upgrade Home Assistant CLI to 4.29.0
- Upgrade libwebsockets to 4.3.3
- Upgrade ttyd to 1.7.4

## 9.8.1

- Add `/config` symlink to for backward and docs compatibility.

## 9.8.0

- Please note: the `/config` folder has been renamed to `/homeassistant`.
- Add support for accessing public add-on configurations
- Upgrade to Alpine 3.18

## 9.7.1

- Upgrade Home Assistant CLI to 4.26.0

## 9.7.0

- Upgrade Home Assistant CLI to 4.23.0
- Upgrade to Alpine 3.17
- Update ttyd to 1.7.3
- Update libwebsockets to 4.3.2

## 9.6.2

- Make SUPERVISOR_TOKEN available as an SSH environment variable,
  making it possible to invoke the Home Assistant CLI
  without an interactive bash session.

## 9.6.1

- Upgrade Home Assistant CLI to 4.21.0

## 9.6.0

**Breaking change**: RSA keys generated using the SHA-1 hash algorithm
were disabled by OpenSSH due to a security vulnerability. If you find
your RSA key does not work after update you will need to make a new key
with a stronger algorithm or switch to an ECDSA or Ed25519 type key. For
more information see [OpenSSH v8.8 release notes](https://www.openssh.com/releasenotes.html).

- Upgrade Home Assistant CLI to 4.18.0
- Upgrade to Alpine 3.16
- Refactor out usage of fix-attrs for s6 v3

## 9.4.0

- Upgrade Home Assistant CLI to 4.17.0
- Enabled image signature

## 9.3.0

- Update libwebsockets to 4.2.1
- Update ttyd to `3e37e33b1cd927ae8f25cfbcf0da268723b6d230`

## 9.2.2

- Fix escape codes in color bash prompt

## 9.2.1

- Upgrade Home Assistant CLI to 4.14.0

## 9.2.0

- Upgrade to Alpine 3.14
- Make Bash prompt more colorful
- Upgrade Home Assistant CLI to 4.13.0

## 9.1.3

- Upgrade Home Assistant CLI to 4.12.3

## 9.1.2

- Upgrade Home Assistant CLI to 4.12.2

## 9.1.1

- Use GitHub Container Registry for the base image
- Upgrade Home Assistant CLI to 4.12.1
- Upstream ttyd project now uses the main branch

## 9.1.0

- Upgrade Home Assistant CLI to 4.11.0
- Support APKs installation on startup

## 9.0.2

- Update options schema for passwords

## 9.0.1

- Upgrade Home Assistant CLI to 4.10.1

## 9.0.0

- Upgrade Alpine Linux to 3.13
- Update Home Assistant CLI to 4.10.0
- Use new HA banner on login

## 8.10.0

- Update Home Assistant CLI to 4.9.0

## 8.9.1

- Fix bluez package

## 8.9.0

- Update Home Assistant CLI to 4.4.1
- Add Bluetooth support

## 8.8.1

- Support new media folder

## 8.8.0

- Update Home Assistant CLI to 4.4.1
- Wrap system shutdown/reboot to supervisor

## 8.7.0

- Update Home Assistant CLI to 4.4.0
- Upgrade Alpine Linux to 3.12

## 8.6.0

- Add support for local TCP forwarding

## 8.5.4

- Update Home Assistant CLI to 4.3.0

## 8.5.3

- Update Home Assistant CLI to 4.2.0

## 8.5.2

- Update Home Assistant CLI to 4.1.0

## 8.5.1

- Show warning if SSH port is disabled

## 8.5.0

- Add support for PulseAudio with new Audio backend
- Migrate to s6-overlay

## 8.4.0

- Support to use only web terminal without SSH server

**ATTENTION:** If you want access with SSH, you need maybe add the Port setting option back.

## 8.3.0

- Update Home Assistant CLI to 4.0.1
- Add backward compatibility with the hassio command
- Update Web terminal to ttyd 1.6.0 with Libwebsockets 3.2.2
- Rename HASSIO_TOKEN to SUPERVISOR_TOKEN in shell profile

## 8.2.0

- Fix creation of new tmux terminal windows
- Add add-on icon
- Update welcome logo
- Fix SSH folder issue with authorized keys

## 8.1.0

- Fix for non existing .bash_profile startup error
- Add current, short, path to command line prompt

## 8.0.0

- Add support for a web-based terminal via Ingress
- Upgrade Alpine Linux to 3.11
- Improve Hass.io API token handling
- Persist .ssh folder across restarts
- Add helper symlink folders to user home folder
