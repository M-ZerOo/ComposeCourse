package com.melfouly.composecourse.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.melfouly.composecourse.SaveInfoArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SaveInfoViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _state = MutableStateFlow("")
    val state: StateFlow<String> = _state.asStateFlow()

    private val args: SaveInfoArgs = SaveInfoArgs(savedStateHandle)

    init {
        dataSavedSuccessfully()
    }

    fun dataSavedSuccessfully() {
        _state.update { "Congrats ${args.firstName}, Data saved successfully." }
    }
}