package com.shifthackz.scaffold.domain.di

import com.shifthackz.scaffold.domain.usecase.SampleUseCase
import com.shifthackz.scaffold.domain.usecase.SampleUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<SampleUseCase> { SampleUseCaseImpl(get()) }
}
