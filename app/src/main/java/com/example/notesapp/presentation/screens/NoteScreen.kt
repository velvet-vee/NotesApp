package com.example.notesapp.presentation.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.notesapp.domain.model.Note
import com.example.notesapp.presentation.components.line
import com.example.notesapp.presentation.viewmodel.NoteViewModel

@Composable
fun NoteScreen(
    viewModel: NoteViewModel = hiltViewModel(),
    onBack: () -> Unit,
    noteId: Int? = null
) {
    val note by viewModel.note.collectAsStateWithLifecycle()
    LaunchedEffect(noteId) { // запрос на заметку из бд через getNote
        noteId?.let { id ->
            viewModel.getNote(id)
        }
    }
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf<String?>(null) }
    var titleError by remember { mutableStateOf(false) }
    var wasFocused by remember { mutableStateOf(false) }
    val titleTag = note?.tag?.title

    LaunchedEffect(note) { // положиь в поля экрана ui те данные, которые в бд
        note?.let {
            title = it.title
            content = it.content
        }
    }

    fun saveNote() {
        if (title.isBlank()) {
            titleError = true
            return
        }
        val currentNote = Note(
            id = noteId,
            title = title,
            content = content,
            tag = note?.tag
        )
        if (noteId != null) {
            viewModel.updateNote(currentNote)
        } else {
            viewModel.createNote(currentNote)
        }
    }

    NoteContent(
        title = title,
        titleTag = titleTag,
        content = content,
        titleError = titleError,
        onTitleChange = {
            title = it
            titleError = it.isBlank()
        },
        onContentChange = {content = it},
        onContentFocusChanged = {
            if (wasFocused && !it.isFocused){
                println("сохранение")
                saveNote()
            }
            wasFocused = it.isFocused
        },
        back = {
            saveNote()
            onBack()
        }
    )
}
@Composable
fun NoteContent(
    title: String,
    titleTag: String?,
    content: String?,
    titleError: Boolean,
    onTitleChange: (String) -> Unit,
    onContentChange: (String) -> Unit,
    onContentFocusChanged: (FocusState) -> Unit,
    back: () -> Unit,
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal=10.dp, vertical = 30.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Row{
                Button(
                    onClick = { back() },
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                    modifier = Modifier
                        .width(60.dp)
                        .height(30.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "back",
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(0xFFE0B0FF),
                            shape = CircleShape // Этот параметр превращает Box в идеальный овал
                        )
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = titleTag ?: "Нет тега",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            }
            Spacer(modifier = Modifier.height(6.dp))
            TextField(
                value = title,
                textStyle = TextStyle(fontSize = 20.sp),
                onValueChange = onTitleChange,
                isError = titleError,
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent
                    ),
                modifier = Modifier
                    .fillMaxWidth()
                    .line(titleError),
                label = if (titleError) {
                    { Text("Название не может отсутствовать") }
                } else null,
                placeholder = {
                    Text("")
                },
            )
            TextField(
                value = content ?: "",
                textStyle = TextStyle(fontSize = 16.sp),
                onValueChange = onContentChange,
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent
                ),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxSize()
                    .onFocusChanged { onContentFocusChanged(it) }
                    .padding(0.dp)
            )
        }
    }
}
@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun NotePreview(){
    NoteContent(
        title = "Title",
        content = "Text",
        titleTag = "Tag",
        titleError= false,
        onTitleChange = {},
        onContentChange= {},
        onContentFocusChanged= {},
        back= {}
        )
}