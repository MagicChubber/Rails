package com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.usecase

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val videoRailsUseCaseModule = module {
    singleOf(::FetchVideoRailsUseCaseImpl) { bind<FetchVideoRailsUseCase>() }
}