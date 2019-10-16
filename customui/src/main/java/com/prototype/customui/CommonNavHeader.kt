package com.prototype.customui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView

class CommonNavHeader : View {

    var leftButtonIsEnabled: Boolean = true
    var rightButtonIsEnabled: Boolean = true
    var leftButtonText: String? = "Left"
    var rightButtonText: String? = "Right"
    var headerText: String? = "Header"
    var leftButtonAction: (() -> Unit)? = null
    var rightButtonAction: (() -> Unit)? = null
    lateinit var leftButton: ImageView
    lateinit var rightButton: ImageView

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        // Load attributes
        val a = context.obtainStyledAttributes(
            attrs, R.styleable.CommonNavHeader, defStyle, 0
        )

//        _exampleString = a.getString(
//            R.styleable.CommonNavHeader_exampleString
//        )
//        _exampleColor = a.getColor(
//            R.styleable.CommonNavHeader_exampleColor,
//            exampleColor
//        )
//        // Use getDimensionPixelSize or getDimensionPixelOffset when dealing with
//        // values that should fall on pixel boundaries.
//        _exampleDimension = a.getDimension(
//            R.styleable.CommonNavHeader_exampleDimension,
//            exampleDimension
//        )
//
//        if (a.hasValue(R.styleable.CommonNavHeader_exampleDrawable)) {
//            exampleDrawable = a.getDrawable(
//                R.styleable.CommonNavHeader_exampleDrawable
//            )
//            exampleDrawable?.callback = this
//        }

        a.recycle()
    }
}
