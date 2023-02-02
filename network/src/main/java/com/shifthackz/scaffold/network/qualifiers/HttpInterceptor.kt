package com.shifthackz.scaffold.network.qualifiers

import okhttp3.Interceptor

@JvmInline
value class HttpInterceptor(
    private val interceptor: Interceptor
) : Interceptor by interceptor {
    val type: String
        get() = interceptor::class.java.name
}
