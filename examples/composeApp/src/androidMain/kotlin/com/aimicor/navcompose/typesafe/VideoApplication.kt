package com.aimicor.navcompose.typesafe

import android.app.Application
import com.aimicor.collect.collectAndroidModule
import org.koin.android.ext.koin.androidContext

class VideoApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        initKoin(
            appDeclaration = { androidContext(this@VideoApplication) },
            moduleOverrides = collectAndroidModule
        )
    }
}
