package com.example.notesapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.notesapp.presentation.screens.NoteScreen
import com.example.notesapp.presentation.screens.NotesHomeScreen

@Composable
fun AppNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NotesHomeRoute
    ){
        composable<NotesHomeRoute> {
            NotesHomeScreen(
                onCreateNote = {
                    navController.navigate(NoteRoute)
                },
                onOpenNote = {noteId ->
                    navController.navigate(NoteRoute(noteId = noteId))
                }
            )
        }
        composable<NoteRoute> { backStackEntry ->
        val route = backStackEntry.toRoute<NoteRoute>()
            NoteScreen(
               noteId = route.noteId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}