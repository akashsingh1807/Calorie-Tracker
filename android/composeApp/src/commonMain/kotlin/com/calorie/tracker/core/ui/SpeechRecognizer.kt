package com.calorie.tracker.core.ui

import androidx.compose.runtime.Composable

expect class SpeechRecognizerLauncher {
    fun startListening()
}

@Composable
expect fun rememberSpeechRecognizer(
    onResult: (String) -> Unit,
    onError: (String) -> Unit
): SpeechRecognizerLauncher
