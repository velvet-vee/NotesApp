// настройка бд

package com.example.data.di

import android.content.Context
import androidx.room3.Room
import com.example.data.dao.NoteDao
import com.example.data.db.NoteDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideMyNotesDatabase(
        @ApplicationContext context: Context
    ): NoteDb = Room.databaseBuilder(
        context,
        NoteDb::class.java,
        "note.db"
    ).build()

    @Provides
    @Singleton
    fun provideNoteDao(database: NoteDb): NoteDao {
    return database.noteDao()
    }
}