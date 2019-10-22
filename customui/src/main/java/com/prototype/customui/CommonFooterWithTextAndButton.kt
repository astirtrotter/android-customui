package com.prototype.customui

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import com.prototype.customui.base._BaseCustomUIComponent

class CommonFooterWithTextAndButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : _BaseCustomUIComponent(context, attrs, defStyleAttr) {

    override val layoutResId: Int
        get() = R.layout.layout_common_footer_with_text_and_button

    var labelText: String? = ""
        set(value) {
            field = value
            label.text = value
        }
    var buttonText: String? = ""
        set(value) {
            field = value
            button.text = value
        }
    var labelTextColor: Int = Color.BLACK
        set(value) {
            field = value
            label.setTextColor(value)
        }
    var buttonTextColor: Int = Color.RED
        set(value) {
            field = value
            button.setTextColor(value)
        }
    var buttonAction: OnClickListener? = null
        set(value) {
            field = value
            button.setOnClickListener(value)
        }

    private lateinit var label: TextView
    private lateinit var button: TextView

    override fun fetchLayout(container: View) {
        label = container.findViewById(R.id.footer_label)
        button = container.findViewById(R.id.footer_button)
    }

    override fun readAttr(attrs: AttributeSet?, defStyle: Int) {
        val a = context.obtainStyledAttributes(
            attrs, R.styleable.CommonFooterWithTextAndButton, defStyle, 0
        )

        labelText = a.getString(R.styleable.CommonFooterWithTextAndButton_labelText)
        buttonText = a.getString(R.styleable.CommonFooterWithTextAndButton_buttonText)
        labelTextColor = a.getColor(R.styleable.CommonFooterWithTextAndButton_labelTextColor, Color.BLACK)
        buttonTextColor = a.getColor(R.styleable.CommonFooterWithTextAndButton_buttonTextColor, Color.RED)

        a.recycle()
    }

}