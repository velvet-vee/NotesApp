// как заметка храниться в бд

package com.example.data.entity

import androidx.room3.Entity
import androidx.room3.PrimaryKey
import com.example.notesapp.domain.model.Note

@Entity(tableName = "notes_table")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String?,
    val content: String?
)
fun Note.toEntity(): NoteEntity {
    return NoteEntity(
        id = this.id,       // id из доменной Note переходит в NoteEntity
        title = this.title,
        content = this.content
    )
}