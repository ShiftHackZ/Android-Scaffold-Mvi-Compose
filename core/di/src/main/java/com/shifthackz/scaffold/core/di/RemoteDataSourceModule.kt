package com.shifthackz.scaffold.core.di

import com.shifthackz.scaffold.data.datasource.SampleRemoteDataSource
import com.shifthackz.scaffold.domain.datasource.SampleDataSource
import com.shifthackz.scaffold.network.api.SampleApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindSampleRds(rds: SampleRemoteDataSource): SampleDataSource.Remote
}
