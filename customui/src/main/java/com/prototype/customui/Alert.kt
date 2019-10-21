package com.prototype.customui

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

object Alert {

    fun show(context: Context, titleText: String, messageText: String, buttonText: String, action: () -> Unit) {
        val dialog = AlertDialog.Builder(context)
            .setCancelable(false)
            .setView(R.layout.layout_alert)
            .create()

        dialog.setOnShowListener { _ ->
            val title = dialog.findViewById<TextView>(R.id.alert_title)
            val message = dialog.findViewById<TextView>(R.id.alert_message)
            val button = dialog.findViewById<TextView>(R.id.alert_button)

            title?.text = titleText
            message?.text = messageText
            button?.text = buttonText
            button?.setOnClickListener { _ ->
                action()
                dialog.dismiss()
            }
        }

        dialog.show()

        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}