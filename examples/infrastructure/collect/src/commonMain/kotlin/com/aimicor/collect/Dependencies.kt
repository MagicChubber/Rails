package com.aimicor.collect

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val collectCommonModule = module {
    factoryOf(::CollectFlowCommon) { bind<CollectFlow>() }
    factoryOf(::CollectStateFlowCommon){ bind<CollectStateFlow>()}
}
