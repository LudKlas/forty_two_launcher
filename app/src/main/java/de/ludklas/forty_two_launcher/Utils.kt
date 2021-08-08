package de.ludklas.forty_two_launcher

import android.content.Context

fun getStatusBarHeight(context: Context): Int {
    val res = context.resources
    return res.getDimensionPixelSize(res.getIdentifier("status_bar_height", "dimen", "android"))
}