package com.shifthackz.scaffold.presentation.screen.loader

import androidx.lifecycle.viewModelScope
import com.shifthackz.scaffold.core.ui.EmptyState
import com.shifthackz.scaffold.core.ui.MviViewModel
import com.shifthackz.scaffold.domain.usecase.SampleUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoaderViewModel(
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
