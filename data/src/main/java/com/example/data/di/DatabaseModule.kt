// настройка бд

package com.example.data.di

import android.content.Context
import androidx.room3.Room
import com.example.data.dao.NoteDao
import com.example.data.dao.TagDao
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
        "app.db"
    ).build()

    @Provides // Если кому-то в проекте понадобится NoteDao, вот метод, чтобы его получить. создание объекта сторонней библиотеки (например, Room)
    @Singleton
    fun provideNoteDao(database: NoteDb): NoteDao {
    return database.noteDao()
    }
    @Provides
    @Singleton
    fun provideTagDao(database: NoteDb): TagDao {
        return database.tagDao()
    }
}