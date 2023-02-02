package com.shifthackz.scaffold.core.di

import com.shifthackz.scaffold.data.local.SampleLocalDataSource
import com.shifthackz.scaffold.domain.datasource.SampleDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    abstract fun bindSampleLds(lds: SampleLocalDataSource): SampleDataSource.Local
}
