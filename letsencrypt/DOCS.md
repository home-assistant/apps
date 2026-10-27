# Home Assistant App: Letsencrypt

## Installation

Follow these steps to get the app (formerly known as add-on) installed on your system:

1. In Home Assistant, go to **Settings** > **Apps** > **Install app**.
2. Find the "letsencrypt" app and click it.
3. Click on the "INSTALL" button.

## How to use

The Letsencrypt app can be configured via the app interface.
The configuration via YAML is also possible, see the examples below.

Navigate in your Home Assistant frontend to the apps overview page at
**Settings** > **Apps**, and pick the **Let's Encrypt** app. On the top,
pick the **Configuration** page.

Provide the domain names to issue certificates for. Additionally, provide the
e-mail address used for the registration, and path values for **Priv Key File**
and **Certificate File**.

There are two options to obtain certificates.

### 1. HTTP challenge

- Requires Port 80 to be available from the internet and your domain assigned to the externally assigned IP address
- Doesn’t allow wildcard certificates (*.domain.tld).

### 2. DNS challenge

- Requires you to use one of the supported DNS providers (See "Supported DNS providers" below)
- Allows to request wildcard certificates (*.domain.tld)
- Doesn’t need you to open a port to your Home Assistant host on your router.

### DNS providers

<!-- Developer note: please add a new plugin alphabetically into all lists -->

<details>
  <summary>Supported DNS providers</summary>

```txt
dns-lego (generic, supports any lego DNS provider)
dns-azure
dns-bunny
dns-cloudflare
dns-cloudns
dns-desec
dns-digitalocean
dns-directadmin
dns-dnsimple
dns-dnsmadeeasy
dns-dnsservices
dns-domainoffensive
dns-dreamhost
dns-duckdns
dns-dynu
dns-easydns
dns-eurodns
dns-gandi
dns-gehirn
dns-godaddy
dns-google
dns-he
dns-hetzner
dns-httpreq
dns-infomaniak
dns-inwx
dns-ionos
dns-joker
dns-linode
dns-loopia
dns-luadns
dns-mijn-host
dns-namecheap
dns-netcup
dns-njalla
dns-noris
dns-nsone
dns-ovh
dns-plesk
dns-porkbun
dns-rfc2136
dns-route53
dns-sakuracloud
dns-simply
dns-transip
dns-websupport
```

</details>

<details>
  <summary>In addition add the fields according to the credentials required by your DNS provider:</summary>

```yaml
propagation_seconds: 60
lego_env: []
lego_provider: ''
aws_access_key_id: ''
aws_region: ''
aws_secret_access_key: ''
azure_config: ''
bunny_api_key: ''
cloudflare_api_key: ''
cloudflare_api_token: ''
cloudflare_email: ''
cloudns_auth_id: ''
cloudns_auth_password: ''
cloudns_sub_auth_id: ''
desec_token: ''
digitalocean_token: ''
directadmin_password: ''
directadmin_url: ''
directadmin_username: ''
dns_multi_nameservers: ''
dnsimple_token: ''
dnsmadeeasy_api_key: ''
dnsmadeeasy_secret_key: ''
dnsservices_password: ''
dnsservices_username: ''
domainoffensive_token: ''
dreamhost_api_key: ''
duckdns_token: ''
dynu_auth_token: ''
easydns_endpoint: ''
easydns_key: ''
easydns_token: ''
eurodns_apiKey: ''
eurodns_applicationId: ''
gandi_api_key: ''
gandi_token: ''
gehirn_api_secret: ''
gehirn_api_token: ''
godaddy_key: ''
godaddy_secret: ''
google_creds: ''
he_pass: ''
he_user: ''
hetzner_api_token: ''
httpreq_endpoint: ''
httpreq_password: ''
httpreq_username: ''
infomaniak_api_token: ''
inwx_password: ''
inwx_shared_secret: ''
inwx_username: ''
ionos_prefix: ''
ionos_secret: ''
joker_password: ''
joker_username: ''
linode_key: ''
linode_version: ''
loopia_password: ''
loopia_user: ''
luadns_email: ''
luadns_token: ''
mijn_host_api_key: ''
namecheap_api_key: ''
namecheap_username: ''
netcup_api_key: ''
netcup_api_password: ''
netcup_customer_id: ''
njalla_token: ''
noris_token: ''
nsone_api_key: ''
ovh_application_key: ''
ovh_application_secret: ''
ovh_consumer_key: ''
ovh_endpoint: ''
plesk_api_url: ''
plesk_password: ''
plesk_username: ''
porkbun_key: ''
porkbun_secret: ''
rfc2136_algorithm: ''
rfc2136_name: ''
rfc2136_port: ''
rfc2136_secret: ''
rfc2136_server: ''
rfc2136_sign_query: false
sakuracloud_api_secret: ''
sakuracloud_api_token: ''
simply_account_name: ''
simply_api_key: ''
transip_api_key: ''
transip_username: ''
websupport_identifier: ''
websupport_secret_key: ''
```

