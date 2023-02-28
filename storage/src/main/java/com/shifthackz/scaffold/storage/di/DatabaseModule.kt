package com.shifthackz.scaffold.storage.di

import androidx.room.Room
import com.shifthackz.scaffold.storage.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, AppDatabase.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().sampleDao() }
}
