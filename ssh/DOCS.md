# Home Assistant App: Terminal & SSH

## Installation

Follow these steps to get the app installed on your system:

1. In Home Assistant, go to **Settings** > **Apps** > **Install app**.
2. Select **Terminal & SSH**.
3. Select **Install**.

## How to use

This app adds two main features to your Home Assistant installation:

- a web terminal that you can use from your browser, and
- enable connecting to your system using an SSH client.

Regardless of how you connect (using the web terminal or using an SSH client), you end up in this app's container. The Home Assistant configuration
directory is located on the path `/config`.

This app comes bundled with [The Home Assistant CLI](https://www.home-assistant.io/common-tasks/os#home-assistant-via-the-command-line). Try it out using:

```bash
ha help
```

### The Web Terminal

You can access the web terminal by clicking the "Open Web UI" button on this app's Info tab. If you set the "Show in sidebar" setting (found on the same Info tab) to "on", a shortcut is added to the sidebar allowing you to access the web terminal quickly.

To copy text from the Web UI:

1. Hold down the SHIFT key.
2. Select the text you want to copy using your mouse.
3. On releasing the left mouse button, the text gets copied to your system clipboard.

To paste text into the Web UI:

1. Press SHIFT + INSERT.

The web terminal has screen reader support turned on. Screen readers read the text you type and new output as it appears. The visible rows of the terminal are also available as a list that you can read line by line with your screen reader's reading cursor. When a command prints a lot of output, the terminal stops reading it out after about 20 lines; use the reading cursor to read the rest.

### SSH Server Connection

Remote SSH access from the network is disabled by default (See Network below). To connect using an SSH client, such as PuTTY or Linux terminal, you need to supply additional configuration for this app. To enable SSH connectivity, you need to:

- Provide authentication credentials - a password or SSH key(s)
- Specify which TCP port to bind to, on the Home Assistant host

You can then connect to the port specified, using the username `root`. Please note that enabling the SSH Server potentially makes your Home Assistant system less secure, as it might enable anyone on the internet to try to access your system. The security of your system also depends on your network set up, router settings, use of firewalls, etc. As a general recommendation, you should not activate this part of the app unless you understand the ramifications.

If you enable connecting to the SSH Server using an SSH client, you are strongly recommended to use private/public keys to log in. As long as you keep the private part of your key safe, this makes your system much harder to break into. Using passwords is, therefore, generally considered a less secure mechanism. To generate private/public SSH keys, follow the [instructions for Windows][keygen-windows] and [these for other platforms][keygen].

**Note**: While following the instructions above, select ECDSA as `Type of key to generate` instead of RSA. RSA is no longer supported.

Enabling login via password will disable key-based login. You can not run both variants at the same time.

## Configuration

App configuration:

```yaml
authorized_keys:
  - "ssh-rsa AKDJD3839...== my-key"
password: ""
apks: []
server:
  tcp_forwarding: false
```

### Option: `apks`

Additional software packages to install in the app container.

### Option: `authorized_keys`

Your **public keys** that you wish to accept for login. You can authorize multiple keys by adding multiple public keys to the list.

If you get errors when adding your key, it is likely that the public key you're trying to add, contains characters that intervene with YAML syntax. Try enclosing your key in double quotes to avoid this issue.

### Option: `password`

Set a password for login. **We do NOT recommend this variant**.

### Option group `server`

Some SSH server options.

#### Option `tcp_forwarding`

Specifies whether TCP port forwarding (-L -R etc.) is permitted or not.

**Note**: _Enabling this option lowers the security of your SSH server! Nevertheless, this warning is debatable._

## Network

This section is only relevant if you want to connect to Home Assistant using an SSH client, such as PuTTY or Linux terminal. To enable SSH remote access from the Network, specify the desired SSH TCP server port in the Network configuration input box. The number you enter will be used to map that port from the host into the running **Terminal & SSH** app. The standard port used for the SSH protocol is `22`.

Remote SSH access can be disabled again, by clearing the input box, saving the configuration and restarting the app.

## Known issues and limitations

- This app will not enable you to install packages or do anything as root.
  This is not working with Home Assistant.

## Support

Got questions?

You have several options to get them answered:

- The [Home Assistant Discord Chat Server][discord].
- The Home Assistant [Community Forum][forum].
- Join the [Reddit subreddit][reddit] in [/r/homeassistant][reddit]

In case you've found a bug, please [open an issue on our GitHub][issue].

[discord]: https://www.home-assistant.io/join-chat
[forum]: https://community.home-assistant.io
[issue]: https://github.com/home-assistant/app-ssh/issues
[keygen-windows]: https://www.digitalocean.com/community/tutorials/how-to-create-ssh-keys-with-putty-to-connect-to-a-vps
[keygen]: https://docs.github.com/en/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent
[reddit]: https://reddit.com/r/homeassistant
