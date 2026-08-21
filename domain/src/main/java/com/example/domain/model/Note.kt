package com.example.notesapp.domain.model

import com.example.domain.model.Tag

data class Note (
    val id: Int? = 0,
    var title: String,
    var content: String?,
    val tag: Tag?
)