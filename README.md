# Home Assistant Apps: The official repository

Apps (formerly known as add-ons) for Home Assistant allow you to extend the functionality
around your Home Assistant setup. These apps can consist of an application
that Home Assistant can integrate with (e.g., a [MQTT broker](/mosquitto/README.md) or [database server](/mariadb/README.md))
or allow access to your Home Assistant configuration (e.g., via [Samba](/samba/README.md) or using
the [File Editor](/configurator/README.md)).

Apps can be installed and configured via the Home Assistant frontend on
systems that have installed Home Assistant.

[![Home Assistant - A project from the Open Home Foundation](https://www.openhomefoundation.org/badges/home-assistant.png)](https://www.openhomefoundation.org/)

## Apps provided by this repository

- **[CEC Scanner](/cec_scan/README.md)**

    Scan & discover HDMI CEC devices and their addresses.

- **[deCONZ](/deconz/README.md)**

    Control a Zigbee network using ConBee or RaspBee hardware by dresden elektronik.

- **[Dnsmasq](/dnsmasq/README.md)**

    A simple DNS server.

- **[Duck DNS](/duckdns/README.md)**

    Automatically update your Duck DNS IP address with integrated HTTPS support via Let's Encrypt.

- **[File editor](/configurator/README.md)**

    Simple browser-based file editor for Home Assistant.

- **[Git pull](/git_pull/README.md)**

    Load and update configuration files for Home Assistant from a Git repository.

- **[Let's Encrypt](/letsencrypt/README.md)**

    Manage and create certificates from Let's Encrypt.

- **[MariaDB](/mariadb/README.md)**

    MariaDB database for Home Assistant.

- **[Mosquitto broker](/mosquitto/README.md)**

    An Open Source MQTT broker.

- **[NGINX Home Assistant SSL proxy](/nginx_proxy/README.md)**

    Sets up an SSL proxy with NGINX and redirects traffic from port 80 to 443.

- **[RPC Shutdown](/rpc_shutdown/README.md)**

    Shutdown Windows machines remotely.

- **[Samba share](/samba/README.md)**

    Share your configuration over the network using Windows file sharing.

- **[SSH server](/ssh/README.md)**

    Allow logging in remotely to Home Assistant using SSH or just the web terminal with Ingress.

- **[Z-Wave JS](/zwave_js/README.md)**

    Allow Home Assistant to talk to a Z-Wave Network via a USB Controller.

## Support

Got questions?

You have several options to get them answered:

- The [Home Assistant Discord Chat Server][discord].
- The Home Assistant [Community Forum][forum].
- Join the [Reddit subreddit][reddit] in [/r/homeassistant][reddit].

In case you've found a bug, please open an issue in the app's own repository.
The [new issue page][issue] links to the repository of each app.

## Developing your own apps

In case you are interested in developing your own app, this
repository can be a great source of inspiration. For more information
about developing an app, please see our
[documentation for developers][dev-docs].

[discord]: https://www.home-assistant.io/join-chat
[forum]: https://community.home-assistant.io
[issue]: https://github.com/home-assistant/apps/issues/new/choose
[reddit]: https://reddit.com/r/homeassistant
[dev-docs]: https://contributors.home-assistant.io/apps/
