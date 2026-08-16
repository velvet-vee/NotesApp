package com.example.notesapp.domain.usecases.note

import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.repository.NoteRepository
import javax.inject.Inject

class CreateNote @Inject constructor(
    private val noteRepository: NoteRepository) {
    suspend fun execute(note: Note) {
        noteRepository.createNote(note)
    }
}