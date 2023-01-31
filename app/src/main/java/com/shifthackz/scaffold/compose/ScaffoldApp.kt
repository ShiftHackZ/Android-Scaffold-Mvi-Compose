package com.shifthackz.scaffold.compose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ScaffoldApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}
