package com.example.notesapp.domain.model

data class Note (
    val id: Int? = 0,
    var title: String,
    var content: String?
)