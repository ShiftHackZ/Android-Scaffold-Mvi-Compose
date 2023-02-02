package com.shifthackz.scaffold.data.repository

import com.shifthackz.scaffold.domain.datasource.SampleDataSource
import com.shifthackz.scaffold.domain.repository.SampleRepository
import javax.inject.Inject

class SampleRepositoryImpl @Inject constructor(
    private val remoteDataSource: SampleDataSource.Remote
) : SampleRepository {

}
