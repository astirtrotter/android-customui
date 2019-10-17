package com.prototype

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.prototype.customui.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupCommonNavHeader()
        setupLoginListView()
        setupCommonButton()
        setupCommonFooter()
    }

    private fun setupCommonNavHeader() {
        val cnh: CommonNavHeader = findViewById(R.id.common_nav_header)
        cnh.leftButtonAction = View.OnClickListener { _ ->
            val cb: CommonButton = findViewById(R.id.signup)
            cb.isEnabled = true
        }
        cnh.rightButtonAction = View.OnClickListener { _ ->
            val cb: CommonButton = findViewById(R.id.signup)
            cb.isEnabled = false
        }
    }

    private fun setupLoginListView() {
        val llv: ListView = findViewById(R.id.login_listview)
        llv.adapter = LoginListViewAdapter(arrayOf(
            LoginCellModel("Email"),
            LoginCellModel("Password", true, "warning text"),
            LoginCellModel("Re-enter Password", true)
        ))
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

    inner class LoginListViewAdapter(private val data: Array<LoginCellModel>) : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            return convertView ?: CommonLoginCell(this@MainActivity).apply {
                val item = getItem(position)
                hintText = item.hintText
                isPassword = item.isPassword
                warningText = item.warningText
            }
        }

        override fun getItem(position: Int) = data[position]

        override fun getItemId(position: Int) = position.toLong()

        override fun getCount() = data.size

    }

    data class LoginCellModel(
        val hintText: String? = null,
        val isPassword: Boolean = false,
        val warningText: String? = null)

}
