package com.shifthackz.scaffold.network.di

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.shifthackz.scaffold.network.ApiUrlProvider
import com.shifthackz.scaffold.network.BuildConfig
import com.shifthackz.scaffold.network.api.SampleApi
import com.shifthackz.scaffold.network.extensions.withBaseUrl
import com.shifthackz.scaffold.network.qualifiers.RetrofitCallAdapters
import com.shifthackz.scaffold.network.qualifiers.HttpInterceptor
import com.shifthackz.scaffold.network.qualifiers.NetworkInterceptor
import com.shifthackz.scaffold.network.qualifiers.RetrofitConverterFactories
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single<Gson> { GsonBuilder().create() }

    single {
        RetrofitConverterFactories(
            buildList {
                add(GsonConverterFactory.create(get()))
            }
        )
    }

    single {
        RetrofitCallAdapters(
            buildList {

            }
        )
    }

    single<List<HttpInterceptor>> {
        buildList {
            if (BuildConfig.DEBUG) {
                val loggingInterceptor = HttpLoggingInterceptor { message ->
                    Log.d("HTTP", message)
                }.apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
                add(HttpInterceptor(loggingInterceptor))
            }
        }
    }

    single<List<NetworkInterceptor>> { buildList { } }

    single {
        OkHttpClient
            .Builder()
            .apply {
                get<List<HttpInterceptor>>().forEach(::addInterceptor)
                get<List<NetworkInterceptor>>().forEach(::addNetworkInterceptor)
            }
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    single<Retrofit.Builder> {
        Retrofit
            .Builder()
            .client(get())
            .apply {
                get<RetrofitConverterFactories>().data.forEach(::addConverterFactory)
                get<RetrofitCallAdapters>().data.forEach(::addCallAdapterFactory)
            }
            .addConverterFactory(GsonConverterFactory.create())
    }

    single {
        get<Retrofit.Builder>()
            .withBaseUrl(get<ApiUrlProvider>().apiUrl)
            .create(SampleApi::class.java)
    }
}
