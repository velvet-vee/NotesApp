package com.example.domain.usecases.note

import com.example.domain.repository.TagRepository
import com.example.notesapp.domain.model.Note
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNotesByTag @Inject constructor(
    private val tagRepository: TagRepository
){
    fun execute(tagId: Int): Flow<List<Note>> {
        return tagRepository.getNotesByTag(tagId)
    }
}