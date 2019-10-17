package com.prototype.customui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.prototype.customui.base._BaseCustomUIComponent

class CommonLoginCell @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : _BaseCustomUIComponent(context, attrs, defStyleAttr) {

    override val layoutResId: Int
        get() = R.layout.layout_common_login_cell

    override fun fetchLayout(container: View) {

    }

    override fun readAttr(attrs: AttributeSet?, defStyle: Int) {
    }

}