package com.prototype.customui

import android.content.Context
import android.graphics.PorterDuff
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.TextView
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
            configInput()
        }
    var isPassword: Boolean = false
        set(value) {
            field = value
            input.inputType = InputType.TYPE_CLASS_TEXT.or(InputType.TYPE_TEXT_VARIATION_PASSWORD.takeIf { value } ?: 0)
        }
    var text: String
        get() = input.text.toString()
        set(value) = input.setText(value)
    var validator: ((String) -> String?)? = null

    private lateinit var label: TextView
    private lateinit var input: EditText
    private lateinit var warning: TextView

    override fun fetchLayout(container: View) {
        label = container.findViewById(R.id.login_label)
        input = container.findViewById(R.id.login_input)
        warning = container.findViewById(R.id.login_warning)

        input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                validator?.let { warningText = it(text) } ?: configInput()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        input.setOnFocusChangeListener { v, hasFocus -> configInput() }
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

    private fun configInput() {
        label.visibility = View.VISIBLE.takeIf {
            text.isNotEmpty()
        } ?: View.INVISIBLE

        val color = if (warningText?.isNotEmpty() ?: false) {
            resources.getColor(R.color.login_warning)
        } else if (text.isBlank()) {
            resources.getColor(R.color.login_empty)
        } else {
            resources.getColor(R.color.login_success)
        }

        input.background.mutate().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }

}