</details>

### Split DNS and custom nameservers

If cert renewal fails with an error like `failed to find zone <domain>: zone could not be found`,
your local DNS is returning a different SOA than your DNS provider manages. This occurs
in split DNS setups where a local DNS server handles a zone that is also hosted publicly, or where
the local resolver returns a different SOA response than the public authoritative server.

Set `dns_multi_nameservers` to a comma-separated list of public DNS servers to use for zone
determination and CNAME resolution. Port is optional and defaults to 53.

```yaml
dns_multi_nameservers: '1.1.1.1,8.8.8.8'
```

### Configure certificate files

The certificate files will be available within the "ssl" share after successful
request of the certificates.

By default, other apps are referring to the correct path of the certificates.
You can in addition find the files via the **Samba** app within the "ssl" share.

For example, to use the certificates provided by this app to enable TLS on
Home Assistant in the default paths, add the following lines to Home
Assistant's main configuration file, `configuration.yaml`:

```yaml
# TLS with letsencrypt app
http:
  server_port: 443
  ssl_certificate: /ssl/fullchain.pem
  ssl_key: /ssl/privkey.pem
```

### Create & renew certificates

The letsencrypt app creates the certificates once it is started: navigate
to **Settings** > **Apps**, pick the **Let's Encrypt** app, click the
**START** button on the bottom. The app stops once the certificates are
created.

Certificates are not renewed automatically by the plugin. The app has to be
started again to renew certificates. If the app is started again, it checks
if the certificates are due for renewal. This is usually the case 30 days
before the certificates' due date. If the certificates are not due for renewal,
the app terminates without changes. If the certificates are due for renewal,
new certificates will be created.

There are multiple ways how the app can be started to check/renew the
certificates. One way to automate the certificate renewal is to configure a
[Home Assistant automation][haauto] to restart this app every night via the [Supervisor app restart action][supervisorrestart].

[haauto]: https://www.home-assistant.io/docs/automation/editor/
[supervisorrestart]: https://www.home-assistant.io/integrations/hassio/#action-hassioaddon_restart

To force a certificate renewal regardless of the expiry date, set the `force_renew` option to `true`:

```yaml
force_renew: true
```

> **Note:** Remember to set `force_renew` back to `false` (or remove it) after the renewal, otherwise every run will force a new certificate to be issued.

## Advanced

<details>
  <summary>Changing the ACME Server</summary>

