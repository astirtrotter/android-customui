package com.prototype.customui.base

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout

abstract class _BaseCustomUIComponent : RelativeLayout {

    abstract protected val layoutResId: Int

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        fetchLayout(inflateLayout())
        readAttr(attrs, defStyle)
    }

    abstract protected fun fetchLayout(container: View)

    abstract protected fun readAttr(attrs: AttributeSet?, defStyle: Int)

    private fun inflateLayout(): View {
        return View.inflate(context, layoutResId, this)
    }

    protected fun setVisibilityWithValue(view: View, value: Any?) {
        view.visibility = View.VISIBLE.takeIf { value != null } ?: View.GONE
    }
}