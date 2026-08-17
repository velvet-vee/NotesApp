// что можно делать

package com.example.notesapp.domain.repository

import com.example.notesapp.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun updateNote (note: Note)
    suspend fun createNote (note: Note)
    suspend fun getNote (id: Int): Note
    fun getAllNotes(): Flow<List<Note>>


}