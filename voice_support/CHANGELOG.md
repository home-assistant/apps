# Changelog

## 0.2.0

### New features

- Wake words that the first check refuses now get a second opinion from a
  larger speech model, so far fewer real wake words are ignored. The model
  (about 174 MB) is downloaded the first time the app starts.
- Speech-to-text now starts where the wake word ends, so a command said
  straight after the wake word keeps its first word more often.

### Bug fixes

- Fix wake word verdicts getting out of step after a run ended while its
  wake word was still being checked.

## 0.1.1

### Bug fixes

- Allow installation on Home Assistant 2026.12 development and beta builds.

## 0.1.0

- Initial release.
