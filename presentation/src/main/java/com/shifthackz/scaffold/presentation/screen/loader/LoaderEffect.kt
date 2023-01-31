package com.shifthackz.scaffold.presentation.screen.loader

import com.shifthackz.scaffold.core.ui.MviEffect

sealed class LoaderEffect : MviEffect {
    data class Toast(val str: String) : LoaderEffect()
}
