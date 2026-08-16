package com.example.notesapp.presentation.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.notesapp.presentation.viewmodel.NoteViewModel

@Composable
fun NoteScreen(
    viewModel: NoteViewModel = hiltViewModel(),
    onBack: () -> Unit,
    noteId: Int? = null
){

}