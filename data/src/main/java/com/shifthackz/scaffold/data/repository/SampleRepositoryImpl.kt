package com.shifthackz.scaffold.data.repository

import com.shifthackz.scaffold.domain.datasource.SampleDataSource
import com.shifthackz.scaffold.domain.repository.SampleRepository

class SampleRepositoryImpl(
    private val remoteDataSource: SampleDataSource.Remote
) : SampleRepository {

}
