package com.example.notesapp.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
data object NotesHomeRoute

@Serializable
data class NoteRoute(
    val noteId: Int? = null
)