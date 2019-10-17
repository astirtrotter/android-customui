package com.prototype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import com.prototype.customui.CommonButton
import com.prototype.customui.CommonLoader
import com.prototype.customui.CommonNavHeader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupCommonNavHeader()
        setupCommonButton()
    }

    private fun setupCommonNavHeader() {
        val cnh: CommonNavHeader = findViewById(R.id.common_nav_header)
        cnh.leftButtonAction = View.OnClickListener { _ ->
            Toast.makeText(this@MainActivity, "Left button clicked!", Toast.LENGTH_LONG).show()
        }
    }

    private fun setupCommonButton() {
        val cb: CommonButton = findViewById(R.id.signup)
        val loader: CommonLoader = findViewById(R.id.common_loader)

        cb.buttonAction = View.OnClickListener { _ ->
            Toast.makeText(this@MainActivity, "SignUp button clicked!", Toast.LENGTH_LONG).show()

            loader.startAnimation()

            Handler().postDelayed({
                loader.stopAnimation()
            }, 3000)
        }
    }
}
