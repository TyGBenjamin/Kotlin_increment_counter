package com.rave.stresstapper

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {

    private val _result = MutableStateFlow(0)
    val result: StateFlow<Int> get() = _result

    fun increment() {
        _result.value++
    }

    fun reset() {
        _result.value = 0
    }
}