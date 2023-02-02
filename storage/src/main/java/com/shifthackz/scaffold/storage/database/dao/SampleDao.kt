package com.shifthackz.scaffold.storage.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.shifthackz.scaffold.storage.database.contract.SampleContract
import com.shifthackz.scaffold.storage.database.entity.SampleEntity

@Dao
interface SampleDao {

    @Query("SELECT * FROM ${SampleContract.TABLE}")
    fun queryAll(): List<SampleEntity>
}
