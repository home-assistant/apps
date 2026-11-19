# Changelog

## 3.6.1

- Update wyoming-faster-whisper from 3.9.0 to 3.9.1
- Custom models are offered for all of Whisper's languages again. Since 3.6.0, a custom `onnx-asr`, `sherpa` or `funasr` model was only offered for its library's default languages (for example Russian only for `onnx-asr`), so a pipeline in another language could not select it
- The `onnx-asr` library no longer keeps CPU cores busy after a transcript, which slowed down other work on the same machine, such as a local LLM answering the command
- On x86-64 CPUs without x86-64-v2 support (often a virtual machine with CPU type `kvm64`), the app now stops at startup with a message explaining how to fix it, instead of crashing with a NumPy error

## 3.6.0

- Update wyoming-faster-whisper from 3.5.0 to 3.9.0
- Only advertise the languages the selected speech-to-text library can transcribe. With the library set to `auto` (the default), every Whisper language is still available
- Make Cantonese reachable from Home Assistant pipelines (advertised as `zh-HK`)
- Warn at startup when the configured language is not supported by the selected library, and fall back to auto-detection instead of failing when a language code is unusable
- Streaming sherpa models no longer cut off the last word or two of a command
- Start without internet access when the model is already downloaded
- Stopping the app during a first model download no longer leaves a broken model behind that fails to load on every later start
- Warn at startup when an initial prompt is used with a Distil-Whisper model, which these models do not support
- Update speech recognition components: wyoming 1.11.0, onnxruntime 1.32.0, sherpa-onnx 1.13.8, CTranslate2 4.9.0, FunASR 1.4.27
- Update the Debian trixie base image
- The app is now built from [home-assistant/app-whisper](https://github.com/home-assistant/app-whisper) and its signed image is published to GitHub Container Registry

## 3.5.3

- Shut down cleanly when the app is stopped
- Leave the "Starting" state faster by checking readiness every 5 seconds
  during startup

## 3.5.2

- Update speech recognition components to their latest versions
- Disable ONNX Runtime telemetry: newer versions send usage data to a
  Microsoft server by default, this app keeps it turned off

## 3.5.1.

- Upgrade base image to trixie

## 3.5.0

- Bump torch to avoid regression: https://github.com/pytorch/pytorch/issues/146792
- Use `find_spec` to avoid importing modules for backend check

## 3.4.1

- Add `vad_clip` option to enable VAD clipping of audio before processing (faster processing for many backends, may not work on Pi 4)
- Bump `pysilero-vad` to use GGML version (with `GGML_NATIVE=OFF`)

## 3.3.2

- Add `libgomp1` so `torch`/`torchaudio` can load again, fixing the startup crash loop introduced in 3.3.1

## 3.3.1

- Ensure zh/yue/ja/ko default to FunASR
- Add `local_files_only` option to stay offline once models are downloaded
- Add FunASR speech-to-text backend defaulting to `FunAudioLLM/SenseVoiceSmall` (`@LauraGPT`)
  - Non-autoregressive and notably faster than Whisper; supports English, Chinese, Cantonese, Japanese, and Korean well
- Fix streaming sherpa cutting off the end of utterances (add tail padding before flushing)
- Default streaming sherpa to the Kroko 2025 zipformer models (mixed-case, punctuated, much better accuracy than the old LibriSpeech model); adds `de`/`es`/`fr` defaults
- Use `--beam-size` for streaming sherpa decoding (beam search when > 1, greedy otherwise)

## 3.2.0

- Fix transformers language
- Add initial prompt to transformers
- Add `--whisper-task` which can be set to "translate" instead of "transcribe" (`@M4TH1EU`)
- Add `--sherpa-streaming` to prefer streaming models (`@pkrahmer`)
- Bump `onnx-asr` to 0.11.0 (supports `istupakov/canary-1b-v2-onnx`)

## 3.1.0

- Fix model selection for language
- Prefer Parakeet only for English (detection fails for other languages)
- Add missing `onnx_asr` dependency

## 3.0.1

- Add support for `sherpa-onnx` and Nvidia's parakeet model
- Prefer parakeet model in `auto`
- Add support for GigaAM for Russian
- Add `stt_library` option to choose backend

## 2.6.0

- Upgrade to Debian bookworm
- Add support for HuggingFace transformers Whisper models

## 2.5.0

- Added configuration mapping to access local models.
- Updated documentation about `custom_model` usage.

## 2.4.0

- Add "auto" for model and beam size (0) to select values based on CPU

## 2.3.1

- Move `turbo` down the list closer to `large` to avoid confusion

## 2.3.0

- Bump `wyoming-whisper` to 2.3.0 (`faster-whisper` to 1.1.0)
- Supports model `turbo` for faster processing

## 2.2.0

- Bump `wyoming-whisper` to 2.2.0 (`faster-whisper` to 1.0.3)

## 2.1.2

- Fix excluding models files from backup

## 2.1.1

- Exclude `data/models*` files from backup

## 2.1.0

- Add distil-large-v3 `model` option

## 2.0.0

- Add more models for `model` option
- Add "custom" option for `model` that will use `custom_model` instead
- Add `custom_model` that can be a path to a model directory or HuggingFace Hub model ID
- Use faster-whisper PyPI package
- Add `initial_prompt` for helping with unusual words (see: https://github.com/openai/whisper/discussions/963)

## 1.0.2

- Convert error to warning for CPUs not supporting AVX instructions

## 1.0.1

- Handle unsupported CPU configurations

## 1.0.0

- Upgrade to `wyoming-whisper` 1.0.1
- Allow multiple languages to be used simultaneously without restart

## 0.2.1

- Exclude `*.bin` model files from backup

## 0.2.0

- Hash model files at startup to detect bad downloads
- Fix "auto" language

## 0.1.1

- Enable Wyoming protocol discovery

## 0.1.0

- Initial release
