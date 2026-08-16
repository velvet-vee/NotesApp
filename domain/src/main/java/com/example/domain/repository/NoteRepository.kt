// что можно делать

package com.example.notesapp.domain.repository

import com.example.notesapp.domain.model.Note

interface NoteRepository {
    suspend fun updateNote (note: Note)
    suspend fun createNote (note: Note)

}