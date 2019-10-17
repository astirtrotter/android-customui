package com.prototype.customui

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import com.prototype.customui.base._BaseCustomUIComponent

class CommonButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : _BaseCustomUIComponent(context, attrs, defStyleAttr) {

    override val layoutResId: Int
        get() = R.layout.layout_common_button

    var enabledColor: Int = 0
        set(value) {
            field = value
            setButtonColor()
        }
    var disabledColor: Int = 0
        set(value) {
            field = value
            setButtonColor()
        }
    var displayText: String? = ""
        set(value) {
            field = value
            display.text = displayText
        }
    var textColor: Int = Color.WHITE
        set(value) {
            field = value
            display.setTextColor(value)
        }
    var buttonAction: OnClickListener? = null
        set(value) {
            field = value
            (display.parent as View).setOnClickListener(value)
        }

    private lateinit var display: TextView

    override fun fetchLayout(container: View) {
        display = container.findViewById(R.id.button_text)
    }

    override fun readAttr(attrs: AttributeSet?, defStyle: Int) {
        val a = context.obtainStyledAttributes(
            attrs, R.styleable.CommonButton, defStyle, 0
        )

        enabledColor = a.getColor(R.styleable.CommonButton_enabledButtonColor, Color.RED)
        disabledColor = a.getColor(R.styleable.CommonButton_disabledButtonColor, Color.GRAY)
        displayText = a.getString(R.styleable.CommonButton_displayText)
        textColor = a.getColor(R.styleable.CommonButton_textColor, Color.WHITE)

        a.recycle()

    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        setButtonColor()
    }

    private fun setButtonColor() {
        setBackgroundColor(enabledColor.takeIf { isEnabled } ?: disabledColor)
    }

}