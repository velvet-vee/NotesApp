package com.example.data.entity

import androidx.room3.Embedded
import androidx.room3.Relation

data class NoteWithTag(
    @Embedded val note: NoteEntity,

    @Relation(
        parentColumns = ["noteTagId"], // Берем noteTagId из заметки
        entityColumns = ["tagId"]      // Ищем тег с таким же tagId в таблице тегов
    )
    val tag: TagEntity?
)