# Home Assistant App: Piper

## Installation

Follow these steps to get the app installed on your system:

1. In Home Assistant, go to **Settings** > **Apps** > **Install app**.
2. Find the "Piper" app and click it.
3. Click on the "INSTALL" button.

## How to use

After this app is installed and running, it will be automatically discovered
by the Wyoming integration in Home Assistant. To finish the setup,
click the following my button:

[![Open your Home Assistant instance and start setting up a new integration.](https://my.home-assistant.io/badges/config_flow_start.svg)](https://my.home-assistant.io/redirect/config_flow_start/?domain=wyoming)

Alternatively, you can install the Wyoming integration manually, see the
[Wyoming integration documentation](https://www.home-assistant.io/integrations/wyoming/)
for more information.

## Configuration

### Option: `backend`

The text-to-speech engine to use.

- `piper` (the default) is fast, runs well on a Raspberry Pi, and uses the
  voices listed under the `voice` option below.
- `omnivoice` is **experimental**. It is considerably higher quality, supports
  many more languages, and can clone a voice from a short recording, but it is
  much slower and really needs a desktop or server CPU. It will run on
  `aarch64`, with a warning, but expect it to be impractically slow there.

OmniVoice is not part of the app image. Selecting it downloads it, along with a
model of several GB, the first time the app starts, so it can take a long time
before the app becomes available in Home Assistant. Later starts reuse the
download.

The two backends have separate voices. Switching backends changes the list of
voices the app advertises, so reload the Wyoming integration for Piper
afterwards.

### Option: `enable_japanese` / `enable_thai`

Japanese and Thai voices need an extra phonemizer that is not part of the app
image, because it is large and most installs do not need it. Turning the option
on downloads it the first time the app starts (around 350 MB for Japanese,
390 MB for Thai), so that start takes noticeably longer than usual. Later starts
reuse the download.

While an option is off, its voices are not offered to Home Assistant at all, so
they will not appear in the Wyoming integration's voice list. Reload that
integration after turning one on. If the app's own `voice` option is set to a
Japanese or Thai voice without its option turned on, the app stops at startup
and says which one to enable.

### Option: `omnivoice_steps`

Number of decode steps used by the `omnivoice` backend. Fewer steps are faster,
more steps sound better; the default of 32 is a safe choice, and values as low
as 10 still sound clean. Ignored by the `piper` backend.

### Option: `voice`

[Listen to voice samples](https://rhasspy.github.io/piper-samples/)

Name of the Piper voice to use, such as `en_US-lessac-medium` (the default).
Voice models are automatically downloaded from https://huggingface.co/rhasspy/piper-voices/tree/main

Voices are named according to the following scheme: `<language>_<REGION>-<name>-<quality>`
The `<name>` portion comes from the dataset used to train the voice or the speaker's name if it was provided.

A voice's quality comes in 4 different levels:

- `x_low` - 16Khz, smallest/fastest
- `low` - 16Khz, fast
- `medium` - 22.05Khz, slower but better sounding
- `high` - 22.05Khz, slowest but best sounding

On a Raspberry Pi 4, up to the `medium` models will run with usable speed. If audio quality is not a priority, prefer the `low` or `x-low` voices as they will be noticeably faster than `medium`.

### Option: `speaker`

Speaker number to use if the voice supports multiple speakers, such as [`en-us-libritts-high`](https://rhasspy.github.io/piper-samples/#en-us-libritts-high).

By default, the first speaker (speaker 0) will be used.

### Option: `length_scale`

Speeds up or slows down the voice. A value of 1.0 means to use the voice's default speaking rate, with < 1.0 being faster and > 1.0 being slower.

### Option: `noise_scale`

Controls the variability of audio by adding noise during audio generation. The effect highly depends on the voice itself, but in general a value of 0 removes variability and values above 1 will start to degrade audio.

### Option: `noise_w`

Controls the variability of speaking cadence (phoneme widths). The effect highly depends on the voice itself, but in general a value of 0 removes variability and values above 1 produce extreme stutters and pauses.

### Option: `sentence_silence`

Adds the given number of seconds of silence after every sentence.

### Option: `update_voices`

Download the list of new voices automatically every time the app starts. You must also reload the Wyoming integration for Piper in Home Assistant to see new voices.

### Option: `debug_logging`

Print DEBUG level messages to the app's log.

## Web Interface

The app has a small web interface for managing voices, reachable with the "Open
Web UI" button on the app page. It is served through Home Assistant ingress, so
using it means going through Home Assistant and being an administrator. Its port
is not published, and it only answers Home Assistant's ingress proxy — other
apps on the same machine are refused.

It has two sections:

- **Piper** — upload and delete custom Piper voices (a `<voice>.onnx` model plus
  its `<voice>.onnx.json` config).
- **OmniVoice** — upload a reference recording (a WAV file) and its transcript
  to create a cloning voice.

The app picks up added and removed voices on its own, but Home Assistant caches
the voice list, so **reload the Wyoming integration for Piper** for a new voice
to show up there.

Voices in `/share/piper` are listed but cannot be deleted from the web
interface, because that directory is mounted read-only. Delete those files
directly instead.

Because voices can be added and removed here, the set you end up with is your
own, and an uploaded voice exists nowhere else, so uploads are included in the
app's backups. What can be fetched again is not: a voice from Piper's catalog
is moved to `/data/catalog_voices` when the app starts and left out of backups
from then on, as are the OmniVoice model weights and the downloads for the
Japanese and Thai options. A restore downloads the catalog voices it needs
again, on demand.

The move only happens when the file is byte for byte the catalog's, so a voice
of your own that borrows a catalog name — a fine-tune exported as
`en_US-lessac-medium.onnx`, say — keeps its place in backups. A voice already
downloaded while the app is running is moved at the next restart, so one backup
can still include it.

## Custom Voices

Add custom voice files to the `/share/piper` directory, or upload them through
the web interface. Each custom voice must include a model file (`<voice>.onnx`)
and config file (`<voice>.onnx.json`).
See the [training guide](https://github.com/rhasspy/piper/blob/master/TRAINING.md) for details on how to train and export a custom voice.

## Custom OmniVoice Voices

The `omnivoice` backend uses its own voices, which are not Piper voice models.
They live in `/data/omnivoice_voices` inside the app, organized as
`<language>/<voice_name>/`, and are managed through the **OmniVoice** section of
the web interface. Each voice is a reference recording (`ref.wav`) plus its
transcript (`ref.txt`), which OmniVoice clones.

A `default` voice is always available for every supported language and uses
OmniVoice's built-in speaker, so cloning voices are optional.

These voices are included in app backups. The downloaded OmniVoice model is not,
since it is several GB and is re-downloaded when needed.

## Support

Got questions?

You have several options to get them answered:

- The [Home Assistant Discord Chat Server][discord].
- The Home Assistant [Community Forum][forum].
- Join the [Reddit subreddit][reddit] in [/r/homeassistant][reddit]

In case you've found an bug, please [open an issue on our GitHub][issue].

[discord]: https://www.home-assistant.io/join-chat
[forum]: https://community.home-assistant.io
[issue]: https://github.com/home-assistant/addons/issues
[reddit]: https://reddit.com/r/homeassistant
[repository]: https://github.com/hassio-addons/repository
