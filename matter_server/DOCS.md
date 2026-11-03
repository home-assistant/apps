# Home Assistant App: Matter Server

## Installation

Use the following steps to install this app.

1. Click the Home Assistant My button below to open the app page on your
   Home Assistant instance.

   [![Open this app in your Home Assistant instance.][addon-badge]][addon]

1. Click the "Install" button to install the app.

## How to use

Start the Matter Server app to make the WebSocket available to Home
Assistant Core. Install the [Matter integration][matter_integration]
in Home Assistant Core.

### Access WebSocket interface externally (advanced)

By default, the OHF Matter Server's WebSocket interface is only exposed
internally. It is still possible to enable access through the host interface.
To do so, click on "Show disabled ports" and enter a port (e.g. 5580) in the
Matter Server WebSocket server port field.

## Server variants

> **⚠️ Make a full backup before updating to 9.0.0.** This is a major migration
> to a new server. Keep the Supervisor's "Create backup" option enabled when you
> update, so you can roll back if needed.

Starting with version 9.0.0 this app runs the [matter.js Matter
Server][matter_server_repo] exclusively. The Python Matter Server has been
removed; existing data is migrated automatically with no user action required.

The server version bundled in the app image is used by default. The **Beta**
flag installs the latest `matter-server` from npm on top of it, and
`matter_server_version` installs a specific version (see below).

> [!NOTE]
> The **Beta** flag keeps its previous value across this update. If you enabled
> it for the earlier matter.js beta, it stays on after updating to 9.0.0.
> matter.js is now the default, so you can turn it off — but more betas will
> follow, so keep it on if you want to keep testing pre-releases.

## Configuration

App configuration:

| Configuration          | Description                                                                                                                                                                                                                                                                                                                                              |
| ---------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| log_level              | Logging level of the Matter Server component.                                                                                                                                                                                                                                                                                                            |
| beta                   | Install the latest `matter-server` from npm on startup instead of the bundled version. On failure a warning is logged and the bundled version is started.                                                                                                                                                                                                |
| enable_test_net_dcl    | Enable test-net DCL for PAA root certificates, OTA updates and other device information.                                                                                                                                                                                                                                                                 |
| time_sync              | Whether the Matter Server pushes the current time to Matter devices: `auto` (default; on only when the host clock is NTP synchronized), `on` (always; warns if NTP is not synchronized), or `off`.                                                                                                                                                       |
| default_fabric_label   | Pin the fabric label (shown on Matter devices, max 32 characters) to this value. By default the Home Assistant home name is used. This is useful if the Matter Server is used from multiple Home Assistant instances, which otherwise each keep pushing their own home name as the label. When set, changing the label via the WebSocket API is blocked. |
| ble_proxy              | Expose the BLE proxy endpoint so the Home Assistant Matter integration can drive BLE commissioning through Home Assistant's bluetooth stack. Mutually exclusive with `bluetooth_adapter_id`.                                                                                                                                                             |
| bluetooth_adapter_id   | **Deprecated** — use `ble_proxy` instead. Set BlueZ Bluetooth Controller ID (for local commissioning). Still works for now.                                                                                                                                                                                                                              |
| matter_server_args     | Extra command-line arguments passed to the Matter Server at startup (advanced).                                                                                                                                                                                                                                                                          |
| matter_server_env_vars | Extra environment variables exported before the server starts. Use `KEY=VALUE` entries.                                                                                                                                                                                                                                                                  |
| matter_server_version  | Install this specific `matter-server` version from npm (advanced; takes precedence over **Beta**). Values with a major version >= 3 are ignored (these are Python Matter Server versions); unless **Beta** is set, the bundled version is used.                                                                                                          |

### `matter_server_env_vars`

```yaml
matter_server_env_vars:
  - NODE_OPTIONS=--max-old-space-size=512
  - MY_FLAG=true
```

## Support

Got questions?

You have several options to get them answered:

- The [Home Assistant Discord Chat Server][discord].
- The Home Assistant [Community Forum][forum].
- Join the [Reddit subreddit][reddit] in [/r/homeassistant][reddit]

In case you've found a bug, please [open an issue on our GitHub][issue].

[addon]: https://my.home-assistant.io/redirect/supervisor_addon/?addon=core_matter_server
[addon-badge]: https://my.home-assistant.io/badges/supervisor_addon.svg
[discord]: https://www.home-assistant.io/join-chat
[forum]: https://community.home-assistant.io
[reddit]: https://reddit.com/r/homeassistant
[issue]: https://github.com/home-assistant/app-matter-server/issues
[matter_server_repo]: https://github.com/matter-js/matterjs-server
[matter_integration]: https://www.home-assistant.io/integrations/matter/
