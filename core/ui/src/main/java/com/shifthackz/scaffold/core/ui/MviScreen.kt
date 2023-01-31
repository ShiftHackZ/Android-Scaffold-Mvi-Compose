@file:Suppress("MemberVisibilityCanBePrivate")

package com.shifthackz.scaffold.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

abstract class MviScreen<S: MviState, E: MviEffect>(
    protected val viewModel: MviViewModel<S, E>,
) {

//    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
//        throwable.printStackTrace()
//    }

    @Composable
    fun Build() {
        LaunchedEffect(KEY_EFFECTS_PROCESSOR) {
            viewModel.effectStream.collect(::processEffect)
        }
        Content()
    }

    @Composable
    protected abstract fun Content()

    protected open fun processEffect(effect: E) = Unit

    companion object {
        private const val KEY_EFFECTS_PROCESSOR = "key_effects_processor"
    }
}
