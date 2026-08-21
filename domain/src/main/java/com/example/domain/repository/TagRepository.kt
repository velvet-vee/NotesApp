package com.example.domain.repository

import com.example.domain.model.Tag
import com.example.notesapp.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface TagRepository {
    suspend fun createTag(tag: Tag)
    suspend fun updateTag(tag: Tag)
//    suspend fun deleteTag(tag: Tag)
//    fun getAllTags(): Flow<List<Tag>>
    fun getNotesByTag(tagId: Int): Flow<List<Note>>
}