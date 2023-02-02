package com.shifthackz.scaffold.data.datasource

import com.shifthackz.scaffold.domain.datasource.SampleDataSource
import com.shifthackz.scaffold.network.api.SampleApi
import javax.inject.Inject

class SampleRemoteDataSource @Inject constructor(
    private val sampleApi: SampleApi,
) : SampleDataSource.Remote {


}
