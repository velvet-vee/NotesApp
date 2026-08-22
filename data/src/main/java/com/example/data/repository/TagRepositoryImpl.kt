package com.example.data.repository

import com.example.data.dao.TagDao
import com.example.data.mapper.toDomain
import com.example.data.mapper.toEntity
import com.example.data.mapper.toTagDomain
import com.example.domain.model.Tag
import com.example.domain.repository.TagRepository
import com.example.notesapp.domain.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TagRepositoryImpl @Inject constructor(
    private val tagDao: TagDao
): TagRepository {
    override suspend fun createTag(tag: Tag){
        tagDao.createTag(tag.toEntity())
    }
    override suspend fun updateTag(tag: Tag){
        tagDao.updateTag(tag.toEntity())
    }
    override fun getNotesByTag(tagId: Int): Flow<List<Note>> {
        return tagDao.getNotesByTag(tagId)
            .map { entities ->
                entities.map { it.toTagDomain() }
            }
    }
}