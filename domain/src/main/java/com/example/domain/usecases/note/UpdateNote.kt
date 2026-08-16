package com.example.notesapp.domain.usecases.note

import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.repository.NoteRepository
import javax.inject.Inject

class UpdateNote @Inject constructor(
    private val noteRepository: NoteRepository){
    suspend fun execute(note: Note) {
        noteRepository.updateNote(note)
    }
}