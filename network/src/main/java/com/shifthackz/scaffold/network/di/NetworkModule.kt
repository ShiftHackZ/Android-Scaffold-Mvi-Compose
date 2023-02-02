package com.shifthackz.scaffold.network.di

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.shifthackz.scaffold.network.BuildConfig
import com.shifthackz.scaffold.network.api.SampleApi
import com.shifthackz.scaffold.network.extensions.withBaseUrl
import com.shifthackz.scaffold.network.qualifiers.RetrofitCallAdapters
import com.shifthackz.scaffold.network.qualifiers.HttpInterceptor
import com.shifthackz.scaffold.network.qualifiers.NetworkInterceptor
import com.shifthackz.scaffold.network.qualifiers.RetrofitConverterFactories
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideConverterFactories(gson: Gson): RetrofitConverterFactories =
        RetrofitConverterFactories(
            buildList {
                add(GsonConverterFactory.create(gson))
            }
        )

    @Provides
    @Singleton
    fun provideCallAdapterFactories(): RetrofitCallAdapters = RetrofitCallAdapters(
        buildList {

        }
    )

    @Provides
    @Singleton
    fun provideHttpInterceptors(): List<HttpInterceptor> = buildList {
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor { message ->
                Log.d("HTTP", message)
            }.apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            add(HttpInterceptor(loggingInterceptor))
        }
    }

    @Provides
    @Singleton
    fun provideNetworkInterceptors(): List<NetworkInterceptor> = buildList { }

    @Provides
    @Singleton
    fun provideHttpClient(
        httpInterceptors: List<HttpInterceptor>,
        networkInterceptors: List<NetworkInterceptor>,
    ): OkHttpClient = OkHttpClient
        .Builder()
        .apply {
            httpInterceptors.forEach(::addInterceptor)
            networkInterceptors.forEach(::addNetworkInterceptor)
        }
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    fun provideRetrofitBuilder(
        converterFactories: RetrofitConverterFactories,
        callAdapterFactories: RetrofitCallAdapters,
        httpClient: OkHttpClient,
    ): Retrofit.Builder = Retrofit
        .Builder()
        .client(httpClient)
        .apply {
            converterFactories.data.forEach(::addConverterFactory)
            callAdapterFactories.data.forEach(::addCallAdapterFactory)
        }
        .addConverterFactory(GsonConverterFactory.create())

    @Provides
    @Singleton
    fun provideSampleApi(builder: Retrofit.Builder): SampleApi = builder
        .withBaseUrl("http://127.0.0.1")
        .create(SampleApi::class.java)
}
