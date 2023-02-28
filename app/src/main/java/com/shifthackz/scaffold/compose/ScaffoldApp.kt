package com.shifthackz.scaffold.compose

import android.app.Application
import com.shifthackz.scaffold.compose.di.providersModule
import com.shifthackz.scaffold.data.di.localDataSourceModule
import com.shifthackz.scaffold.data.di.remoteDataSourceModule
import com.shifthackz.scaffold.data.di.repositoryModule
import com.shifthackz.scaffold.domain.di.domainModule
import com.shifthackz.scaffold.network.di.networkModule
import com.shifthackz.scaffold.presentation.di.viewModelModule
import com.shifthackz.scaffold.storage.di.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ScaffoldApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeKoin()
    }

    private fun initializeKoin() = startKoin {
        androidContext(this@ScaffoldApp)
        modules(
            providersModule,
            remoteDataSourceModule,
            localDataSourceModule,
            repositoryModule,
            domainModule,
            networkModule,
            databaseModule,
            viewModelModule,
        )
    }
}
