package com.aimicor.navcompose.typesafe

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import com.aimicor.navcompose.typesafe.dependencies.dependencies
import org.koin.dsl.module

fun initKoin(
    appDeclaration: KoinAppDeclaration = {},
    moduleOverrides: Module = module {}
) = startKoin {
    appDeclaration()
    dependencies()
    modules(moduleOverrides)
}

// Special helper for iOS initialization
fun initKoinIos() = initKoin()
