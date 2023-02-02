package com.shifthackz.scaffold.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shifthackz.scaffold.storage.database.dao.SampleDao
import com.shifthackz.scaffold.storage.database.entity.SampleEntity

@Database(
    version = 1,
    exportSchema = true,
    entities = [
        SampleEntity::class,
    ],
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun sampleDao(): SampleDao

    companion object {
        const val DB_NAME = "sample_app_db"
    }
}
