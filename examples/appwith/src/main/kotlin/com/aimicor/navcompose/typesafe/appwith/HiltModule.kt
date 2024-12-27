package com.aimicor.navcompose.typesafe.appwith

import com.aimicor.navcompose.typesafe.examples.feature.usecase.FetchVideoRailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.aimicor.navcompose.typesafe.examples.feature.videorails.data.invoke
import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.repository.VideoRailsRepository

@InstallIn(SingletonComponent::class)
@Module
class HiltModule {

    @Provides
    fun providesFetchVideoRailsUseCase(): FetchVideoRailsUseCase =
        FetchVideoRailsUseCase(VideoRailsRepository())
}