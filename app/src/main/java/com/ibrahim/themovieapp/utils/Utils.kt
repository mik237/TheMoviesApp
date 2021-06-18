package com.ibrahim.themovieapp.utils

import android.content.Context
import java.text.SimpleDateFormat
import java.util.*

object Utils {

    fun dpToPx(context: Context, dp: Int): Float = dp * context.resources.displayMetrics.density

    fun getImgWidth(context: Context, margin: Int) : Float{
        val displayMetrics = context.resources.displayMetrics
        val density = displayMetrics.density
        val marginInPx = margin * density * 2
        return (displayMetrics.widthPixels / 2) - marginInPx
    }

    fun getBackdropImgWidth(context: Context, margin: Int) : Float{
        val displayMetrics = context.resources.displayMetrics
        val density = displayMetrics.density
        val marginInPx = margin * density * 2
        return displayMetrics.widthPixels - marginInPx
    }

    fun getImgHeight(context: Context, margin: Int) : Float{
        val displayMetrics = context.resources.displayMetrics
        val density = displayMetrics.density
        val marginInPx = margin * density * 2

        return ((displayMetrics.widthPixels / 3)  * 2.5f) - marginInPx
    }

    fun getBackdropImgHeight(context: Context, margin: Int) : Float{
        val displayMetrics = context.resources.displayMetrics
        val density = displayMetrics.density
        val marginInPx = margin * density * 2
        return (displayMetrics.widthPixels / 2) - marginInPx
    }


    fun formattedDate(inputDate: String) : String{
        val inputPattern = "yyyy-MM-dd"
        val outputPattern = "MMM dd, yyyy"
        val inputFormat = SimpleDateFormat(inputPattern, Locale.getDefault())
//        inputFormat.timeZone = TimeZone.getTimeZone("GMT")
        val outputFormat = SimpleDateFormat(outputPattern, Locale.getDefault())
//        outputFormat.timeZone = TimeZone.getTimeZone("GMT+04:00")

        var formattedDateTime = ""

        try {
            val date = inputFormat.parse(inputDate)
            if (date != null) {
                formattedDateTime = outputFormat.format(date)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return formattedDateTime
    }
}