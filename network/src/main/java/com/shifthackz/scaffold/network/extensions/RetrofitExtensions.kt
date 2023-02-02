package com.shifthackz.scaffold.network.extensions

import retrofit2.Retrofit

fun Retrofit.Builder.withBaseUrl(baseUrl: String): Retrofit = this
    .baseUrl(baseUrl)
    .build()
