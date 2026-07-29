package com.aimicor.navcompose.typesafe.android

import android.app.Application
import com.aimicor.collect.collectAndroidModule
import com.aimicor.navcompose.typesafe.initKoin
import org.koin.android.ext.koin.androidContext

class VideoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(
            appDeclaration = { androidContext(this@VideoApplication) },
            moduleOverrides = collectAndroidModule
        )
    }
}
