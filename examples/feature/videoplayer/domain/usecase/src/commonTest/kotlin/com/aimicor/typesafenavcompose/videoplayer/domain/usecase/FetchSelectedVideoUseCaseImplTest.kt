package com.aimicor.typesafenavcompose.videoplayer.domain.usecase

import com.aimicor.typesafenavcompose.videoplayer.domain.repository.VideoPlayerRepository
import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRailItem
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FetchSelectedVideoUseCaseImplTest {

    private var repositoryResult: Result<String>? = null

    private val repository = object : VideoPlayerRepository {
        override suspend fun fetchVideoUrl(
            videoId: String
        ): Result<String> = repositoryResult!!
    }

    private val videoRailItem = VideoRailItem(
        id = "test",
        title = "test",
        imgUrl = "test",
        description = "test"
    )

    private val sut by lazy {
        FetchSelectedVideoUseCaseImpl(repository)
    }

    @Test
    fun `GIVEN repository failure WHEN invoke THEN return failure`() = runTest {
        val exception = Exception()
        val failure = Result.failure<String>(exception)
        repositoryResult = failure

        val result = sut(videoRailItem)

        assertTrue(result.isFailure)
        assertEquals(exception, result.exceptionOrNull())
    }

    @Test
    fun `GIVEN repository success WHEN invoke THEN return success`() = runTest {
        val url = "aURL"
        val success = Result.success(url)
        repositoryResult = success

        val result = sut(videoRailItem)

        assertTrue(result.isSuccess)
        assertEquals(videoRailItem, result.getOrNull()!!.video)
        assertEquals(url, result.getOrNull()!!.videoUrl)
    }
}

