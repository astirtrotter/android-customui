package com.prototype.customui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.prototype.customui.base._BaseCustomUIComponent

class CommonLoader @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : _BaseCustomUIComponent(context, attrs, defStyleAttr) {

    override val layoutResId: Int
        get() = R.layout.layout_common_loader

    override fun fetchLayout(container: View) {}

    override fun readAttr(attrs: AttributeSet?, defStyle: Int) {}


    fun startAnimation() {
        visibility = View.VISIBLE
    }

    fun stopAnimation() {
        visibility = View.GONE
    }

}