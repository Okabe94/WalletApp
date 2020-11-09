package com.example.walletapp.ui.widgets.edittext

import android.R
import android.content.Context
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.View.OnTouchListener
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.res.ResourcesCompat
import com.example.walletapp.utils.textwatcher.TextWatcherImpl


class SearchEditText : AppCompatEditText,
    OnTouchListener, OnFocusChangeListener {

    private var endDrawable: Drawable? = null
    private var listener: Listener? = null
    private var l: OnTouchListener? = null
    private var f: OnFocusChangeListener? = null

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init()
    }

    private fun init() {
        endDrawable = ResourcesCompat.getDrawable(
            resources,
            R.drawable.presence_offline,
            null
        ).also {
            it?.setBounds(
                0,
                0,
                it.intrinsicWidth,
                it.intrinsicHeight
            )
        }

        ResourcesCompat.getDrawable(
            resources,
            R.drawable.ic_menu_search,
            null
        )?.let {
            it.setBounds(
                0,
                0,
                it.intrinsicWidth,
                it.intrinsicHeight
            )
        }

        setClearIconVisible(false)
        super.setOnTouchListener(this)
        super.setOnFocusChangeListener(this)
        addTextChangedListener(
            object : TextWatcherImpl() {
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (isFocused) setClearIconVisible(!TextUtils.isEmpty(text))
                }
            })
    }

    override fun setOnTouchListener(l: OnTouchListener) {
        this.l = l
    }

    override fun setOnFocusChangeListener(f: OnFocusChangeListener) {
        this.f = f
    }

    override fun onTouch(v: View?, event: MotionEvent): Boolean {
        compoundDrawables[2]?.let {
            if (event.x > width - paddingRight - (endDrawable?.intrinsicWidth ?: 0)) {
                if (event.action == MotionEvent.ACTION_UP) {
                    setText("")
                    if (listener != null) listener!!.didClearText()
                }
                return true
            }
        }
        return if (l != null) l!!.onTouch(v, event)
        else false
    }

    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        if (hasFocus) setClearIconVisible(!TextUtils.isEmpty(text))
        else setClearIconVisible(false)
        f?.onFocusChange(v, hasFocus)
    }

    private fun setClearIconVisible(visible: Boolean) {
        val x = if (visible) endDrawable else null
        setCompoundDrawables(
            compoundDrawables[0],
            compoundDrawables[1],
            x,
            compoundDrawables[3]
        )
    }

    interface Listener {
        fun didClearText()
    }
}