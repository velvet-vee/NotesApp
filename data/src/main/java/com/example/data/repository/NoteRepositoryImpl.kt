// реализация работы с данными(как это делать)

package com.example.data.repository

import com.example.data.dao.NoteDao
import com.example.data.mapper.toDomain
import com.example.data.mapper.toEntity
import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import kotlin.collections.map

class NoteRepositoryImpl @Inject constructor( // hilt узнаёт как создать
    private val noteDao: NoteDao
) : NoteRepository {
    override suspend fun updateNote(note: Note) {
        noteDao.updateNote(note.toEntity())
    }

    override suspend fun createNote(note: Note) {
        noteDao.createNote(note.toEntity())
    }
    override suspend fun getNote(id: Int): Note {
        return noteDao.getNote(id).toDomain()
    }

    override fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes()
            .map { entities ->
                entities.map { it.toDomain() }
            }
    }
}
