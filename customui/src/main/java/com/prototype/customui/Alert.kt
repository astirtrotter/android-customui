package com.prototype.customui

import android.content.Context
import androidx.appcompat.app.AlertDialog

object Alert {

    fun show(context: Context, titleText: String, message: String, buttonText: String, action: () -> Unit) {
        AlertDialog.Builder(context)
            .setCancelable(false)
            .setTitle(titleText)
            .setMessage(message)
            .setPositiveButton(buttonText, { _, _ ->
                action()
            })
            .create()
            .show()
    }
}