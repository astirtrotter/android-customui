package com.prototype.customui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.InputType
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import com.prototype.customui.base._BaseCustomUIComponent

class CommonLoginCell @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : _BaseCustomUIComponent(context, attrs, defStyleAttr) {

    override val layoutResId: Int
        get() = R.layout.layout_common_login_cell

    var labelText: String = ""
        set(value) {
            field = value
            label.text = value
        }
    var hintText: String? = ""
        set(value) {
            field = value
            input.hint = value
        }
    var warningText: String? = null
        set(value) {
            field = value
            warning.text = value
            setVisibilityWithValue(warning, value)
        }
    var isPassword: Boolean = false
        set(value) {
            field = value
            input.inputType = InputType.TYPE_CLASS_TEXT.or(InputType.TYPE_TEXT_VARIATION_PASSWORD.takeIf { value } ?: 0)
        }

    private lateinit var label: TextView
    private lateinit var input: EditText
    private lateinit var warning: TextView

    override fun fetchLayout(container: View) {
        label = container.findViewById(R.id.login_label)
        input = container.findViewById(R.id.login_input)
        warning = container.findViewById(R.id.login_warning)
    }

    override fun readAttr(attrs: AttributeSet?, defStyle: Int) {
        val a = context.obtainStyledAttributes(
            attrs, R.styleable.CommonLoginCell, defStyle, 0
        )

        labelText = a.getString(R.styleable.CommonLoginCell_labelText) ?: "Label"
        hintText = a.getString(R.styleable.CommonLoginCell_hintText)
        warningText = a.getString(R.styleable.CommonLoginCell_warningText)
        isPassword = a.getBoolean(R.styleable.CommonLoginCell_isPassword, false)

        a.recycle()
    }

}