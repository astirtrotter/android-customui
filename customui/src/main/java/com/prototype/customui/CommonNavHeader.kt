package com.prototype.customui

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.prototype.customui.base._BaseCustomUIComponent

class CommonNavHeader @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : _BaseCustomUIComponent(context, attrs, defStyleAttr) {

    override val layoutResId: Int
        get() = R.layout.layout_common_nav_header

    var headerText: String? = null
        set(value) {
            field = value
            setVisibilityWithValue(header, value)
            header.text = value
        }
    var leftButtonIsEnabled: Boolean = true
        set(value) {
            field = value
            leftButton.isEnabled = value
        }
    var rightButtonIsEnabled: Boolean = true
        set(value) {
            field = value
            rightButton.isEnabled = value
        }
    var leftButtonImage: Drawable? = null
        set(value) {
            field = value
            leftImage.setImageDrawable(value)
            setVisibilityWithValue(leftImage, value)
        }
    var rightButtonImage: Drawable? = null
        set(value) {
            field = value
            rightImage.setImageDrawable(value)
            setVisibilityWithValue(rightImage, value)
        }
    var leftButtonText: String? = null
        set(value) {
            field = value
            leftText.text = value
            if (leftButtonImage != null) {
                leftText.visibility = View.GONE
            } else {
                setVisibilityWithValue(leftText, value)
            }
        }
    var rightButtonText: String? = null
        set(value) {
            field = value
            rightText.text = value
            if (rightButtonImage != null) {
                rightText.visibility = View.GONE
            } else {
                setVisibilityWithValue(rightText, value)
            }
        }
    var leftButtonAction: OnClickListener? = null
        set(value) {
            field = value
            leftButton.setOnClickListener(value)
        }
    var rightButtonAction: OnClickListener? = null
        set(value) {
            field = value
            rightButton.setOnClickListener(value)
        }

    private lateinit var header: TextView
    private lateinit var leftButton: ViewGroup
    private lateinit var leftImage: ImageView
    private lateinit var leftText: TextView
    private lateinit var rightButton: ViewGroup
    private lateinit var rightImage: ImageView
    private lateinit var rightText: TextView

    override fun fetchLayout(container: View) {
        header = container.findViewById(R.id.nav_text_header)
        leftButton = container.findViewById(R.id.nav_button_left)
        leftImage = container.findViewById(R.id.nav_image_left)
        leftText = container.findViewById(R.id.nav_text_left)
        rightButton = container.findViewById(R.id.nav_button_right)
        rightImage = container.findViewById(R.id.nav_image_right)
        rightText = container.findViewById(R.id.nav_text_right)
    }

    override fun readAttr(attrs: AttributeSet?, defStyle: Int) {
        // Load attributes
        val a = context.obtainStyledAttributes(
            attrs, R.styleable.CommonNavHeader, defStyle, 0
        )

        headerText = a.getString(R.styleable.CommonNavHeader_headerText)
        leftButtonIsEnabled = a.getBoolean(R.styleable.CommonNavHeader_leftButtonIsEnabled, true)
        leftButtonImage = a.getDrawable(R.styleable.CommonNavHeader_leftButtonImage)
        leftButtonText = a.getString(R.styleable.CommonNavHeader_leftButtonText)
        rightButtonIsEnabled = a.getBoolean(R.styleable.CommonNavHeader_rightButtonIsEnabled, true)
        rightButtonImage = a.getDrawable(R.styleable.CommonNavHeader_rightButtonImage)
        rightButtonText = a.getString(R.styleable.CommonNavHeader_rightButtonText)

        a.recycle()
    }

    private fun setVisibilityWithValue(view: View, value: Any?) {
        view.visibility = View.VISIBLE.takeIf { value != null } ?: View.GONE
    }
}
