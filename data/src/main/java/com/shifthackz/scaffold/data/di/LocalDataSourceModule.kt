package com.shifthackz.scaffold.data.di

import com.shifthackz.scaffold.data.local.SampleLocalDataSource
import com.shifthackz.scaffold.domain.datasource.SampleDataSource
import org.koin.dsl.module

val localDataSourceModule = module {
    factory<SampleDataSource.Local> { SampleLocalDataSource(get()) }
}
