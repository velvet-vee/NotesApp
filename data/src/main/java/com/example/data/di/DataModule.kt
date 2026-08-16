// изоляция источников данных(бд) от ui

package com.example.data.di

import com.example.data.dao.NoteDao
import com.example.data.repository.NoteRepositoryImpl
import com.example.notesapp.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository {
        return NoteRepositoryImpl(noteDao = noteDao)
    }
}