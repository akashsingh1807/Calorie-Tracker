package com.calorie.tracker.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

actual class ImagePicker(
    private val pickImageLauncher: () -> Unit,
    private val takePhotoLauncher: () -> Unit
) {
    actual fun pickImage() {
        pickImageLauncher()
    }

    actual fun takePhoto() {
        takePhotoLauncher()
    }
}

@Composable
actual fun rememberImagePicker(onImagePicked: (ByteArray?) -> Unit): ImagePicker {
    return remember {
        ImagePicker(
            pickImageLauncher = {
                // Not implemented for iOS yet
                onImagePicked(null)
            },
            takePhotoLauncher = {
                // Not implemented for iOS yet
                onImagePicked(null)
            }
        )
    }
}
