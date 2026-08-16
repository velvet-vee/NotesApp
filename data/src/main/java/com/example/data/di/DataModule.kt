// изоляция источников данных(бд) от ui

package com.example.data.di

import com.example.data.repository.NoteRepositoryImpl
import com.example.notesapp.domain.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton // когда кто-то просит интерфейс, то дай ему реализацию
    abstract fun bindNoteRepository(implementation: NoteRepositoryImpl): NoteRepository
}