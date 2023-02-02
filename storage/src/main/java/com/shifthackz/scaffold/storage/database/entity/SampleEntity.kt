package com.shifthackz.scaffold.storage.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.shifthackz.scaffold.storage.database.contract.SampleContract

@Entity(tableName = SampleContract.TABLE)
data class SampleEntity(
    @PrimaryKey
    @ColumnInfo(name = SampleContract.ID)
    val id: Int,
    @ColumnInfo(name = SampleContract.NAME)
    val name: String,
)
