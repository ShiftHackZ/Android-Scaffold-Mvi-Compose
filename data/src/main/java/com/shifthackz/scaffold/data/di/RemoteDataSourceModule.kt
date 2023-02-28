package com.shifthackz.scaffold.data.di

import com.shifthackz.scaffold.data.remote.SampleRemoteDataSource
import com.shifthackz.scaffold.domain.datasource.SampleDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    factory<SampleDataSource.Remote> { SampleRemoteDataSource(get()) }
}
