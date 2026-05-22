# Context Handoff: Caloriyaan Project

## Overview
We are building **Caloriyaan** (formerly NutriAI/Calorie Tracker), an AI-powered nutrition tracking application. The product consists of:
1. **Frontend Web App**: Next.js (React), previously using a raw brutalist UI, now completely overhauled to a soft **Minimal Materialistic UI** (colors: #F8FAFC background, #0EA5E9 primary).
2. **Android App**: Kotlin Multiplatform / Jetpack Compose. Also transitioned from brutalist to Material 3 UI (`12.dp` rounded corners, standard modern typography).
3. **Backend**: Spring Boot backend connected to a PostgreSQL database hosted on Google Cloud SQL.
4. **Cloud Infrastructure**: Deployed on Google Cloud Run via GitHub Actions CI/CD pipelines.

## Critical Bugs Fixed
1. **16500 Calorie Dashboard Bug**: The PostgreSQL database local instance (`akashsingh` user) accumulated hundreds of entries from early AI hallucination testing. We ran `DELETE FROM meals;` and `DELETE FROM food_items;` to cleanly wipe test data.

## Current State & Recent Work
- **UI Design**: Both Web and Android apps have completely implemented the "Minimal Materialistic UI" per the latest user instructions. All old raw brutalist styles (sharp edges, generic CSS) are gone.
- **Testing Setup**: We added Espresso UI Testing frameworks (`ui-test-junit4`) into the Android project. 
- **CI Pipeline**: Created a GitHub Action (`android-test.yml`) that runs an API 30 emulator to run `connectedAndroidTest` automatically on all pushes to `main`.
- **Test Coverage**: We wrote `AuthFlowTest.kt`, `DashboardFlowTest.kt`, and an exhaustive `DetailedUITest.kt` covering all clicks and button scenarios on the main UI screens.

## Testing Quirks
- The user's local emulator (`Small_Phone(AVD) - 17`) throws a `java.lang.NoSuchMethodException: android.hardware.input.InputManager.getInstance` when running instrumented tests due to a missing framework API on that specific local emulator image. This is bypassed completely by using the GitHub Actions API 30 emulator. We ran the local tests via `adb shell monkey` to verify stability manually.

## Next Steps
- Implement AI vision logging within the newly designed Android camera flow.
- Ensure the backend REST API continues to sync correctly with the new "Caloriyaan" endpoints if any refactoring is needed.
