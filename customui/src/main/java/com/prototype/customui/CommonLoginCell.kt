package com.prototype.customui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.InputType
import android.text.TextPaint
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.prototype.customui.base._BaseCustomUIComponent

class CommonLoginCell @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : _BaseCustomUIComponent(context, attrs, defStyleAttr) {

    override val layoutResId: Int
        get() = R.layout.layout_common_login_cell

    var hintText: String? = ""
        set(value) {
            field = value
            label.text = value
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

        input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                setLabelVisibility()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        input.setOnFocusChangeListener { v, hasFocus -> setLabelVisibility() }
    }

    override fun readAttr(attrs: AttributeSet?, defStyle: Int) {
        val a = context.obtainStyledAttributes(
            attrs, R.styleable.CommonLoginCell, defStyle, 0
        )

        hintText = a.getString(R.styleable.CommonLoginCell_hintText)
        warningText = a.getString(R.styleable.CommonLoginCell_warningText)
        isPassword = a.getBoolean(R.styleable.CommonLoginCell_isPassword, false)

        a.recycle()
    }

    private fun setLabelVisibility() {
        label.visibility = View.VISIBLE.takeIf {
            input.text.isNotEmpty()
        } ?: View.INVISIBLE
    }

}