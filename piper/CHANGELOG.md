# Changelog

## 2.5.4

First release from the standalone app repository. Includes wyoming-piper 2.5.3 and 2.5.4.

## Backups

- Downloaded voices are no longer included in backups. Catalog voices, `voices.json` and the OmniVoice model weights now live in `/data/downloads`, which is excluded and re-downloaded when needed. Voices uploaded through the web interface are kept in `/data/uploaded_voices` and are still backed up. Existing voices are sorted into the new directories once, on first start (#10)

## Web interface

- Voices larger than 16 MiB can be uploaded (#3)
- Uploading a voice again under the same name takes effect right away, and a deleted voice stops being used, without restarting the app (wyoming-piper 2.5.4)
- Uploads are atomic: a voice can no longer be loaded while it is still being uploaded, and an interrupted upload no longer leaves a broken voice behind (wyoming-piper 2.5.4)

## Voices

- New voices, including `fa_IR-magnoliasis-medium`, and updated files for re-released voices (#14)
- The Japanese voice is now `ja_JP-hi_fi_captain-medium`; the old `ja_JA-hi_fi_captain-medium` name still works

## Fixes

- A plain synthesize request sent after a streamed one on the same connection is answered instead of hanging (wyoming-piper 2.5.3)

## Maintenance

- Move the s6 user bundle to `user-bundles.d` (#9)
- Update the base image to `trixie-2026.11.0` and uv to 0.13.9 (#5, #6, #12, #13)
- Move dependency updates from Dependabot to Renovate (#1)

## 2.5.2

- Upgrade to `wyoming-piper` 2.5.2
- Add Japanese (OpenJTalk) and Thai (TLTK) support behind the new
  `enable_japanese` and `enable_thai` options, and the Thai voice they enable
  (`th_TH-tsync2-medium`)
- Japanese and Thai voices are hidden from Home Assistant until their option is
  turned on. They used to be offered and then produce silence
- A voice that fails to synthesize now reports why instead of returning empty
  audio
- An interrupted voice download is retried on the next start instead of leaving
  a truncated file that stayed broken until it was deleted by hand
- Voice models are included in backups again. They were skipped because they
  were only re-downloadable copies, but voices can now be uploaded and deleted
  from the web interface, so which ones are installed is your choice and an
  uploaded voice exists nowhere else. Large re-downloadable caches are still
  skipped
- Add 1 new Estonian voice (`et_EE-news-medium`)
- Japanese, Thai and OmniVoice are downloaded when their option is turned on
  rather than shipped in the app image, which keeps the image at roughly its
  previous size instead of growing to ~2 GB. The download is cached in `/data`
  and reused on later starts
- Add a voice management web interface, available through the app's "Open Web
  UI" button (ingress). Upload and delete custom Piper voices, and upload
  OmniVoice cloning voices, without needing file access to `/share`. Only Home
  Assistant's ingress proxy is allowed to reach it
- Add a `backend` option to switch between `piper` (default) and the
  experimental `omnivoice` backend. OmniVoice is higher quality and supports
  voice cloning, but is much slower and really wants a desktop or server CPU;
  it runs elsewhere with a warning, but expect it to be too slow to be useful
- Add an `omnivoice_steps` option to trade OmniVoice quality for speed
- Custom OmniVoice voices are stored in `/data/omnivoice_voices`, kept separate
  from the Piper voice models
- Replace the health check with a Wyoming Describe/Info round trip, which also
  works with the `omnivoice` backend
- Exclude the OmniVoice model and the HuggingFace cache from backups

## 2.3.4

- Disable ONNX Runtime telemetry: onnxruntime 1.29.0 (pulled in by the 2.3.3
  rebuild) introduced telemetry on Linux which uploads usage events and a
  persistent device identifier to a Microsoft endpoint by default

## 2.3.3

- Add 2 new Italian voices (`it_IT-serena-high`, `it_IT-serena-medium`)
- Add 1 new Bengali voice (`bn_BD-google-medium`)
- Add 1 new Czech voice (`cs_CZ-kasandra-medium`)
- Add 1 new Hebrew voice (`he_IL-saspeech-medium`)
- Add 1 new Armenian voice (`hy_AM-gor-medium`)
- Add 1 new Japanese voice (`ja_JA-hi_fi_captain-medium`)
- Add 1 new Korean voice (`ko_KR-kss-medium`)
- Add 1 new Marathi voice (`mr_IN-google-medium`)
- Add 1 new Urdu voice (`ur_PK-aegis_female-medium`)

## 2.3.2

- Migrate base image from bookworm to trixie

## 2.3.1

- Upgrade to `wyoming-piper` 2.3.1
- Add `sentence_silence` option to add silence after every sentence
- Add 3 new Ukrainian voices (`uk_UA-mykyta-high`, `uk_UA-oleksa-high`, `uk_UA-tetiana-high`)
- Add 3 new Telugu voices (`te_IN-maya-medium`, `te_IN-padmavathi-medium`, `te_IN-venkatesh-medium`)
- Add 2 new Greek voices (`el_GR-joy-medium`, `el_GR-rapunzelina-medium`)
- Add 2 new Basque voices (`eu_ES-antton-medium`, `eu_ES-maider-medium`)
- Add 1 new Bulgarian voice (`bg_BG-dimitar-medium`)
- Add 1 new English (US) voice (`en_US-mike-medium`)
- Add 1 new Spanish (Mexico) voice (`es_MX-ald-x_low`)
- Add 1 new Hindi voice (`hi_IN-rohan-medium`)
- Add 1 new Indonesian voice (`id_ID-news_tts-medium`)
- Add 1 new Kurdish voice (`ku_TR-berfin_renas-medium`)
- Add 1 new Dutch voice (`nl_NL-alex-medium`)
- Add 1 new Norwegian voice (`no_NO-nvcc-medium`)
- Add 1 new Polish voice (`pl_PL-bass-high`)
- Add 1 new Albanian voice (`sq_AL-edon-medium`)
- Add 1 new Swedish voice (`sv_SE-alma-medium`)
- Add 1 new Urdu voice (`ur_PK-fasih-medium`)

## 2.2.2

- Upgrade to `wyoming-piper` 2.2.2 (wheel fix)

## 2.2.1

- Upgrade to `wyoming-piper` 2.2.1
- Add support for new Chinese voices

## 2.1.1

- Upgrade to `wyoming-piper` 2.1.1
- Streaming is enabled by default (remove `streaming` option)
- Remove `max_piper_procs` option (no longer applicable)
- Drop support for `armv7`
- Fix zeroconf discovery

## 1.6.4

- Add missing voice for Argentinian Spanish (daniela)

## 1.6.3

- Bump wyoming to 1.7.2 to fix event data error

## 1.6.2

- Split sentences on numbered lists and remove asterisks surrounding words
- Remove asterisks at the start of a line (markdown list)
- Add new voices for Malayalam (arjun, meera)
- Add new voice for Nepali (chitwan)
- Add new voices for Hindi (pratham, priyamvada)
- Add new voice for Argentinian Spanish (daniela)

## 1.6.0

- Add support for streaming audio on sentence boundaries

## 1.5.4

- Add voices for Dutch: ronnie, pim
- Add voice for English: sam
- Add voice for Persian/English: reza_ibrahim
- Add voice for Persian: ganji
- Add voices for Portuguese (Brazilian): cadu, jeff

## 1.5.2

- Add missing voices supported by Piper (gwryw_gogleddol, bryce, john, norman and paola)

## 1.5.1

- Add voice for English: cori

## 1.5.0

- Add voices for Persian: amir, gyro
- Add voice for Slovenian: artur
- Add voice for Turkish: fettah
- Add voices for French: tom, mls
- Add voice for Dutch: mls
- Add voice for German: mls

## 1.4.0

- Add voices for Arabic (kareem), Hungarian (imre), English (libritts_r), and more
- Fix error when voice contains UTF-8 character (quote url)
- Fix missing "dataset" key error
- Fix unnecessary downloads due to /share

## 1.3.2

- Add voices for Hungarian, Turkish, Portuguese, Slovak, and Czech
- Look for custom voices in `/share/piper`
- Add `upgrade_voices` and `debug_logging` options
- Upgrade to Debian bookworm

## 1.2.0

- Upgrade to Piper 1.2
- Add over 30 new voices
- Change voice format to `<language>_<REGION>-<name>-<quality>`
- Voices are downloaded from https://huggingface.co/rhasspy/piper-voices
- Add `max_piper_procs` option

## 0.1.3

- Fix multi-line input
- Verify voice hashes on download
- Add 4 Icelandic voices
    - `is-bui-medium`
    - `is-salka-medium`
    - `is-steinn-medium`
    - `is-ugla-medium`
- Add 1 Russian voice
    - `ru-irinia-medium`

## 0.1.2

- Update list of available voices

## 0.1.1

- Enable Wyoming protocol discovery

## 0.1.0

- Initial release
