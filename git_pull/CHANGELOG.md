# Changelog

## 9.1.1

- git_pull: Mark deployment_key as password @agners (#9)
- git_pull: Only use deployment_key for SSH repositories @agners (#8)
- git_pull: Do not wipe /config when the clone fails @agners (#7)
- Update home-assistant/base image to 3.24-2026.11.0 @[renovate[bot]](https://github.com/apps/renovate) (#5)

## 9.1.0

- Update base image to Alpine 3.24
- Publish app to GHCR

## 9.0.4

- Fix HTTPS authentication with `deployment_user`/`deployment_password`
  always failing with `fatal: refusing to work with credential missing host
  field`. The credentials were piped only to `git credential approve`, while
  `git credential fill` ran with empty input.

## 9.0.3

- Fix `git-clone`'s restore-after-clone step copying a stale/corrupt `.git`
  directory from the pre-clone backup into the freshly cloned repository,
  which could corrupt the new clone's git metadata. `.git` is now excluded
  from that restore step, same as `*.yaml`/`*.yml`.

## 9.0.2

- Fix `.storage/` and other hidden files/directories being silently dropped from
  the pre-clone backup (they were never restored after the initial clone into
  an existing `/config`, because `cp -rf /config/*` does **not** match dotfiles).
  Use `cp -rf /config/.` instead, which copies directory contents including
  hidden entries.

## 9.0.1

- Replace eval+extglob with find for restoring non-YAML files after clone

## 9.0.0

- Update base image to Alpine 3.23
- Drop unsupported architectures
- Remove advanced flag in the app config

## 8.0.1
- Fix bashio warn(ing) logger usage breaking deployment keys

## 8.0.0
- Refactor git_pull to use HA Api with bashio
- Update base image to Alpine 3.21
- Remove ha cli dependency


## 7.14.1
- Fix error where $HOME is not defined

## 7.14.0

- Update base image to Alpine 3.19
- Update Home Assistant CLI to 4.31.0

## 7.13.1

- Update Home Assistant CLI to 4.12.2

## 7.13.0

- Update Home Assistant CLI to 4.12.1
- Upgrade base image to Alpine 3.13
- Supress a shellcheck warning happening in CI

## 7.12.2

- Update Home Assistant CLI to 4.11.0

## 7.12.1

- Update options schema for passwords

## 7.12.0

- Fix error of deployment_key eventually failing by overwriting the deployment_key every cycle

## 7.11.0

- Update Home Assistant CLI to 4.2.0

## 7.10.0

- Update Home Assistant CLI to 4.1.0

## 7.9.0

- Update Home Assistant CLI to 4.0.1

## 7.8.0

- Added support for Azure DevOps repositories by removing the requirement for the `.git` suffix
- Update to Alpine 3.11

## 7.7.0

- Update Hass.io CLI to 3.1.1

## 7.6.0

- Update Hass.io CLI to 3.1.0

## 7.5.0

- Update Hass.io CLI to 3.0.0

## 7.4.0

- Update Hass.io CLI to 2.3.0

## 7.3.0

- Update Hass.io CLI to 2.2.0

## 7.2.0

- Fix restart_ignore when specifying a sub-directory

## 7.1.0

- Enhance restart_ignore to support whole directories
- Fix repeat option: don't terminate if internet connection unavailable during a check

## 7.0.0

- Update Hass.io CLI to 2.0.1

## 6.1.0

- Bugfix in git diff command while comparing commits

## 6.0.0

- Allow to disable Home Assistant restart for specific file changes
