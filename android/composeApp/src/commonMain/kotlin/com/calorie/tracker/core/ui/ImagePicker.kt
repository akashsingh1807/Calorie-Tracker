package com.calorie.tracker.core.ui

import androidx.compose.runtime.Composable

expect class ImagePicker {
    fun pickImage()
    fun takePhoto()
}

@Composable
expect fun rememberImagePicker(onImagePicked: (ByteArray?) -> Unit): ImagePicker
