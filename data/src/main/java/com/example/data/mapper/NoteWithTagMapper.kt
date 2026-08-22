package com.example.data.mapper

import com.example.data.entity.NoteEntity
import com.example.data.entity.NoteWithTag
import com.example.notesapp.domain.model.Note


fun NoteWithTag.toEntity(): NoteEntity  {
    return NoteEntity(
        id = note.id,
        title = note.title,
        content = note.content,
        noteTagId  = tag?.tagId
    )
}
fun NoteWithTag.toTagDomain(): Note {
    return Note(
        id = note.id,
        title = note.title,
        content = note.content,
        tag = tag?.toTagDomain()
    )
}