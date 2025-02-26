package com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.usecase

import com.aimicor.navcompose.typesafe.examples.feature.usecase.FakeHomeRepository
import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.entity.VideoRail
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class FetchVideoRailsUseCaseTest {

    private val listResult = Result.success(emptyList<VideoRail>())
    private val repository = FakeHomeRepository(listResult)

    @Test
    fun test() = runTest {
        val useCase = FetchVideoRailsUseCaseImpl(repository)
        assertEquals(listResult, useCase())
    }
}