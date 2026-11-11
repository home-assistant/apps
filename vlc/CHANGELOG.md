# Changelog

## 1.2.0

- Convert startup scripts to s6-rc oneshots and modernize finish scripts
- Move the s6 user bundle to user-bundles.d
- Update base image to 3.24-2026.11.0
- Publish app to GHCR

## 1.1.0

- Run VLC with user privileges
- Fix default media directory
- Update to Alpine 3.24

## 1.0.0

- Remove unsupported architectures (armv7, i386)
- Update to Alpine 3.23

## 0.3.1

- Restart VLC on Audio plug-in restart
- Update to Alpine 3.22

## 0.3.0

- Prevent race condition reading secrets on startup
- Update to Alpine 3.19

## 0.2.0

- Update to Alpine 3.17
- Mark add-on as stable
- Use new s6-overlay

## 0.1.3

- Correct port on discovery

## 0.1.2

- Revert restart nginx service on error

## 0.1.1

- Restart nginx service on error

## 0.1.0

- Initial release
