// сама бд

package com.example.data.db

import androidx.room3.Database
import androidx.room3.RoomDatabase
import com.example.data.dao.NoteDao
import com.example.data.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDb : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}