// реализация работы с данными(как это делать)

package com.example.data.repository

import com.example.data.dao.NoteDao
import com.example.data.entity.toEntity
import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor( // hilt узнаёт как создать
    private val noteDao: NoteDao
) : NoteRepository {
    override suspend fun updateNote (note: Note){
        noteDao.updateNote(note.toEntity())
    }
    override suspend fun createNote (note: Note){
        noteDao.createNote(note.toEntity())
    }
}
