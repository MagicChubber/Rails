package com.aimicor.navcompose.typesafe

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.aimicor.navcompose.typesafe.dependencies.dependencies
import com.aimicor.collect.collectAndroidModule

class VideoApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@VideoApplication)
            dependencies()
            allowOverride(true)
            modules(collectAndroidModule)
        }
    }
}
