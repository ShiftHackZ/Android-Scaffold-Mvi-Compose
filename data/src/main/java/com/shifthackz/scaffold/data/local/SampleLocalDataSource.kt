package com.shifthackz.scaffold.data.local

import com.shifthackz.scaffold.domain.datasource.SampleDataSource
import com.shifthackz.scaffold.storage.database.dao.SampleDao
import javax.inject.Inject

class SampleLocalDataSource @Inject constructor(
    private val sampleDao: SampleDao,
) : SampleDataSource.Local {

}
