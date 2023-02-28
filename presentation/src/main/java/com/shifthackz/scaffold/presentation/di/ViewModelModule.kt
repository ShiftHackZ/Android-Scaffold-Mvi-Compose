package com.shifthackz.scaffold.presentation.di

import com.shifthackz.scaffold.presentation.screen.loader.LoaderViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoaderViewModel(get()) }
}
