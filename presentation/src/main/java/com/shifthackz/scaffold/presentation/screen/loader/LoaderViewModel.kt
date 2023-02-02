package com.shifthackz.scaffold.presentation.screen.loader

import androidx.lifecycle.viewModelScope
import com.shifthackz.scaffold.core.ui.EmptyState
import com.shifthackz.scaffold.core.ui.MviViewModel
import com.shifthackz.scaffold.domain.usecase.SampleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoaderViewModel @Inject constructor(
    private val sampleUseCase: SampleUseCase,
) : MviViewModel<EmptyState, LoaderEffect>() {

    override val emptyState: EmptyState = EmptyState

    init {
        viewModelScope.launch {
            while (true) {
                emitEffect(LoaderEffect.Toast(System.currentTimeMillis().toString()))
                delay(100)
            }
        }
    }
}
