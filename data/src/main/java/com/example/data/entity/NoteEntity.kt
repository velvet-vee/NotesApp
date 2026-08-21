// как заметка храниться в бд

package com.example.data.entity

import androidx.room3.Entity
import androidx.room3.ForeignKey
import androidx.room3.PrimaryKey
import com.example.domain.model.Tag
import com.example.notesapp.domain.model.Note

@Entity(tableName = "notes_table",
    foreignKeys = [
        ForeignKey(
            entity = TagEntity::class,
            parentColumns = ["tagId"],     // ID из таблицы тегов
            childColumns = ["noteTagId"],  // Имя колонки в текущей таблице заметок
            onDelete = ForeignKey.SET_NULL // Если тег удалят, у заметки это поле просто станет null
        )
    ]
)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String,
    val content: String?,
    val noteTagId: Int?
)