package com.shifthackz.scaffold.core.di


import com.shifthackz.scaffold.domain.usecase.SampleUseCase
import com.shifthackz.scaffold.domain.usecase.SampleUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindSampleUseCase(impl: SampleUseCaseImpl): SampleUseCase
}
