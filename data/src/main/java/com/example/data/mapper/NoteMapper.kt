package com.example.data.mapper

import com.example.data.entity.NoteEntity
import com.example.notesapp.domain.model.Note

fun Note.toEntity(): NoteEntity {
    return NoteEntity(
        id = id,       // id из доменной Note переходит в NoteEntity
        title = title,
        content = content,
        noteTagId  = tag?.tagId
    )
}
fun NoteEntity.toDomain(): Note {
    return Note(
        id = id?:0,
        title = title,
        content = content,
        tag = null
    )
}