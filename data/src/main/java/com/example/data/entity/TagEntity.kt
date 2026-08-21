package com.example.data.entity

import androidx.room3.Entity
import androidx.room3.ForeignKey
import androidx.room3.PrimaryKey
import com.example.domain.model.TagColor

@Entity(tableName = "tags_table")
data class TagEntity(
    @PrimaryKey(autoGenerate = true)
    val tagId: Int? = null,
    val title: String,
    val color: TagColor
)
