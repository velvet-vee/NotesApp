package com.example.notesapp.presentation.components

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

fun Modifier.line(
    titleError: Boolean
): Modifier = this
    .drawWithContent{
        drawContent()

        val y = size.height
        val color = if (titleError) Color.Red else Color.Black

        drawLine(
            brush = Brush.linearGradient(
                colors = listOf(color, Color.Transparent),
                start = Offset(size.width * 0.5f, y), // Начало градиента по центру
                end = Offset(size.width * 0.95f, y)   // Конец градиента
            ),
            start = Offset(0f, y),                  // Линия начинается от левого края (startX * 0 = 0)
            end = Offset(size.width * 0.95f, y),    // Конец линии
            strokeWidth = 4.dp.toPx()
        )
    }