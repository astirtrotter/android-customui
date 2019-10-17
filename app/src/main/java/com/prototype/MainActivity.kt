package com.prototype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import com.prototype.customui.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupCommonNavHeader()
        setupCommonButton()
        setupCommonFooter()
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

    private fun setupCommonFooter() {
        val cf: CommonFooterWithTextAndButton = findViewById(R.id.common_footer)
        cf.buttonAction = View.OnClickListener {
            Alert.show(this@MainActivity, "Oops!", "There is no internet connection.", "TRY AGAIN") {
                Toast.makeText(this@MainActivity, "TRY AGAIN clicked", Toast.LENGTH_LONG).show()
            }
        }
    }
}
