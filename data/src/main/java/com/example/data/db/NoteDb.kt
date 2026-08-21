// сама бд

package com.example.data.db

import androidx.room3.Database
import androidx.room3.RoomDatabase
import com.example.data.dao.NoteDao
import com.example.data.dao.TagDao
import com.example.data.entity.NoteEntity
import com.example.data.entity.TagEntity

@Database(entities = [NoteEntity::class, TagEntity::class], version = 1, exportSchema = false)
abstract class NoteDb : RoomDatabase() {
    abstract fun noteDao(): NoteDao
    abstract fun tagDao(): TagDao
}