package com.example.wallpaperapp.base

import android.app.Application
import android.content.Context

class BaseApplication: Application() {

    init {
        instance = this
    }

    companion object{
        private var instance: BaseApplication? = null

        fun getApplicationContext(): Context {
            return instance?.applicationContext!!
        }
    }
}