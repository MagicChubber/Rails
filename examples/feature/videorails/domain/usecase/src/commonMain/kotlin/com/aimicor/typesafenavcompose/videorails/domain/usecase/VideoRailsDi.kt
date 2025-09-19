package com.aimicor.typesafenavcompose.videorails.domain.usecase

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val videoRailsUseCaseModule = module {
    factoryOf(::FetchVideoRailsUseCaseImpl) { bind<FetchVideoRailsUseCase>() }
}