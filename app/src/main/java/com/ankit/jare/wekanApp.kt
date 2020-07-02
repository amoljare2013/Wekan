package com.ankit.jare

import android.app.Application

class wekanApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

    }

    companion object {
        lateinit var instance: wekanApp
    }

}