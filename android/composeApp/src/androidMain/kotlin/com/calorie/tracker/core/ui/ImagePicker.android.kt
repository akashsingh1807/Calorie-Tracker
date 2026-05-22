package com.calorie.tracker.core.ui

import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import java.io.ByteArrayOutputStream

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
    val context = LocalContext.current

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri != null) {
            val bytes = context.contentResolver.openInputStream(uri)?.use { it.readBytes() }
            if (bytes != null) {
                val bitmap = android.graphics.BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                val stream = ByteArrayOutputStream()
                // Compress down to 50% to save network bandwidth for Gemini Vision
                bitmap.compress(Bitmap.CompressFormat.JPEG, 50, stream)
                onImagePicked(stream.toByteArray())
            } else {
                onImagePicked(null)
            }
        } else {
            onImagePicked(null)
        }
    }

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { bitmap: Bitmap? ->
        if (bitmap != null) {
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream)
            onImagePicked(stream.toByteArray())
        } else {
            onImagePicked(null)
        }
    }

    return remember {
        ImagePicker(
            pickImageLauncher = { galleryLauncher.launch("image/*") },
            takePhotoLauncher = { cameraLauncher.launch(null) }
        )
    }
}
