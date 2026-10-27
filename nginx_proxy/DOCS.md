# Home Assistant App: NGINX Home Assistant SSL proxy

## Installation

Follow these steps to get the app installed on your system:

1. In Home Assistant, go to **Settings** > **Apps** > **Install app**.
2. Find the "NGINX Home Assistant SSL proxy" app and click it.
3. Click on the "INSTALL" button.

## How to use

The NGINX Proxy app is commonly used in conjunction with the [Duck DNS](https://github.com/home-assistant/addons/tree/master/duckdns) and/or the [Let's Encrypt](https://github.com/home-assistant/addons/tree/master/letsencrypt) app to set up secure remote access to your Home Assistant instance. The following instructions covers this scenario.

1. The certificate to your registered domain should already be created via [Duck DNS](https://github.com/home-assistant/addons/tree/master/duckdns), [Let's Encrypt](https://github.com/home-assistant/addons/tree/master/letsencrypt) or another method. Make sure that the certificate files exist in the `/ssl` directory.
2. You must add the following section to your [Home Assistant configuration.yaml](https://www.home-assistant.io/docs/configuration/). If the `http` section is using the `ssl_certificate` or `ssl_key` keys, enable the `use_ssl_backend` option.

   ```yaml
   http:
     use_x_forwarded_for: true
     trusted_proxies:
       - 172.30.33.0/24
   ```
3. In the nginx app configuration, change the `domain` option to the domain name you registered (from DuckDNS or any other domain you control).
4. Leave all other options as-is.
5. Save configuration.
6. Start the app.
7. Have some patience and wait a couple of minutes.
8. Check the app log output to see the result.


## Configuration

App configuration:

```yaml
domain: home.example.com
certfile: fullchain.pem
keyfile: privkey.pem
hsts: "max-age=31536000; includeSubDomains"
customize:
  active: false
  default: "nginx_proxy_default*.conf"
  servers: "nginx_proxy/*.conf"
cloudflare: false
real_ip_from: []
```

### Option: `domain` (required)

The server's fully qualified domain name to use for the proxy.

### Option: `certfile` (required)

The certificate file to use in the `/ssl` directory. Keep filename as-is if you used default settings to create the certificate with the [Duck DNS](https://github.com/home-assistant/addons/tree/master/duckdns) app.

### Option: `keyfile` (required)

Private key file to use in the `/ssl` directory.

### Option: `hsts` (required)

Value for the [`Strict-Transport-Security`][hsts] HTTP header to send. If empty, the header is not sent.

### Option `customize.active` (required)

If true, additional NGINX configuration files for the default server and additional servers are read from files in the `/share` directory specified by the `default`, `servers`, and `root_conf` variables.

### Option `customize.default` (required)

The filename of the NGINX configuration for the default server, found in the `/share` directory.

### Option `customize.servers` (required)

The filename(s) of the NGINX configuration for the additional servers, found in the `/share` directory.

### Option `customize.root_conf` (required)

The filename of the NGINX configuration for additional parameters to place in the root level of the configuration file, found in the `/share` directory.

### Option `cloudflare` (optional)

If enabled, configure Nginx with a list of IP addresses directly from Cloudflare that will be used for `set_real_ip_from` directive Nginx config.
This is so the `ip_ban_enabled` feature can be used and work correctly in /config/customize.yaml.

### Option `use_ssl_backend` (optional)

Enable this option to configure Nginx to connect with SSL to the backend when your `http` section uses the `ssl_certificate` or `ssl_key` options.

### Option `real_ip_from` (optional)

If specified, configures Nginx to use Proxy Protocol to get the Real Ip from an upstream load balancer; [for more information](https://docs.nginx.com/nginx/admin-guide/load-balancer/using-proxy-protocol/).

### Port `HTTP/3 (QUIC)` (optional)

If specified, configures Nginx to use HTTP/3 with QUIC/UDP on this UDP port in addition to HTTP/2 and HTTP/1.1 on the TCP port; [for more information](https://nginx.org/en/docs/http/ngx_http_v3_module.html).

## Known issues and limitations

- By default, port 80 is disabled in the app configuration in case the port is needed for other components or apps like `emulated_hue`.
- With HTTP/3 (QUIC), Nginx cannot forward the port of the address used by the client to Home Assistant (the `Host` and `X-Forwarded-Host` headers contain the hostname without port). If Home Assistant is reachable on a non-default port (anything other than 443), this breaks features which validate the request host and port against the configured external URL, such as the OAuth2 discovery endpoints used by MCP clients. Regular browser and app logins are not affected. To avoid this, use the default port 443 or disable HTTP/3.

## Troubleshooting

- `400 Bad Request` response for requests over this proxy mean you are probably missing the `trusted_proxies` configuration option, see above.
- HTTP/3 (QUIC) enabled, but not working. Check for the `Alt-Svc 'h3=":443"; ma=86400'` header in your web browser's development tools. Make sure the UDP QUIC port is forwarded or allowed in your firewall, in addition to the TCP HTTPS port.

## Support

Got questions?

You have several options to get them answered:

- The [Home Assistant Discord Chat Server][discord].
- The Home Assistant [Community Forum][forum].
- Join the [Reddit subreddit][reddit] in [/r/homeassistant][reddit]

In case you've found a bug, please [open an issue on our GitHub][issue].

[discord]: https://www.home-assistant.io/join-chat
[forum]: https://community.home-assistant.io
[hsts]: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Strict-Transport-Security
[issue]: https://github.com/home-assistant/addons/issues
[reddit]: https://reddit.com/r/homeassistant
[repository]: https://github.com/hassio-addons/repository
