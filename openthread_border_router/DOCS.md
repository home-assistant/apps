# Home Assistant App: OpenThread Border Router

## Installation

Follow these steps to get the app (formerly known as add-on) installed on your system:

1. In Home Assistant, go to **Settings** > **Apps** > **Install app**.
2. Find the **OpenThread Border Router** app and select it.
3. Select the **Install** button.

## How to use

You will need a 802.15.4 capable radio supported by OpenThread flashed with OpenThread
RCP firmware:

- Home Assistant Yellow
- Home Assistant SkyConnect/Connect ZBT-1
- Home Assistant Connect ZBT-2

These devices are all capable to run OpenThread and will be flashed with the correct
firmware by Home Assistant Core.

If you are using Home Assistant Yellow, choose `/dev/ttyAMA1` as device.

### Alternative radios

The website [openthread.io maintains a list of supported platforms][openthread-platforms]
lists other Thread capable radios. A well documented Radio for development is the
Nordic Semiconductor [nRF52840 Dongle][nordic-nrf52840-dongle]. The Dongle needs
a recent version of the OpenThread RCP firmware.
[This article][nordic-nrf52840-dongle-install] outlines the steps to install the
RCP firmware for the nRF52840 Dongle.

Once the firmware is loaded follow the following steps:

1. Select the correct `device` in the app configuration tab and press `Save`.
2. Start the app.

### OpenThread Border Router

This app makes your Home Assistant installation an OpenThread Border Router
(OTBR). The border router can be used to comission Matter devices which connect
through Thread. Home Assistant Core will automatically detect this app and
create a new integration named "Open Thread Border Router". With Home Assistant
Core 2023.3 and newer the OTBR will get configured automatically. The Thread
integration allows to inspect the network configuration.

### Web interface (advanced)

There is also a web interface provided by the OTBR. However, the web
interface has caveats (e.g. forming a network does not generate an off-mesh
routable IPv6 prefix which causes changing IPv6 addressing on first app
restart). It is still possible to enable the web interface for debugging
purpose. Make sure to expose both the Web UI port and REST API port (the
latter needs to be on port 8081) on the host interface. To do so, click on
"Show disabled ports" and enter a port (e.g. 8080) in the OpenThread Web UI
and 8081 in the OpenThread REST API port field).

## Configuration

App configuration:

| Configuration      | Description                                                                       |
| ------------------ | --------------------------------------------------------------------------------- |
| device (mandatory) | Serial port where the OpenThread RCP Radio is attached                            |
| baudrate           | Serial port baudrate (depends on firmware)                                        |
| flow_control       | If hardware flow control should be enabled (depends on firmware)                  |
| otbr_log_level     | Set the log level of the OpenThread BorderRouter Agent                            |
| firewall           | Enable OpenThread Border Router firewall to block unnecessary traffic             |
| nat64              | Enable NAT64 to allow Thread devices accessing IPv4 addresses                     |
| network_device     | IP address and port to connect to a network-based RCP (see below)                 |
| beta               | Enable beta mode to run a newer, experimental version of OpenThread Border Router |

> [!WARNING]
> The OTBR expects the RCP connected radio to be on a reliable link such as
> UART or SPI. Using TCP/IP to reach a remote RCP radio breaks this assumption.
> If the TCP/IP connection fails, the OTBR will not shutdown cleanly and leave
> stale routes in your network. This will lead to Thread devices to be
> potentially unreachable for up to 30 minutes (route lifetime) even when other
> routers are available.
>
> The RCP protocol is not designed to be transferred over an IP network: It is
> a timing-sensitive protocol. You might experience Thread issues if your
> network link has excessive latencies. As Thread is networking capable,
> running a Thread border router on the system the RCP radio is plugged in is
> recommended.

> [!NOTE]
> When using a network device, you still need to set a dummy serial port device, e.g. `/dev/ttyS3`.

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
[issue]: https://github.com/home-assistant/app-openthread-border-router/issues
[openthread-platforms]: https://openthread.io/platforms
[nordic-nrf52840-dongle]: https://www.nordicsemi.com/Products/Development-hardware/nrf52840-dongle
[nordic-nrf52840-dongle-install]: https://docs.nordicsemi.com/bundle/ncs-latest/page/nrf/protocols/thread/tools.html#configuring_a_radio_co-processor
