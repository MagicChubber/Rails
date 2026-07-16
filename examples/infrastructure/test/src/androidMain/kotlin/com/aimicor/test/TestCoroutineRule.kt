package com.aimicor.test

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class TestCoroutineRule : TestWatcher() {

    @ExperimentalCoroutinesApi
    private val testDispatcher = UnconfinedTestDispatcher(TestCoroutineScheduler())

    @ExperimentalCoroutinesApi
    override fun starting(description: Description) {
        super.starting(description)
        Dispatchers.setMain(testDispatcher)
    }

    @ExperimentalCoroutinesApi
    override fun finished(description: Description) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}