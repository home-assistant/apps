# Home Assistant App: Whisper

## Installation

Follow these steps to get the app installed on your system:

1. In Home Assistant, go to **Settings** > **Apps** > **Install app**.
2. Find the "Whisper" app and click it.
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

### Option: `language`

Default language for the app. In Home Assist 2023.8+, multiple languages can be used simultaneously by different [Assist pipelines](https://www.home-assistant.io/voice_control/voice_remote_local_assistant/).

If you select "auto", the model will run **much** slower but will auto-detect the spoken language.

[Performance of supported languages](https://github.com/openai/whisper#available-models-and-languages)

[List of two-letter language codes](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes)

### Option: `model`

Whisper model that will be used for transcription. Choose `custom` to use the model name in `custom_model`, which may be a HuggingFace model ID like "Systran/faster-distil-whisper-small.en".

The default model is "auto", which selects `tiny-int8` for ARM devices like the Raspberry Pi 4 and `base-int8` otherwise.
Compressed models (`int8`) are slightly less accurate than their counterparts, but smaller and faster. [Distilled](https://github.com/huggingface/distil-whisper) models are not compressed, but are faster and smaller than their non-distilled counterparts.

Available models:

- `auto` (select based on CPU)
- `tiny-int8` (compressed)
- `tiny`
- `tiny.en` (English only)
- `base-int8` (compressed)
- `base`
- `base.en` (English only)
- `small-int8` (compressed)
- `distil-small.en` (distilled, English only)
- `small`
- `small.en` (English only)
- `medium-int8` (compressed)
- `distil-medium.en` (distilled, English only)
- `medium`
- `medium.en` (English only)
- `large`
- `large-v1`
- `distil-large-v2` (distilled, English only)
- `large-v2`
- `distil-large-v3` (distilled, English only)
- `large-v3`
- `turbo` (faster than `large-v3`)

### Option: `custom_model`

Path to a converted model directory, or a CTranslate2-converted Whisper model ID from the HuggingFace Hub like "Systran/faster-distil-whisper-small.en".

If `custom_model_type` is set to `transformers`, a HuggingFace transformers Whisper model ID from HuggingFace like "openai/whisper-tiny.en" must be used.

To use a local custom Whisper model, first create a `models` subdirectory in the app's configuration directory if it does not already exist. Then copy your model directory into:
`/addon_configs/core_whisper/models/<your-model-dir>`.
Then, set the `custom_model` path to:
`/config/models/<your-model-dir>`. For a local model, the path must start with `/config/models/`, as this is how the add-on accesses your Home Assistant configuration directory through the container's mounted volume.

### Option: `custom_model_type`

Determines which speech-to-text backend to use for `custom_model` if `stt_library` is set to "auto".

### Option: `beam_size`

Number of candidates to consider simultaneously during transcription (see [beam search](https://en.wikipedia.org/wiki/Beam_search)).
The default value of `0` will automatically select `1` of ARM devices like the Raspberry Pi 4 and `5` otherwise.

Increasing the beam size will increase accuracy at the cost of performance.

### Option: `initial_prompt`

Description of audio that can help Whisper transcribe unusual words better.
See [this discussion](https://github.com/openai/whisper/discussions/963) for an example.

### Option: `stt_library`

Speech-to-text backend library to use:

- `auto` - select the best backend based on language/hardware
- `faster-whisper` - force [faster whisper][faster-whisper] backend
- `sherpa` - force [sherpa onnx][sherpa-onnx] backend (parakeet model only)
- `transformers` - force [HuggingFace transformers][transformers] backend
- `onnx-asr` - force [onnx asr][onnx-asr] backend
- `funasr` - force [funasr][] backend

**Note**: When `custom_model` is set, then `custom_model_type` will override `stt_library` when set to "auto".

### Option: `whisper_task`

Task to perform with the model:

- `transcribe` - transcribe audio in the spoken language (default)
- `translate` - translate the spoken audio into English

### Option: `sherpa_streaming`

Use streaming model with `sherpa` backend.

This overrides the default English model (parakeet) with a faster but less accurate streaming model (sherpa-onnx-streaming-zipformer-en-2023-06-26).

### Option: `vad_clip`

Use voice activity detection (VAD) to clip silence from audio before transcription. This is disabled by default.

This is mainly a latency win for silence-heavy audio with length-proportional batch backends like `sherpa` and `funasr`; streaming backends are unaffected.

### Option: `local_files_only`

Only use models that have already been downloaded, and never check online for
updates.

Leave this off the first time you use a model so it can download. Once your
models are downloaded, turn it on to keep the add-on fully offline — it will skip
the online update check on every request, which also speeds up startup.

If you turn this on before a model has been downloaded, transcription will fail
until you disable it again (or switch to a model you already have).

## Backups

Whisper model files can be large, so they are automatically excluded from backups and re-downloaded on restore for remote models.
After restoring a backup with a local custom Whisper model, manually copy your model directory again.

## Recommendations

A few starting points by language and priority. With `stt_library` = "auto" the
add-on selects a backend/model based on your `language` and hardware:

- **English** (`en`) → the parakeet model via the sherpa backend.
  `sherpa_streaming` swaps it for a faster streaming variant.
- **Chinese, Cantonese, Japanese, Korean** (`zh`, `yue`, `ja`, `ko`) → the
  SenseVoice model via the funasr backend. It is non-autoregressive and notably
  faster than Whisper while handling these languages well (locale codes like
  `zh-CN`/`zh-TW`/`zh-HK` are mapped automatically).
- **Russian** (`ru`) → the GigaAM model via the onnx-asr backend.
- **Everything else** → faster-whisper.

Two tips for non-English use:

- Set `language` to your explicit language code. Leaving it as "auto" works but is
  **much** slower, since the model has to detect the language on every request.
- To get English text out of non-English speech, set `whisper_task` = "translate".
  This applies to the Whisper backends (not parakeet/sherpa, SenseVoice, or GigaAM).

- English
  - Balanced
    - `language` = "en"
    - `model` = "auto"
    - `stt_library` = "auto"
    - `sherpa_streaming` = false
  - Fast
    - `language` = "en"
    - `model` = "auto"
    - `stt_library` = "auto"
    - `sherpa_streaming` = true
  - Accurate
    - `language` = "en"
    - `model` = "custom"
    - `stt_library` = "onnx-asr"
    - `custom_model` = "istupakov/canary-1b-v2-onnx"
- Chinese / Cantonese / Japanese / Korean
  - Balanced (recommended)
    - `language` = "zh", "yue", "ja", or "ko"
    - `model` = "auto"
    - `stt_library` = "auto"
      (selects the SenseVoice model via funasr — fast and accurate for
      these languages)
- Non-English (other languages)
  - Balanced
    - `language` = your language code (e.g. "de", "fr")
    - `model` = "auto"
    - `stt_library` = "auto"
  - Fast
    - `language` = your language code
    - `model` = "base-int8" (or "small-int8" if your CPU allows)
    - `stt_library` = "faster-whisper"
  - Accurate
    - `language` = your language code
    - `model` = "custom"
    - `stt_library` = "onnx-asr"
    - `custom_model` = "istupakov/canary-1b-v2-onnx"
      (~25 European languages; needs a capable CPU, not a Raspberry Pi)

## Support

Got questions?

You have several options to get them answered:

- The [Home Assistant Discord Chat Server][discord].
- The Home Assistant [Community Forum][forum].
- Join the [Reddit subreddit][reddit] in [/r/homeassistant][reddit]

In case you've found an bug, please [open an issue on our GitHub][issue].

[discord]: https://www.home-assistant.io/join-chat
[forum]: https://community.home-assistant.io
[issue]: https://github.com/home-assistant/app-whisper/issues
[reddit]: https://reddit.com/r/homeassistant
[repository]: https://github.com/hassio-addons/repository
[transformers]: https://huggingface.co/docs/transformers
[faster-whisper]: https://github.com/SYSTRAN/faster-whisper
[sherpa-onnx]: https://github.com/k2-fsa/sherpa-onnx
[onnx-asr]: https://github.com/istupakov/onnx-asr
[funasr]: https://github.com/modelscope/FunASR
