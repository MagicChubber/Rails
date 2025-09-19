package com.aimicor.typesafenavcompose.videorails.domain.usecase

import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRail
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