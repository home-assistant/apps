# openWakeWord – Home Assistant App

**openWakeWord** adds wake-word detection to Home Assistant’s voice system. It listens to microphone audio and triggers the voice pipeline when a chosen phrase (the *wake word*) is spoken.

It uses **pyopen-wakeword** to perform fast, local detection with very low CPU usage, making it ideal for devices like Raspberry Pi or other small voice satellites.

Part of Home Assistant’s **Year of Voice** initiative.

---

# What a Wake Word Is

A **wake word** is the phrase used to activate a voice assistant.

Example:

```
User: "Hey Jarvis"
Assistant: *starts listening*
User: "Turn off the kitchen lights"
Home Assistant: executes the command
```

Without a wake word, the system would need to continuously run full speech recognition, which is expensive and raises privacy concerns.

Wake word detection solves this by only activating the assistant when the trigger phrase is heard.

---

# Where It Fits in the Voice Pipeline

Wake word detection is the **first step** in Home Assistant’s voice pipeline:

```
Microphone
   ↓
Wake Word Detection (openWakeWord)
   ↓
Speech-to-Text
   ↓
Intent Processing
   ↓
Automation / Action
   ↓
Text-to-Speech
```

openWakeWord continuously monitors audio and signals Home Assistant when the wake phrase is detected.

---

# Common Uses

### Voice Satellites

Small devices placed around the house that listen for the wake word.

Example:

```
"Okay Home, turn on the porch light"
```

The satellite detects the wake word and forwards the command to Home Assistant.

---

### Fully Local Voice Assistants

openWakeWord enables a **completely local voice assistant** when combined with local:

* Speech-to-text
* Intent recognition
* Text-to-speech

---

### Custom Wake Words

Multiple wake words can be used depending on context:

* “Jarvis”
* “Computer”
* “Okay Home”

---

# Installation

1. Open **Home Assistant**.
2. Go to **Settings → Add-ons → Add-on Store**.
3. Install **openWakeWord**.
4. Start the add-on.

Requires **Home Assistant 2023.9+**

Supported architectures:

* **aarch64**
* **amd64**

---

# How to Implement It

## 1. Install the Add-on

Install and start **openWakeWord** from the Add-on Store.

---

## 2. Configure a Voice Pipeline

Navigate to:

```
Settings → Voice Assistants → Pipelines
```

Create or edit a pipeline and select:

* **Wake Word Detection:** openWakeWord

You will also need:

* Speech-to-text provider
* Conversation agent
* Text-to-speech provider (optional)

---

## 3. Connect a Microphone

Wake word detection requires a microphone source such as:

* Voice satellite device
* Browser microphone
* ESPHome voice device
* Assist microphone hardware

---

## 4. Test It

Speak the configured wake phrase:

```
"Okay Home"
```

When detected, the voice assistant will begin processing the command that follows.

---

# Features

* Local wake word detection
* Low CPU usage
* Multiple wake word models
* Works with Home Assistant Assist pipeline
* Designed for edge voice devices

