package com.shifthackz.scaffold.data.local

import com.shifthackz.scaffold.domain.datasource.SampleDataSource
import com.shifthackz.scaffold.storage.database.dao.SampleDao

class SampleLocalDataSource(
    private val sampleDao: SampleDao,
) : SampleDataSource.Local {

}
