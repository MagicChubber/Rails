package com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.state

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val videoRailsStateModule = module {
    viewModelOf(::VideoRailsViewModel) { bind<VideoRailsUniflow>() }
}