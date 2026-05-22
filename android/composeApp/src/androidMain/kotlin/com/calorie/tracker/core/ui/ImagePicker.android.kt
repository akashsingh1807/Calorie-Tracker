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

    val authority = context.packageName + ".fileprovider"
    var tempUri: Uri? by remember { androidx.compose.runtime.mutableStateOf(null) }

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) { success: Boolean ->
        if (success && tempUri != null) {
            val bytes = context.contentResolver.openInputStream(tempUri!!)?.use { it.readBytes() }
            if (bytes != null) {
                val bitmap = android.graphics.BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                val stream = ByteArrayOutputStream()
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream)
                onImagePicked(stream.toByteArray())
            } else {
                onImagePicked(null)
            }
        } else {
            onImagePicked(null)
        }
    }

    return remember {
        ImagePicker(
            pickImageLauncher = { galleryLauncher.launch("image/*") },
            takePhotoLauncher = { 
                val tempFile = java.io.File.createTempFile("camera_image_", ".jpg", context.cacheDir)
                val uri = androidx.core.content.FileProvider.getUriForFile(context, authority, tempFile)
                tempUri = uri
                cameraLauncher.launch(uri) 
            }
        )
    }
}
