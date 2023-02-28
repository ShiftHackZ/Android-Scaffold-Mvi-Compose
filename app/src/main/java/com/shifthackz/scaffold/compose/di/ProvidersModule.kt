package com.shifthackz.scaffold.compose.di

import com.shifthackz.scaffold.network.ApiUrlProvider
import org.koin.dsl.module

val providersModule = module {
    single<ApiUrlProvider> {
        object : ApiUrlProvider {
            override val apiUrl: String = "https://127.0.0.1"
        }
    }
}
