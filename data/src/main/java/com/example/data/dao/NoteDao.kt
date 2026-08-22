// команды для работы с бд

package com.example.data.dao

import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.Query
import androidx.room3.Transaction
import androidx.room3.Update
import com.example.data.entity.NoteEntity
import com.example.data.entity.NoteWithTag
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert
    suspend fun createNote(noteEntity: NoteEntity)

    @Update
    suspend fun updateNote(noteEntity: NoteEntity)

    @Delete
    suspend fun deleteNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): Flow<List<NoteWithTag>>

    @Query("SELECT * FROM notes_table WHERE id=:id")
    suspend fun getNote(id: Int): NoteEntity

    @Transaction
    @Query("SELECT * FROM notes_table WHERE noteTagId=:tagId")
    suspend fun getNotesByTag(tagId: String): List<NoteWithTag>
}
