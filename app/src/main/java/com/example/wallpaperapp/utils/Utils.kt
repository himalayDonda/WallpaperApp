package com.example.wallpaperapp.utils

import android.content.res.Resources

class Utils {

    companion object{
        fun dpTopPx(px: Int): Int {
            return (px * Resources.getSystem().displayMetrics.density).toInt()
        }

        fun dpTopPx(px: Float): Int {
            return (px * Resources.getSystem().displayMetrics.density).toInt()
        }

        fun shareApp(){

        }
    }
}