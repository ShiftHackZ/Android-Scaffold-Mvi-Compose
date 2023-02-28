package com.shifthackz.scaffold.data.di

import com.shifthackz.scaffold.data.repository.SampleRepositoryImpl
import com.shifthackz.scaffold.domain.repository.SampleRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<SampleRepository> { SampleRepositoryImpl(get()) }
}
