package com.example.notesapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.Tag
import com.example.notesapp.domain.model.Note

@Composable
fun NoteList(
    tag: Tag?,
    note: Note,
    onClick: () -> Unit
) {
    val title = note.title
    val tagColor = tag?.color?.color ?: (0xFFa2a2a2).toInt()

    NoteListContent(
        tagColor = tagColor,
        title = title,
        onClick = onClick
    )
}
@Composable
fun NoteListContent (
    tagColor: Int,
    title: String,
    onClick: () -> Unit
){
    Card(
        onClick = onClick,
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.1f)
            .padding(5.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ){
            Box(
                modifier = Modifier
                    .width(10.dp)
                    .fillMaxHeight()
                    .background(
                        color = Color(tagColor),
                        shape = RoundedCornerShape(topStart = 0.dp, bottomStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp)
                    )
            )
            Text(
                text = title,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(12.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {}){
                Icon(
                    imageVector = Icons.Default.Delete, // Та самая стандартная корзина
                    contentDescription = "Удалить"
                )
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun NoteListPreview(){
    NoteListContent(
        tagColor = (0xFFd62929).toInt(),
        title = "Тайтл",
        onClick = {}
    )
}