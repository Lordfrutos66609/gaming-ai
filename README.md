# Lootwise — personal gaming coach

Native Android test app for gaming questions, character builds and learning. Starts with a Diablo II profile and works with other games too. This is a client for Claude, not a newly trained foundation model.

## Install the test APK
1. Open the repository **Actions** tab and the latest successful **Android test APK** run.
2. Download **Lootwise-android-test** from Artifacts (GitHub sign-in required).
3. Extract the ZIP on your Android phone and open `app-debug.apk`. Allow installation from your browser/file manager if Android asks.
4. Open Settings, enter your own Anthropic API key, load and select a model, then Save settings.
5. Add your Hero profile and start chatting.

Android 8.0+ required. API credits are separate from a Claude subscription. Friends must use their own keys. No key is built into the APK. Test APKs are debug-signed; a later build may require uninstalling the previous version, which deletes its local data. Artifacts expire after 14 days; rerun the workflow if needed.

## What works
- Online coaching in your language with a concise-answer prompt.
- Saved hero context and recent conversation (24 local messages; last 12 sent).
- Screenshot input through Android's document picker, downsampled before upload.
- Encrypted API key using Android Keystore AES-GCM.
- Model selection from the provider, explicit sending and stopping, clear errors.

## Privacy and limits
Profile and chat stay in app-private local storage until sent. When Send is pressed, the profile, last 12 messages and current screenshot go to Anthropic. The API key is used only with `https://api.anthropic.com`. No analytics or shared server. Android backup is disabled. Images are transient and are not sent again in later turns. Conversations are not encrypted at rest beyond device protections; do not include sensitive information. Clearing app storage removes local settings and history. Removing a saved key does not revoke it with Anthropic.

No live web retrieval, game database, guaranteed patch accuracy or account integration. Model replies can be wrong. No API request automatically retries; retrying can cost again. Stop cannot guarantee the provider stops billing a request already received. No real API or phone testing was performed during source creation; CI verifies compilation, lint and limited unit tests only.

## Build
Use JDK 17, Gradle 8.11.1, Android SDK platform 35 and build-tools 35.0.0:

```sh
gradle testDebugUnitTest lintDebug assembleDebug
```

The pinned GitHub Actions workflow installs the toolchain and creates the APK. This repository does not include a Gradle wrapper. Android Studio can import it with a compatible local Gradle distribution. Release signing and Play Store publishing are not configured.

API docs: https://platform.claude.com/docs/en/api/messages
Android toolchain: https://developer.android.com/build/releases/agp-8-9-0-release-notes
