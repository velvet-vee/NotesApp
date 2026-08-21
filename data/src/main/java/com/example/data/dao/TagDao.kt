package com.example.data.dao

import androidx.room3.Dao
import androidx.room3.Insert
import androidx.room3.Query
import androidx.room3.Update
import com.example.data.entity.NoteEntity
import com.example.data.entity.NoteWithTag
import com.example.data.entity.TagEntity
import com.example.domain.model.Tag
import kotlinx.coroutines.flow.Flow

@Dao
interface TagDao {
    @Insert
    suspend fun createTag(tagEntity: TagEntity)
    @Update
    suspend fun updateTag(tagEntity: TagEntity)

    @Query("SELECT * FROM notes_table WHERE noteTagId = :tagId")
    fun getNotesByTag(tagId: Int): Flow<List<NoteWithTag>>
}