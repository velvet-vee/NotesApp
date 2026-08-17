package com.example.notesapp.domain.usecases.note

import com.example.notesapp.domain.repository.NoteRepository
import javax.inject.Inject
import com.example.notesapp.domain.model.Note

class GetNote @Inject constructor(
    private val noteRepository: NoteRepository
){
    suspend fun execute(id: Int): Note{
        return noteRepository.getNote(id)
    }
}