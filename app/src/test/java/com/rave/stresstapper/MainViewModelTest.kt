package com.rave.stresstapper

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class MainViewModelTest {

    private val mainViewModel = MainViewModel()

    @Test
    @DisplayName("Test that the count increments twice when method is called twice")
    fun testIncrement() {
        // Given

        // When
        mainViewModel.increment()
        mainViewModel.increment()

        // Then
        Assertions.assertEquals(2, mainViewModel.result.value)
    }

    @Test
    @DisplayName("Test that the count resets to 0 when reset is called")
    fun testReset() {
        // Given

        // When
        mainViewModel.increment()
        mainViewModel.increment()
        mainViewModel.reset()

        // Then
        Assertions.assertEquals(0, mainViewModel.result.value)
    }
}