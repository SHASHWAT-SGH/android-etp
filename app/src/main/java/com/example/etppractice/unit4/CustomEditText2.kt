package com.example.etppractice.unit4

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import android.graphics.drawable.GradientDrawable


class CustomEditText2 @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.editTextStyle
) : AppCompatEditText(context, attrs, defStyleAttr) {

    init {
        setup()
    }

    private fun setup() {
        // Set padding and text properties
        setPadding(32, 24, 32, 24)
        setTextColor(Color.BLACK)
        setHintTextColor(Color.RED)
        textSize = 16f

        // Apply a rounded background
        background = GradientDrawable().apply {
            setColor(Color.WHITE)
            cornerRadius = 20f
            setStroke(2, Color.LTGRAY)
            }
        }
}