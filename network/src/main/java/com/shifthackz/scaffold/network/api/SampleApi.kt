package com.shifthackz.scaffold.network.api

import retrofit2.http.GET

interface SampleApi {

    @GET("/endpoint")
    fun fetch()
}
