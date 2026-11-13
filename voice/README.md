# Voice

A second opinion on what your voice satellites hear.

A satellite's wake word detector is a small classifier running on every frame
of audio, on a microcontroller, tuned to fire cheaply — because a device that
misses its name is worse than one that occasionally answers the television.
Home Assistant's own end-of-command detection is a handful of thresholds over
the same stream. Both are what fits where they run.

This app is the other half of that trade. Home Assistant streams it a whole
interaction's audio, and it answers three questions: was that really the wake
word, where does the command begin, and where does it end.

It has no interface and nothing to configure. Install it, and Home Assistant
finds it.

## What it needs from Home Assistant

The wake word is only second-guessed when all of this is true, and nothing
breaks when it isn't:

- the satellite sends the audio it buffered before the detection — on ESPHome
  devices, wake word audio;
- the app has a model for that wake word (`GET /info` says which);
- the `voice_support` integration is set up, which the Supervisor arranges when
  the app starts.

Otherwise the detection stands exactly as the device reported it. Finding the
end of the command needs none of that, and happens for every run.

## How a run goes

```
HA  -> text    {"type": "run-start", "wake_word_phrase": "okay nabu", "wake_word_audio_ms": 1000, ...}
HA  -> binary  16 kHz 16-bit mono PCM, continuously
HA  -> text    {"type": "audio-end"}
app -> text    {"type": "wake-word-end", "wake_word_output": {"wake_word_audio_ms": 1000}}
app -> text    {"type": "stt-vad-start", "timestamp": 1840}
app -> text    {"type": "stt-vad-end", "timestamp": 4120}
```

One websocket per run, on `/run`. [PROTOCOL.md](https://github.com/OHF-Voice/app-voice/blob/main/voice/PROTOCOL.md) is the whole
agreement: every message, and the rules that are not messages — reading audio
separately from making sense of it, who gets to end the command, and what each
failure falls back to.

The events back are Home Assistant's own pipeline events, so nothing in
between has to translate them. `wake_word_audio_ms` is where the wake phrase
ends, which is already where speech-to-text starts.

Today the app sends back the boundary the satellite reported. The Kaldi
alignment is real, but not yet a better place to cut: the experimental app
measured its end of the wake phrase landing a median 0.3-0.4 s after a CTC
placement of the same audio, far enough to take the first word of the command
with it (76.2% of commands correct against 89.6%). It is logged, so a better
placement can be compared against it.

## Where the command ends

Silero VAD and microVAD run on the same audio and the louder of the two is
believed, because each is deaf to things the other hears: a child's commands,
loud and clear to speech-to-text, were 0.3 s of speech to Silero and left the
command unstarted for 15 s, where microVAD heard a third of them as speech.
microVAD in turn hears more of what is not speech.

Two things come from the wake word audio, which the app has in hand because
the whole run is streamed to it. Silero hears the command raised to a level it
can work with when the wake word was quiet, and it hears the wake word first —
started cold at the split it scored a command said straight after the wake
word ~0.4, where it had heard speech all along ~0.8. Only the detector's copy
is touched; the audio Home Assistant holds is as it came.

Home Assistant sends the silence the person's voice activity sensitivity asks
for, and the app adds a constant to it: that number is calibrated against Home
Assistant's own segmenter, and against these two detectors the same wait is
longer. The three choices keep their spacing, which is the part that has to
survive — it is a promise about how long someone may pause, not a tuning of
this detector.

## The verifier

Kaldi, vendored in [voice/kaldi](https://github.com/OHF-Voice/app-voice/tree/main/voice/voice/kaldi): four grammar-constrained
decodes of one acoustic model — the wake phrase, free background speech, the phrase minus its
last word, and the phrase's known confusables. The wake word is accepted when
the phrase beats background on its prefix _and_ on its last word, and no
confusable beats it by much. Those are three separate decisions and they fail
separately: "okay now" loses on the last word, "okay naruto" on the confusable
margin.

`wake.yaml` is where the phrases, confusables, pronunciations and thresholds
live, with the measurements behind each number.

The code is a copy of [wyoming-wake-kaldi][]'s, not a dependency on it. That
project is a Wyoming server, and this app does not speak Wyoming to it -- it
reached past the server into internals nobody promised to keep. Dropping the
server left code that imports nothing but the standard library and PyYAML, so
there is no package to install and no Wyoming to carry. A copy under a name of
its own also cannot be shadowed by an installed or editable copy of the
original, which is a failure that looks like a wrong answer rather than an
import error. `voice/kaldi/__init__.py` says what was changed.

### The retry

A detector that fires before the speaker has finished leaves the last phoneme
outside the window, and the thresholds are then applied to a truncated phrase.
When the alignment puts the end of the phrase hard against the end of the
window, that is what happened, and the window slides forward over audio from
after the detection.

Only then. Measured across four speakers in the experimental app, sliding
_always_ cost two of them (-1.4 and -2.8 points) what it gained the one being
truncated; sliding only on a pinned split gained +3.8 and +0.7 and took nothing
from anyone. Audio for the whole run is already arriving, so this is the app
waiting rather than asking Home Assistant for anything.

## Failing open

Every failure path accepts the detection: an app that is down, slow, confused,
or has no model for the wake word. Wrongly accepting costs one unwanted
command; wrongly refusing costs a device that no longer answers its name. Only
a verifier that ran and said no refuses.

The same holds for the command's end. An app that stops answering mid-run
leaves Home Assistant's own segmenter to find it, because one app going away
must not leave a command that never ends.

## Building

The Kaldi and OpenFST binaries and the acoustic model are ~255 MB that no
package index serves, so they are staged before the image is built:

```bash
script/stage_build [path to a wyoming-wake-kaldi checkout]
```

The decoder daemon is built from the vendored source against those binaries.
Without it every decode spawns its own Kaldi process, which works: on one
window of "okay nabu", 42 ms with the daemon against roughly 200 ms without.

```bash
bash voice/kaldi/decoderd/build.sh "$PWD/local/wake-kaldi-tools"
```

An image built without any of this still builds and still runs. It reports no
wake words, and Home Assistant never asks it anything.

## Running it while working on it

The app is an ordinary server, so it does not have to be an app to be used.
Run it from a checkout:

```bash
python3 -m voice --port 10900 --wake-config wake.yaml --train-dir var/wake-train
```

and add it in Home Assistant from **Settings → Devices & services → Add
integration → Voice**, which asks for a host and port when there is no
Supervisor to install an app from. Without `local/` staged it will start and
report no wake words, which is enough to exercise everything but the decode.

For a development tree, `local/wake-kaldi-tools` and `local/wake-kaldi-models`
can be symlinks into a wyoming-wake-kaldi checkout rather than copies.
`script/stage_build` makes real copies, which is what a Docker build needs.

## Tests

```bash
python3 -m pytest
```

[wyoming-wake-kaldi]: https://github.com/OHF-Voice/wyoming-wake-kaldi
