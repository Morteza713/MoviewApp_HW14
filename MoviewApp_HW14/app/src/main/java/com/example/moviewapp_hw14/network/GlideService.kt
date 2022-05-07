package com.example.moviewapp_hw14.network

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.util.Base64
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.io.ByteArrayOutputStream

fun ImageView.glide(url: String) {
    Glide.with(context)
        .load(url)
        .into(this)
}

fun Bitmap.convert(): String {
    val byteArrayOutputStream = ByteArrayOutputStream()
    this.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)
    val byteArray = byteArrayOutputStream.toByteArray()
    return Base64.encodeToString(byteArray, Base64.DEFAULT)
}

fun Uri.convert(context: Context): ByteArray? {
    return context.contentResolver.openInputStream(this)?.readBytes()
}

fun Bitmap.arrayConvert(): ByteArray{
    val stream = ByteArrayOutputStream()
    this.compress(Bitmap.CompressFormat.PNG, 10, stream)
    return stream.toByteArray()
}