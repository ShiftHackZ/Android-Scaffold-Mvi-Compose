package com.shifthackz.scaffold.presentation.screen.loader

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.shifthackz.scaffold.core.ui.MviScreen
import com.shifthackz.scaffold.core.ui.EmptyEffect
import com.shifthackz.scaffold.core.ui.EmptyState

class LoaderScreen(
    viewModel: LoaderViewModel,
    private val toastFn: (String) -> Unit,
) : MviScreen<EmptyState, LoaderEffect>(viewModel) {

    @Composable
    override fun Content() {
        Text("LoaderScreen")
    }

    override fun processEffect(effect: LoaderEffect) {
//        when (effect) {
//            is LoaderEffect.Toast -> toastFn(effect.str)
//        }
    }
}
