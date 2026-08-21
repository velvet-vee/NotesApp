// изоляция источников данных(бд) от ui

package com.example.data.di

import com.example.data.repository.NoteRepositoryImpl
import com.example.data.repository.TagRepositoryImpl
import com.example.domain.repository.TagRepository
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
    @Singleton // связывание собственного интерфейса с собственным классом-реализацией
    abstract fun bindNoteRepository(implementation: NoteRepositoryImpl): NoteRepository
    @Binds
    @Singleton // связывание собственного интерфейса с собственным классом-реализацией
    abstract fun bindTagRepository(implementation: TagRepositoryImpl): TagRepository
}