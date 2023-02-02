package com.shifthackz.scaffold.core.di

import com.shifthackz.scaffold.data.repository.SampleRepositoryImpl
import com.shifthackz.scaffold.domain.datasource.SampleDataSource
import com.shifthackz.scaffold.domain.repository.SampleRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindSampleRepository(impl: SampleRepositoryImpl): SampleRepository
}
