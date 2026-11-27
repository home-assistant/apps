# Changelog

## 2.1.0

- Update base image to Alpine 3.24
- Publish app to GHCR

## 2.0.1

- Strip whitespace from DuckDNS API token (avoids fatal errors from copy-paste spaces)

## 2.0.0

- Remove unsupported architectures (armhf, armv7, i386)
- Update to Alpine 3.23

## 1.26.0

- Updated dehydrated fork with support for single-txt domains
- Use the new dehydrated script parameters which handles individual domain processing now

## 1.25.0

- Wildcard support when using domains as "*.yourDomain.duckdns.org > yourDomain.duckdns.org"

## 1.24.0

- Add a pass to combine individual domains into a single certificate

## 1.23.0

- Improve GREP syntax for better stability for tokens with dashes

## 1.22.0

- Fix bashio logger issue

## 1.21.0

- Call Dehydrator per-domain or alias due to limitation in DuckDNS which can only handle a single TXT record at a time
- Log the domain or alias being processed
- Remove filtering of the domain = alias, otherwise, aliases are not getting renewed
- Increase DuckDNS name server timeout to 120s

## 1.20.0

- Only deploy challenge for the main domain, aliases are handled through CNAME records

## 1.19.0

- Wait for up to 60 seconds for TXT record to propagate when deploying challenges

## 1.18.0

- Update to use s6-overlay to manage service
- Update base image to Alpine 3.20

## 1.17.0

- Reduce log spam when updating IP address

## 1.16.0

- Update base image to Alpine 3.19
- Update dehydrated to 0.7.1

## 1.15.0

- Use Supervisor API to detect IPv6 host addresses, selectable by interface
- Split IPv4 and IPv6 updates as duckdns skips v4 detection with v6 present
- Fix misleading help text regarding IPv6 address autodetection
- Disable Docker default system init for S6 update

## 1.14.0

- Add option to specify algorithm used for SSL certificates

## 1.13.0

- Update base to 3.14
- Use images from ghcr
- Update dehydrated to 0.7.0

## 1.12.5

- Fix bug causing DuckDNS to return KO, when aliases were configured

## 1.12.4

- Fix bug where IPv6 got the value of IPv4

## 1.12.3

- Dont set IPv4 / IPv6 in duckdns request if config is unset

## 1.12.2

- Rely on bashio to handle empty IPv4 / IPv6

## 1.12.1

- Clean up dehydrated lock file at start also if no live cert exists

## 1.12.0

- Add option to specify a service or URL as IPv4 and IPv6 address source
- Add DNS alias option to allow pointing a CNAME at a Duck DNS subdomain

## 1.11.0

- Do not skip TLS security checks on Duck DNS API access

## 1.10.0

- Fix issue with dehydrated lock file

## 1.9.0

- Fix issue with empty IPv4 / IPv6
