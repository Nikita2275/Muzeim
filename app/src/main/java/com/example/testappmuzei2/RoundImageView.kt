package com.example.testappmuzei2

import android.content.Context
import android.graphics.Outline
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import android.view.View
import android.view.ViewOutlineProvider
import androidx.core.content.ContextCompat

class RoundImageView : AppCompatImageView {

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        clipToOutline = true
        val radius = resources.getDimensionPixelSize(R.dimen.rounded_corner_radius)
        outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline) {
                outline.setRoundRect(0, 0, view.width, view.height, radius.toFloat())
            }
        }

        // Добавление тени
        val shadowColor = ContextCompat.getColor(context, R.color.shadow_color)
        val shadowRadius = resources.getDimensionPixelSize(R.dimen.shadow_radius)
        val shadowOffset = resources.getDimensionPixelSize(R.dimen.shadow_offset)
        elevation = shadowRadius.toFloat()
        translationZ = shadowOffset.toFloat()
        setBackgroundColor(shadowColor)
    }
}