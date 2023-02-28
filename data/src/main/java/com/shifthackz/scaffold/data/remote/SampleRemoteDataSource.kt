package com.shifthackz.scaffold.data.remote

import com.shifthackz.scaffold.domain.datasource.SampleDataSource
import com.shifthackz.scaffold.network.api.SampleApi

class SampleRemoteDataSource constructor(
    private val sampleApi: SampleApi,
) : SampleDataSource.Remote {


}
