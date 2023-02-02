package com.shifthackz.scaffold.storage.di

import android.content.Context
import androidx.room.Room
import com.shifthackz.scaffold.storage.database.AppDatabase
import com.shifthackz.scaffold.storage.database.dao.SampleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase = Room
        .databaseBuilder(context, AppDatabase::class.java, AppDatabase.DB_NAME)
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideSampleDao(db: AppDatabase): SampleDao = db.sampleDao()
}
