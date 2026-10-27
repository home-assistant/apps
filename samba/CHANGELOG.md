# Changelog

## 12.11.0

- Add service discovery using DNS-SD/mDNS controlled by the `network_discovery` configuration option added in 12.9.0.

## 12.10.0

- Rename the `addons` and `addon_configs` shares to `local_apps` and `app_configs` to match Home Assistant's app terminology. Existing `enabled_shares` configurations are migrated automatically on start (extending the lower-case normalization added in 12.8.1).
- Both the new (`local_apps`/`app_configs`) and legacy (`addons`/`addon_configs`) share names stay exposed, so existing SMB connections keep working while you move to the new names.
- Log a warning when a client connects to a deprecated `addons`/`addon_configs` share, indicating which new share to switch to.
- Exit cleanly with code 0 on shutdown instead of 143, so the Supervisor no longer warns about the add-on not handling `SIGTERM`.
- Migrate to the new `local_apps` and `all_app_configs` folder mappings introduced in Home Assistant Supervisor.
- Update base image to 3.24-2026.06.1

## 12.9.0

- Add configuration option to disable WSDD. When disabled, the wsdd service is
  not started and the host is no longer advertised for automatic discovery.
  Shares remain reachable by hostname or IP address.

## 12.8.1

- Normalize stored `enabled_shares` values to lower case at startup. Values
  were already handled case-insensitively at runtime; this persists the
  canonical form in preparation for a stricter schema in a future release.

## 12.8.0
- Add configuration option to disable NetBIOS. When disabled, the nmbd service is not started and only port 445 is allowed (port 139 is blocked.)

## 12.7.1

- Enabled kernel oplocks in smb.conf to ensure changes made to files on disk are available immediately via SMBD. This covers all shares except backup, and media as the contents shouldn't be changed by the server once they're written in those shares.

## 12.7.0

- Add Windows automatic discovery support with WSDD

## 12.6.1

- Support spaces in configurable username

## 12.6.0

- Do initial healthcheck after 3s to speedup startup
- Update base image to Alpine 3.23 (base image tag 3.23-2026.02.0)
- Drop builds of unsupported architectures

## 12.5.4

- Fix invalid inverted commas in server signing parameter

## 12.5.3

- Add option for setting server signing parameter

## 12.5.2

- Avoid binding to disabled network interfaces

## 12.5.1

- Add configurations option to disable Apple devices interoperability. Disabling this setting might be required for file systems that do not support extended attributes such as exFAT.

## 12.5.0

- Add the ability to enable and disable trying to become a local master browser on a subnet

## 12.4.0

- Add the ability to enable and disable specific shares, improving user control over folder access

## 12.3.3

- Enable Samba configurations to improve interoperability with Apple devices

## 12.3.2

- Suppress benign idmap logged error

## 12.3.1

- Handle passwords with backslash correctly

## 12.3.0

- Upgrade Alpine Linux to 3.19

## 12.2.0

- Decrease Samba log level

## 12.1.0

- Use the new Home Assistant folder for the `config` share
- Add support for accessing public add-on configurations

## 12.0.0

- Temporary remove access to add-on config shares, until Supervisor 2023.11.2 has been rolled out stable
- Revert `config` share name change to avoid user facing change
- Adjust location of Home Assistant config to match latest dev/beta Supervisor
- Migrate add-on layout to S6 Overlay

## 11.0.0

- The `config` share has been renamed to `homeassistant` to match upstream changes.
- Add support for accessing public add-on configurations
- Update to Alpine 3.18
- Adds HEALTCHECK support

## 10.0.2

- Enable IPv6 ULA and IPv4 link-local addresses by default

## 10.0.1

- Update to Alpine 3.17

## 10.0.0

BREAKING CHANGE: Don't mangle filenames

By default, Samba mangles filenames with special characters to ensure
compatibility with really old versions of Windows which have a very limited
charset for filenames. The add-on no longer does this as modern operating
systems do not have these restrictions.

- Don't mangle filenames (fixes #2541)
- Upgrade Alpine Linux to 3.16

## 9.7.0

- Upgrade Alpine Linux to 3.15
- Sign add-on with Codenotary Community Attestation Service (CAS)

## 9.6.1

- Remove lo from interface list
- Exit with error if there are no supported interfaces to run Samba on

## 9.6.0

- Run on all supported interfaces

## 9.5.1

- Add `hassio_api` to add-on configuration

## 9.5.0

- Remove interface options in favor of network

## 9.4.0

- Upgrade Alpine Linux to 3.13
- Rewrite configuration generation code

## 9.3.1

- Update options schema for passwords

## 9.3.0

- Support new media folder
- Update Samba to 4.12.6
- Upgrade Alpine Linux to 3.12

## 9.2.0

- Pin base image version
- Rewrite add-on onto S6 Overlay
- Use default configuration location
- Add support for running in compatibility mode (SMB1/NT1)
- Add dummy files to reduce number of errors/warnings in log output

## 9.1.0

- Allow IPv6 link-local hosts by default, consistent with IPv4

## 9.0.0

- New option `veto_files` to limit writing of specified files to the share

## 8.3.0

- Fixes a bug in warning log message, causing start failure
- Minor code cleanups

## 8.2.0

- Update from bash to bashio

## 8.1.0

- Update Samba to version 4.8.8

## 8.0.0

- Fix access to /backup
