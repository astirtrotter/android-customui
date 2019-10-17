package com.prototype.customui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import com.prototype.customui.base._BaseCustomUIComponent

class CommonHeader @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : _BaseCustomUIComponent(context, attrs, defStyleAttr) {

    override val layoutResId: Int
        get() = R.layout.layout_common_header

    var titleText: String = ""
        set(value) {
            field = value
            title.text = value
        }
    var subTitleText: String? = null
        set(value) {
            field = value
            subTitle.text = value
            setVisibilityWithValue(subTitle, value)
        }
    var titleColor: Int = 0
        set(value) {
            field = value
            title.setTextColor(value)
        }
    var subTitleColor: Int = 0
        set(value) {
            field = value
            subTitle.setTextColor(value)
        }
    var titleAlignment: Int = View.TEXT_ALIGNMENT_INHERIT
        set(value) {
            field = value
            title.textAlignment = value
        }
    var subTitleAlignment: Int = View.TEXT_ALIGNMENT_INHERIT
        set(value) {
            field = value
            subTitle.textAlignment = value
        }

    private lateinit var title: TextView
    private lateinit var subTitle: TextView

    override fun fetchLayout(container: View) {
        title = container.findViewById(R.id.header_title)
        subTitle = container.findViewById(R.id.header_subtitle)
    }

    override fun readAttr(attrs: AttributeSet?, defStyle: Int) {
        val a = context.obtainStyledAttributes(
            attrs, R.styleable.CommonHeader, defStyle, 0
        )

        titleText = a.getString(R.styleable.CommonHeader_titleText) ?: titleText
        subTitleText = a.getString(R.styleable.CommonHeader_subTitleText)
        titleColor = a.getColor(R.styleable.CommonHeader_titleColor, titleColor)
        subTitleColor = a.getColor(R.styleable.CommonHeader_subTitleColor, subTitleColor)
        titleAlignment = a.getInt(R.styleable.CommonHeader_titleAlignment, titleAlignment)
        subTitleAlignment = a.getInt(R.styleable.CommonHeader_subTitleAlignment, subTitleAlignment)

        a.recycle()
    }

}