By default, the app uses [Let’s Encrypt’s default servers](https://letsencrypt.org/getting-started/). You can instruct the app to use a different ACME server by providing the field `acme_server` with the URL of the server’s ACME directory:

  ```yaml
  acme_server: 'https://my.custom-acme-server.com'
  ```

If your custom ACME server uses a certificate signed by an untrusted certificate authority (CA), you can add the root certificate to the trust store by setting its content as an option:

  ```yaml
  acme_server: 'https://my.custom-acme-server.com'
  acme_root_ca_cert: |
    -----BEGIN CERTIFICATE-----
    MccBfTCCASugAwIBAgIRAPPIPTKNBXkBozsoE46UPZcwCGYIKoZIzj0EAwIwHTEb...kg==
    -----END CERTIFICATE-----
  ```

When you specify a custom ACME server, the *Dry Run* and *Issue test certificates* options, which are intended for use with the [Let's Encrypt staging server](https://letsencrypt.org/docs/staging-environment/), are automatically disregarded.

</details>

<details>
  <summary>Selecting the Key Type</summary>

  By default the ECDSA key type is used. You can choose to use an RSA key for compatibility with systems where ECDSA keys are not supported. ECDSA is widely supported in modern software with security and performance benefits.

  ```yaml
  key_type: 'rsa'
  ```

  When the `key_type` parameter is not set, the app will attempt to auto-detect an existing certificate's key type or use `ecdsa` by default.

</details>

<details>
  <summary>Selecting the ECDSA Elliptic Curve</summary>

  You can choose from the following ECDSA elliptic curves: `secp256r1`, `secp384r1`

  ```yaml
  key_type: 'ecdsa'
  elliptic_curve: 'secp384r1'
  ```

  When the `elliptic_curve` parameter is not set, ECDSA keys will be generated using the Certbot default. This option must be used with `key_type` set to `'ecdsa'`.

</details>

<details>
  <summary>Set up external account binding</summary>

   The ACME protocol (RFC 8555) defines an external account binding (EAB) field that ACME clients can use to access a specific account on the certificate authority (CA). Some CAs may require the client to utilize the EAB protocol to operate. You can add your EAB key ID and HMAC key through the config options `eab_kid` and `eab_hmac_key`.

  ```yaml
  eab_kid: 'key_id'
  eab_hmac_key: 'AABBCCDD' #Base64url encoded key
  ```

</details>

## Example Configurations

**Important Note for UI Edit Mode:** These configuration examples are raw YAML configs.
When using the UI edit mode (which is the default), and configuring DNS, you **must**
only copy the attributes *underneath* the `dns:` key into the "DNS Provider configuration" field.
Do NOT include the `dns:` key itself when pasting into the UI field, as this will cause parsing errors.

<details>
  <summary>HTTP challenge</summary>

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: http
  dns: {}
  ```

</details>

<details>
  <summary>DNS challenge</summary>

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-cloudflare
    cloudflare_email: your.email@example.com
    cloudflare_api_key: 31242lk3j4ljlfdwsjf0
  ```

</details>

<details>
  <summary>DNS challenge using generic lego provider</summary>

The `dns-lego` provider lets you use **any** DNS provider supported by the
[lego ACME library](https://go-acme.github.io/lego/dns/) - even those not
listed as named providers in this documentation. You specify the lego provider
name and its required environment variables directly.

To find the provider name and required environment variables for your DNS
provider, visit the
[lego DNS providers documentation](https://go-acme.github.io/lego/dns/).

Example using [acme-dns](https://go-acme.github.io/lego/dns/acme-dns/):

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-lego
    lego_provider: acme-dns
    lego_env:
      - "ACME_DNS_API_BASE=http://10.0.0.8:4443"
      - "ACME_DNS_STORAGE_PATH=/share/acme-dns-accounts.json"
    propagation_seconds: 120
  ```

Example using [Hetzner](https://go-acme.github.io/lego/dns/hetzner/) (equivalent to using `dns-hetzner`):

  ```yaml
  dns:
    provider: dns-lego
    lego_provider: hetzner
    lego_env:
      - "HETZNER_API_TOKEN=your-api-token"
  ```

**Notes:**

- Each `lego_env` entry must be in `KEY=VALUE` format. Values containing `=` signs are supported (e.g., `KEY=val=ue`).
- For providers that require credential files, place the file in the `/share/` folder and reference it as `/share/filename` in the environment variable.
- The `propagation_seconds` setting generates a timeout variable based on the uppercased provider name (e.g., `HETZNER_PROPAGATION_TIMEOUT`). If your provider uses a different variable prefix, you can include the correct timeout variable directly in `lego_env` and omit `propagation_seconds`.

</details>

<details>
  <summary>RSA key</summary>

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  key_type: rsa
  challenge: dns
  dns:
    provider: dns-cloudflare
    cloudflare_email: your.email@example.com
    cloudflare_api_key: 31242lk3j4ljlfdwsjf0
  ```

</details>

<details>
  <summary>Azure</summary>

```yaml
email: your.email@example.com
domains:
  - your.domain.tld
certfile: fullchain.pem
keyfile: privkey.pem
challenge: dns
dns:
  provider: dns-azure
  azure_config: azure.txt
```

Please copy your credentials file "azure.txt" into the "share" shared folder
on the Home Assistant host before starting the service. One way is to use the
**Samba** app to make the folder available via network or SSH App. You
can find information on the required file format in the [documentation][certbot-dns-azure-conf]
for the Certbot Azure plugin.

To use this plugin, [create an Azure Active Directory app registration][aad-appreg]
and service principal; add a client secret; and create a credentials file
using the above directions. Grant the app registration DNS Zone Contributor
on the DNS zone to be used for authentication.

[aad-appreg]: https://docs.microsoft.com/en-us/azure/active-directory/develop/howto-create-service-principal-portal#register-an-application-with-azure-ad-and-create-a-service-principal
[certbot-dns-azure-conf]: https://certbot-dns-azure.readthedocs.io/en/latest/#configuration

</details>

<details>
  <summary>Bunny</summary>

Use of this plugin requires an API token, obtained from the [Bunny dashboard](https://dash.bunny.net/account/api-key)

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-bunny
    bunny_api_key: your-bunny-api-key
  ```

</details>


<details>
  <summary>Cloudflare</summary>

To use this plugin a Cloudflare API Token, restricted to the specific domain and operations are the recommended authentication option.
The API Token used for Certbot requires only the `Zone:DNS:Edit` permission for the zone in which you want a certificate.

Example credentials file using restricted API Token (recommended):

  ```yaml
  dns:
    provider: dns-cloudflare
    cloudflare_api_token: 0123456789abcdef0123456789abcdef01234
  ```

Previously, Cloudflare’s “Global API Key” was used for authentication. However this key can access the entire Cloudflare API for all domains in your account, meaning it could cause a lot of damage if leaked.

Example credentials file using Global API Key (NOT RECOMMENDED):

  ```yaml
  dns:
    provider: dns-cloudflare
    cloudflare_email: cloudflare@example.com
    cloudflare_api_key: 0123456789abcdef0123456789abcdef01234
  ```

</details>

<details>
  <summary>ClouDNS</summary>

In order to use a domain with this challenge, you first need to log into your control panel and
create a new HTTP API user from the `API & Resellers` page on top of your control panel.

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-cloudns
    cloudns_auth_id: 12345
    cloudns_auth_password: ******
  ```

API Users have full account access.  It is recommended to create an API Sub-user, which can be limited in scope, use `sub-auth-id` as follows:

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-cloudns
    cloudns_sub_auth_id: 12345
    cloudns_auth_password: ******
  ```

</details>

<details>
  <summary>deSEC.io</summary>

  You need a deSEC API token with sufficient permission for performing the required DNS changes on your domain.
  If you don't have a token yet, an easy way to obtain one is by logging into your account at deSEC.io.
  Navigate to "Token Management" and create a new one.
  It's good practice to restrict the token permissions as much as possible, e.g. by setting the maximum unused period to four months.
  This way, the token will expire if it is not continuously used to renew your certificate.

  ```yaml
  email: your.email@example.com
  domains:
   - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-desec
    desec_token: your-desec-access-token
  ```

</details>

<details>
  <summary>DigitalOcean</summary>

Use of this plugin requires a configuration file containing DigitalOcean API credentials, obtained from your DigitalOcean account’s [Applications & API Tokens page](https://cloud.digitalocean.com/settings/api/tokens).

```yaml
  email: mail@domain.tld
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-digitalocean
    digitalocean_token: digitalocean-token
```

[Full Documentation](https://certbot-dns-digitalocean.readthedocs.io/en/stable/)

</details>

<details>
  <summary>DirectAdmin</summary>

It is recommended to create a login key in the DirectAdmin control panel to be used as value for directadmin_password.
Instructions on how to create such key can be found at <https://help.directadmin.com/item.php?id=523>.

Make sure to grant the following permissions:

- `CMD_API_LOGIN_TEST`
- `CMD_API_DNS_CONTROL`
- `CMD_API_SHOW_DOMAINS`
- `CMD_API_DOMAIN_POINTER`

Username and password can also be used in case your DirectAdmin instance has no support for login keys.

Example configuration:

  ```yaml
  email: mail@domain.tld
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    propagation_seconds: 60
    provider: dns-directadmin
    directadmin_url: 'https://domain.tld:2222/'
    directadmin_username: da_user
    directadmin_password: da_password_or_key
  ```

</details>

<details>
  <summary>dnsimple</summary>

Use of this plugin requires a configuration file containing DNSimple API credentials, obtained from your DNSimple [account page](https://dnsimple.com/user).

```yaml
  email: mail@domain.tld
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-dnsimple
    dnsimple_token: dnssimple-token
```

[Full Documentation](https://certbot-dns-dnsimple.readthedocs.io/en/stable/)

</details>

<details>
  <summary>dnsmadeeasy</summary>

Use of this plugin requires a configuration file containing DNS Made Easy API credentials, obtained from your DNS Made Easy [account page](https://cp.dnsmadeeasy.com/account/info).

```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-dnsmadeeasy
    dnsmadeeasy_api_key: dnsmadeeasy-api-key
    dnsmadeeasy_secret_key: dnsmadeeasy-secret-key
```

[Full Documentation](https://certbot-dns-dnsmadeeasy.readthedocs.io/en/stable/)

</details>

<details>
  <summary>dnsmadeeasy</summary>

Use of this plugin requires a configuration file containing DNS.Services credentials, obtained from your DNS.services [account page](https://dns.services/clientarea/domains/).

```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-dnsservices
    dnsservices_password: dnsservices-password
    dnsservices_username: dnsservices-username
```

[Full Documentation](https://go-acme.github.io/lego/dns/dnsservices/)
[Documentation in danish](https://dns.services/knowledgebase/article/38/acme-sh-acme-protokol-support-til-certifikatudstedelse/)

</details>
<details>
  <summary>domainoffensive</summary>

Use of this plugin requires an API token, obtained from domainoffensive account page in the menu under   **Domains** > **Settings** > **Let's Encrypt API token**.

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-domainoffensive
    domainoffensive_token: domainoffensive-token
  ```

[Full Documentation DE](https://www.do.de/wiki/freie-ssl-tls-zertifikate-ueber-acme/)

</details>

<details>
  <summary>DreamHost</summary>

Use of this plugin an API key from DreamHost with `dns-*` permissions. You can get it [here](https://panel.dreamhost.com/?tree=home.api)

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-dreamhost
    dreamhost_api_key: dreamhost-api-key
  ```

`dreamhost_baseurl` is no longer supported since v6.0.0 and defaults to `https://api.dreamhost.com/`

</details>

<details>
  <summary>DuckDNS</summary>

Use of this plugin requires an API token, obtained from the DuckDNS account page.

```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-duckdns
    duckdns_token: duckdns-token

```

[Full documentation](https://github.com/infinityofspace/certbot_dns_duckdns?tab=readme-ov-file#usage)

</details>

<details>
  <summary>Dynu</summary>

You can get the API key in the API Credentials area of the Dynu control panel: <https://www.dynu.com/ControlPanel/APICredentials>

```yaml
email: your.email@example.com
domains:
  - your.domain.tld
certfile: fullchain.pem
keyfile: privkey.pem
challenge: dns
dns:
  provider: dns-dynu
  dynu_auth_token: 0123456789abcdef
```

</details>

<details>
  <summary>easyDNS</summary>

easyDNS REST API access must be requested and granted in order to use this module: <https://cp.easydns.com/manage/security/api/signup.php> after logging into your account.

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-easydns
    easydns_token: 0123456789abcdef
    easydns_key: ****
    easydns_endpoint: https://rest.easydns.net
  ```

</details>

<details>
  <summary>EuroDNS</summary>

  You can configure the APP id and the API key in the API Users area of the Eurodns control panel: <https://my.eurodns.com/apiusers>

```yaml
domains:
  - your.domain.tld
certfile: fullchain.pem
keyfile: privkey.pem
challenge: dns
dns:
  provider: dns-eurodns
  eurodns_applicationId: X-APP-ID
  eurodns_apiKey: X-API-KEY
  propagation_seconds: 60
```

</details>

<details>
  <summary>Gandi</summary>

Use of this plugin requires an [PersonalAccessToken](https://helpdesk.gandi.net/hc/en-us/articles/14051397687324-Personal-Access-Tokens) for the [Gandi LiveDNS API](https://api.gandi.net/docs/livedns/) with `Domains` scope for the `domain.tld` you are going to request a certificate for.
If you only have an Gandi LiveDNS `API key`, please refer to the [FAQ](https://github.com/obynio/certbot-plugin-gandi?tab=readme-ov-file#faq) on how to use this.
Due to the wide scope of this `API key`, this is not the recommended setup.

```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-gandi
    gandi_token: gandi-personalaccesstoken
```

[Full Documentation](https://github.com/obynio/certbot-plugin-gandi?tab=readme-ov-file)

</details>

<details>
  <summary>gehirn</summary>

Use of this plugin requires Gehirn Infrastructure Service DNS API credentials, obtained from your Gehirn Infrastructure Service [dashboard](https://gis.gehirn.jp/).

```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-gehirn
    gehirn_api_secret: gehirn-api-secret
    gehirn_api_token:  gehirn-api-token
```

[Full Documentation](https://certbot-dns-gehirn.readthedocs.io/en/stable/)

</details>

<details>
  <summary>GoDaddy</summary>

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-godaddy
    godaddy_secret: YOUR_GODADDY_SECRET
    godaddy_key: YOUR_GODADDY_KEY
  ```

To obtain the ACME DNS API Key and Secret, follow the instructions here:
<https://developer.godaddy.com/getstarted>

**IMPORTANT**: GoDaddy limits DNS API access to customers with 10 or more domains and/or an active "Discount Domain Club – Premier Membership" plan; the API will respond with a HTTP401 otherwise. See the [Terms of Use](https://developer.godaddy.com/getstarted) for more information.

</details>

<details>
  <summary>Google Cloud</summary>

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-google
    google_creds: google.json
  ```

Please copy your credentials file "google.json" into the "share" shared folder on the Home Assistant host before starting the service.

One way is to use the **Samba** app to make the folder available via network or SSH App.

The credential file can be created and downloaded when creating the service user within the Google cloud.
You can find additional information regarding the required permissions in the "credentials" section here:

<https://github.com/certbot/certbot/blob/master/certbot-dns-google/certbot_dns_google/__init__.py>

</details>

<details>
  <summary>Hurricane Electric (HE)</summary>

Use of this plugin requires your Hurricane Electric username and password.
You will need to create the dynamic TXT record from within the dns.he.net interface before you will be able to make updates. You will not be able to dynamically create and delete these TXT records as doing so would subsequently remove your ddns key associated with the record.

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    propagation_seconds: 310
    provider: dns-he
    he_user: me
    he_pass: ******
  ```

[Full Documentation](https://dns.he.net/)

</details>

<details>
  <summary>Hetzner</summary>

Use of this plugin requires a Hetzner Cloud API token. See the Hetzner Docs on [Generating an API token](https://docs.hetzner.com/cloud/api/getting-started/generating-api-token/).

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-hetzner
    hetzner_api_token: hetzner-api-token
  ```

[Full Documentation](https://github.com/ctrlaltcoop/certbot-dns-hetzner)

</details>

<details>
  <summary>HTTP request</summary>

The `dns-httpreq` provider uses lego's [HTTP request provider](https://go-acme.github.io/lego/dns/httpreq/).
Your HTTP service must accept `POST` requests on `/present` and `/cleanup`.

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-httpreq
    httpreq_endpoint: http://my.server.com:9090
    httpreq_username: your-username
    httpreq_password: your-password
  ```

The `httpreq_username` and `httpreq_password` values are optional, but they must either both be set or both be omitted.

</details>

<details>
  <summary>Infomaniak</summary>

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-infomaniak
    infomaniak_api_token: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
  ```

To obtain the DNS API token follow the instructions here:

<https://manager.infomaniak.com/v3/infomaniak-api>

Choose "Domain" as the scope.

</details>

<details>
  <summary>INWX</summary>

Use the user for the dyndns service, not the normal user.
The shared secret is the 2FA code, it must be the same length as the example.
To get this code, you must activate the 2FA or deactivate and reactivate 2FA.
Without 2FA leave the example key.

Example configuration:

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-inwx
    inwx_username: user
    inwx_password: password
    inwx_shared_secret: ABCDEFGHIJKLMNOPQRSTUVWXYZ012345
  ```

</details>

<details>
  <summary>IONOS</summary>

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-ionos
    ionos_prefix: YOUR_IONOS_API_KEY_PREFIX
    ionos_secret: YOUR_IONOS_API_KEY_SECRET
  ```

To obtain the DNS API Key Information, follow the instructions here:
<https://developer.hosting.ionos.com/>

</details>

<details>
  <summary>Joker</summary>

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-joker
    joker_username: username
    joker_password: password
  ```

You can find further detailed information here:

<https://joker.com/faq/books/jokercom-faq-en/page/lets-encrypt-ssl-certificates>
<https://github.com/dhull/certbot-dns-joker/blob/master/README.md>

</details>

<details>
  <summary>Linode</summary>

To use this app with Linode DNS, first [create a new API/access key](https://www.linode.com/docs/platform/api/getting-started-with-the-linode-api#get-an-access-token), with read/write permissions to DNS; no other permissions are needed.

  ```yaml
  email: you@mailprovider.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-linode
    linode_key: 865c9f462c7d54abc1ad2dbf79c938bc5c55575fdaa097ead2178ee68365ab3e
  ```

</details>

<details>
  <summary>Loopia</summary>

To use this app with Loopia DNS, first [create a new API user](https://customerzone.loopia.com/api/), with the following minimum required permissions:

- `addZoneRecord` - Required to create DNS records
- `getZoneRecords` - Required to verify DNS records
- `removeZoneRecord` - Required to clean up DNS records
- `removeSubdomain` - Required for complete cleanup

Example configuration in YAML edit mode:

```yaml
email: you@mailprovider.com
domains:
  - your.domain.tld
certfile: fullchain.pem
keyfile: privkey.pem
challenge: dns
dns:
  provider: dns-loopia
  loopia_user: example@loopiaapi
  loopia_password: supersecretpasswordhere
```

</details>

<details>
  <summary>LuaDNS</summary>

Use of this plugin requires LuaDNS API credentials, obtained from your [account settings page](https://api.luadns.com/settings).

```yaml
email: your.email@example.com
domains:
  - your.domain.tld
certfile: fullchain.pem
keyfile: privkey.pem
challenge: dns
dns:
  provider: dns-luadns
  luadns_email: your.email@example.com
  luadns_token: luadns-token
```

[Full Documentation](https://certbot-dns-luadns.readthedocs.io/en/stable/)

</details>

<details>
  <summary>mijn.host</summary>

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-mijn-host
    mijn_host_api_key: XXXXXX
    propagation_seconds: 60
  ```

The `mijn_host_api_key` is the account's API key.
The API key assigned to your mijn.host account can be found in your mijn.host Control panel.

</details>

<details>
  <summary>Namecheap</summary>

To use this app with Namecheap, you must first enable API access on your account. See "Enabling API Access" and "Whitelisting IP" [here](https://www.namecheap.com/support/api/intro/) for details and requirements.

Example configuration:

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-namecheap
    namecheap_username: your-namecheap-username
    namecheap_api_key: 0123456789abcdef0123456789abcdef01234567
  ```

</details>

<details>
  <summary>Netcup</summary>

Both the API password and key can be obtained via the following page: <https://www.customercontrolpanel.de/daten_aendern.php?sprung=api>
It is important to set the `propagation_seconds` to >= 630 seconds due to the slow DNS update of Netcup.

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-netcup
    netcup_customer_id: "userid"
    netcup_api_key: ****
    netcup_api_password: ****
    propagation_seconds: "900"
  ```

References:

- <https://helpcenter.netcup.com/de/wiki/general/unsere-api#authentifizierung>
- <https://github.com/coldfix/certbot-dns-netcup/issues/28>

</details>

<details>
  <summary>Njalla</summary>

You need to generate an API token inside Settings > API Access or directly at <https://njal.la/settings/api/>. If you have a static IP-address restrict the access to your IP. I you are not sure, you probably don't have a static IP-address.

Example configuration:

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-njalla
    njalla_token: 0123456789abcdef0123456789abcdef01234567
  ```

</details>

<details>
  <summary>noris network</summary>

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-noris
    noris_token: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    propagation_seconds: 240
  ```

To obtain the `noris_token` follow the instructions as described in our [GitHub repository][GitHub repo].

You can define the `propagation_seconds` explicitly. Otherwise, it will use the default value (currently set to `60` seconds).

[GitHub repo]: <https://github.com/noris-network/certbot-dns-norisnetwork#get-your-api-token>

</details>

<details>
  <summary>nsone</summary>

Use of this plugin requires NS1 API credentials, obtained from your NS1 [account page](https://my.nsone.net/#/account/settings).

```yaml
email: your.email@example.com
domains:
  - your.domain.tld
certfile: fullchain.pem
keyfile: privkey.pem
challenge: dns
dns:
  provider: dns-nsone
  nsone_api_key: nsone-api-key
```

[Full Documentation](https://certbot-dns-nsone.readthedocs.io/en/stable/)

</details>

<details>
  <summary>OVH</summary>

You will need to generate an OVH API Key first at <https://eu.api.ovh.com/createToken/> (for Europe) or <https://ca.api.ovh.com/createToken/> (for North America).
Further documentation is [here](https://certbot-dns-ovh.readthedocs.io/en/stable/).

When creating the API Key, you must ensure that the following rights are granted:

- ``GET /domain/zone/*``
- ``PUT /domain/zone/*``
- ``POST /domain/zone/*``
- ``DELETE /domain/zone/*``

Example configuration

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-ovh
    ovh_endpoint: ovh-eu
    ovh_application_key: 0123456789abcdef0123456789abcdef01234
    ovh_application_secret: 0123456789abcdef0123456789abcdef01234
    ovh_consumer_key: 0123456789abcdef0123456789abcdef01234
  ```

Use `ovh_endpoint: ovh-ca` for North America region.

</details>

<details>
  <summary>Plesk Hosting</summary>

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-plesk
    plesk_username: your-username
    plesk_password: your-password
    plesk_api_url: https://plesk.example.com
    propagation_seconds: 120
  ```

The `plesk_username` and `plesk_password` are the same as those you use on the login page of your admin panel.

The `plesk_api_url` is the base URL of your Plesk admin panel.

You can define the `propagation_seconds` explicitly. Otherwise, it will use a custom default value (currently set to `120` seconds).
If the provided value is less than `120`, then the value is forced to a minimum of `120` seconds.

</details>

<details>
  <summary>Porkbun</summary>

In order to use a domain with this challenge, API access will need enabling on the domain. In order to
do this go to domain management -> select the domain -> details and click the API access toggle.
Then go to the menu in the top right select API access and then create a new api key.
The title does not matter and is not used by certbot, make note of the key and the secret as both are required.

```yaml
email: your.email@example.com
domains:
  - your.domain.tld
certfile: fullchain.pem
keyfile: privkey.pem
challenge: dns
dns:
  provider: dns-porkbun
  porkbun_key: 0123456789abcdef0123456789abcdef01234
  porkbun_secret: 0123456789abcdef0123456789abcdef01234
```

</details>

<details>
  <summary>RFC2136</summary>

You will need to set up a server with RFC2136 (Dynamic Update) support with a TKEY (to authenticate the updates).  How to do this will vary depending on the DNS server software in use.  For Bind9, you first need to first generate an authentication key by running

  ```shell
  $ tsig-keygen -a hmac-sha512 letsencrypt
  key "letsencrypt" {
    algorithm hmac-sha512;
    secret "xxxxxxxxxxxxxxxxxx==";
  };
  ```

You don't need to publish this; just copy the key data into your named.conf file:

  ```shell
  key "letsencrypt" {
    algorithm hmac-sha512;
    secret "xxxxxxxxxxxxxxxxxx==";
  };
  ```

And ensure you have an update policy in place in the zone that uses this key to enable update of the correct domain (which must match the domain in your yaml configuration):

  ```shell
     update-policy {
        grant letsencrypt name _acme-challenge.your.domain.tld. txt;
     };
  ```

For this provider, you will need to supply all the `rfc2136_*` options. Note that the `rfc2136_port` item is required (there is no default port in the app) and, most importantly, the port number must be quoted.  Also, be sure to copy in the key so certbot can authenticate to the DNS server.

An example configuration:

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-rfc2136
    rfc2136_server: dns-server.dom.ain
    rfc2136_port: '53'
    rfc2136_name: letsencrypt
    rfc2136_secret: "secret-key"
    rfc2136_algorithm: hmac-sha512
  ```

</details>

<details>
  <summary>route53</summary>

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-route53
    aws_access_key_id: 0123456789ABCDEF0123
    aws_secret_access_key: 0123456789abcdef0123456789/abcdef0123456
  ```

The configuration also takes `aws_region` which defaults to `us-east-1` (Route 53 is a global AWS service). Set it only if you need to use a different region endpoint.

For security reasons, don't use your main account's credentials. Instead, add a new [AWS user](https://console.aws.amazon.com/iam/home?#/users) with _Access Type: Programmatic access_ and use that user's access key. Assign a minimum [policy](https://console.aws.amazon.com/iam/home?#/policies$new?step=edit) like the following example. Make sure to replace the Resource ARN in the first statement to your domain's hosted zone ARN or use _*_ for all.

  ```json
  {
      "Version": "2012-10-17",
      "Statement": [
          {
              "Sid": "ChangeSpecificDomainsRecordSet",
              "Effect": "Allow",
              "Action": "route53:ChangeResourceRecordSets",
              "Resource": "arn:aws:route53:::hostedzone/01234567890ABC"
          },
          {
              "Sid": "ListAllHostedZones",
              "Effect": "Allow",
              "Action": "route53:ListHostedZones",
              "Resource": "*"
          },
          {
              "Sid": "ReadChanges",
              "Effect": "Allow",
              "Action": "route53:GetChange",
              "Resource": "arn:aws:route53:::change/*"
          }
      ]
  }
  ```

</details>

<details>
  <summary>SakuraCloud</summary>

Use of this plugin requires Sakura Cloud DNS API credentials, obtained from your Sakura Cloud DNS [apikey page](https://secure.sakura.ad.jp/cloud/#!/apikey/top/).

```yaml
email: your.email@example.com
domains:
  - your.domain.tld
certfile: fullchain.pem
keyfile: privkey.pem
challenge: dns
dns:
  provider: dns-sakuracloud
  sakuracloud_api_secret: ''
  sakuracloud_api_token: ''
```

[Full Documentation](https://certbot-dns-sakuracloud.readthedocs.io/en/stable/)

</details>

<details>
  <summary>Simply.com</summary>

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-simply
    simply_account_name: Sxxxxxx
    simply_api_key: YOUR_API_KEY # Replace 'YOUR_API_KEY' with your actual Simply.com API key.
  ```

The `simply_account_name` refers to the Simply.com account number (Sxxxxxx), and the `simply_api_key` is the account's API key.
The API key assigned to your Simply.com account can be found in your Simply.com Control panel.

</details>

<details>
  <summary>TransIP</summary>

You will need to generate an API key from the TransIP Control Panel at <https://www.transip.nl/cp/account/api/>.

The propagation limit will be automatically raised to 240 seconds.

Example configuration:

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-transip
    transip_username: transip-user
    transip_api_key: |
      -----BEGIN PRIVATE KEY-----
      MII..ABCDEFGHIJKLMNOPQRSTUVWXYZ
      AAAAAABCDEFGHIJKLMNOPQRSTUVWXYZ
      -----END PRIVATE KEY-----
  ```

</details>

<details>
  <summary>WebSupport</summary>

An identifier and secret key have to be obtained to use this module (see <https://admin.websupport.sk/sk/auth/apiKey>).

  ```yaml
  email: your.email@example.com
  domains:
    - your.domain.tld
  certfile: fullchain.pem
  keyfile: privkey.pem
  challenge: dns
  dns:
    provider: dns-websupport
    websupport_identifier: <identifier>
    websupport_secret_key: <secret_key>
  ```

</details>

## Certificate files

The certificate files will be available within the "ssl" share after successful request of the certificates.

By default other apps are referring to the correct path of the certificates.
You can in addition find the files via the **Samba** app within the "ssl" share.

## Supported DNS providers

```txt
dns-lego (generic, supports any lego DNS provider)
dns-azure
dns-bunny
dns-cloudflare
dns-cloudns
dns-desec
dns-digitalocean
dns-directadmin
dns-dnsimple
dns-dnsmadeeasy
dns-dnsservices
dns-domainoffensive
dns-dreamhost
dns-duckdns
dns-dynu
dns-easydns
dns-eurodns
dns-gandi
dns-gehirn
dns-godaddy
dns-google
dns-he
dns-hetzner
dns-httpreq
dns-infomaniak
dns-inwx
dns-ionos
dns-joker
dns-linode
dns-loopia
dns-luadns
dns-mijn-host
dns-namecheap
dns-netcup
dns-njalla
dns-noris
dns-nsone
dns-ovh
dns-plesk
dns-porkbun
dns-rfc2136
dns-route53
dns-sakuracloud
dns-simply
dns-transip
dns-websupport
```

## Support

Got questions?

You have several options to get them answered:

- The [Home Assistant Discord Chat Server][discord].
- The Home Assistant [Community Forum][forum].
- Join the [Reddit subreddit][reddit] in [/r/homeassistant][reddit]
- Check out certbots page [certbot].

In case you've found a bug, please [open an issue on our GitHub][issue].

[discord]: https://www.home-assistant.io/join-chat
[forum]: https://community.home-assistant.io
[issue]: https://github.com/home-assistant/addons/issues
[certbot]: https://certbot.eff.org
[reddit]: https://reddit.com/r/homeassistant
