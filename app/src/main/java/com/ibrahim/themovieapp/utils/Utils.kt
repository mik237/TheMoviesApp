package com.ibrahim.themovieapp.utils

import android.content.Context

object Utils {

    fun dpToPx(context: Context, dp: Int): Float = dp * context.resources.displayMetrics.density

    fun getImgWidth(context: Context, margin: Int) : Float{
        val displayMetrics = context.resources.displayMetrics
        val density = displayMetrics.density
        val marginInPx = margin * density * 2
        return (displayMetrics.widthPixels / 2) - marginInPx
    }

    fun getImgHeight(context: Context, margin: Int) : Float{
        val displayMetrics = context.resources.displayMetrics
        val density = displayMetrics.density
        val marginInPx = margin * density * 2

        return ((displayMetrics.widthPixels / 3)  * 2.5f) - marginInPx
    }
}