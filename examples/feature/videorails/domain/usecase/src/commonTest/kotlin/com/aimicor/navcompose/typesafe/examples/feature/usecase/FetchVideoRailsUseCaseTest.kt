package com.aimicor.navcompose.typesafe.examples.feature.usecase

import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.data.VideoRail
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class FetchVideoRailsUseCaseTest {

    private val listResult = Result.success(emptyList<VideoRail>())
    private val repository = FakeHomeRepository(listResult)

    @Test
    fun test() = runTest {
        val useCase = FetchVideoRailsUseCase(repository)
        assertEquals(listResult, useCase())
    }
}