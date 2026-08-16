package com.example.notesapp.domain.usecases.note

import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.repository.NoteRepository

class CreateNote(private val noteRepository: NoteRepository) {
    suspend fun execute(note: Note) {
        return noteRepository.createNote(note)
    }
}