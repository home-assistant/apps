# Changelog

## 2.2.0

- Update base image to Alpine 3.24 (with dnsmasq v2.92)
- Publish app to GHCR

## 2.1.0

- Added option for configuring TXT and PTR records

## 2.0.0

- Update base image to Alpine 3.23 (with dnsmasq v2.91)
- Drop unsupported architectures
- Remove advanced flag in the app config

## 1.8.1

- Fix config bug of cache_size option

## 1.8.0

- Add cache_size option

## 1.7.0

- Update to Alpine 3.19

## 1.6.0

- Update to Alpine 3.17
- Limit open file descriptors to 1024 to minimize

## 1.5.2

- Disable DNS request logging by default

## 1.5.1

- Default cnames to empty array

## 1.5.0

- Adds support for CNAME records

## 1.4.4

- Make it align to our base profile

## 1.4.3

- Fix signal handling

## 1.4.2

- Second run for AppArmor profile

## 1.4.1

- Fix AppArmor profile

## 1.4.0

- Adds support for srv-host records

## 1.3.0

- Rewrites add-on onto Bashio
- Adds README to add-on repository
- Some small code formatting

## 1.2.0

- Update DNSmasq 2.80

## 1.1.0

- Add AppArmor profile
