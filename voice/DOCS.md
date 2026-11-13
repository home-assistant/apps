# Voice

A second opinion on what your voice satellites hear.

Your satellite listens for its wake word on the device itself, which has to be
quick and cheap, so it is deliberately a little eager — better to wake at the
television now and then than to miss you. This app is the second look. When a
satellite wakes up, Home Assistant sends the recording of what it heard to this
app, which checks it against a much larger model and says whether that really
was the wake word.

If it was not, the command is dropped and nothing happens: no light turns on
because the television said something that sounded like "okay nabu".

It also listens for the end of what you said. Home Assistant decides you have
finished talking from the audio alone, on a budget; this app has more to work
with, and is better at hearing quiet voices and children, so commands are less
often cut off mid-sentence or left waiting.

## Setup

There is none. Install the app, start it, and Home Assistant will offer to set
it up; there is nothing to fill in and nothing to configure.

## What it works with

Satellites that send Home Assistant the audio from just before they woke up.
ESPHome voice satellites do this on firmware that supports wake word audio.
Satellites that do not are unaffected: they wake up exactly as they do today.

It currently verifies **Okay Nabu**, **Hey Jarvis** and **Hey Mycroft**, in
English. Any other wake word, including a custom one, is left alone.

How long a pause ends your command is still the **voice assistant
sensitivity** you set on the satellite. Nothing here is configured.

## If the app is stopped

Nothing stops working. Wake words are accepted without the second look, and
Home Assistant finds the end of your command itself, which is how your
satellites behave without this app at all.
