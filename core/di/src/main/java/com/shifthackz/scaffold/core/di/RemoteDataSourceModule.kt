package com.shifthackz.scaffold.core.di

import com.shifthackz.scaffold.data.remote.SampleRemoteDataSource
import com.shifthackz.scaffold.domain.datasource.SampleDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindSampleRds(rds: SampleRemoteDataSource): SampleDataSource.Remote
}
