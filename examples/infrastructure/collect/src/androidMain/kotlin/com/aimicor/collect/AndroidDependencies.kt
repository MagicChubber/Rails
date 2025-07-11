package com.aimicor.collect

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val collectAndroidModule = module {
    factoryOf(::CollectFlowAndroid) { bind<CollectFlow>() }
    factoryOf(::CollectStateFlowAndroid){ bind<CollectStateFlow>()}
}