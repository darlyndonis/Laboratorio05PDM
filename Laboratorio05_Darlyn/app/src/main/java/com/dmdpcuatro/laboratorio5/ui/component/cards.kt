package com.dmdpcuatro.laboratorio5.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cards(
    pos: Int,
    max: Int,
    title: String = "Title",
    description: String = "Description de tarea",
    endDate: Date = Date(),
    delete: (Int) -> Unit = {},
    check: (Boolean, Int) -> Unit = { _, _ -> },
    checked: Boolean = true,
    changePosition: (Int, Int) -> Unit = { _, _ -> }
) {
    val backgroundColor = if (checked) Color(0xFFA5D6A7) else Color(0xFFFFCDD2)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor,
            contentColor = Color.Black
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineSmall
                )
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            Row {
                Text(
                    text = "Fecha de entrega: $endDate",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { delete(pos) }) {
                    Text(text = "Eliminar", textAlign = TextAlign.Start)
                }
                Checkbox(
                    checked = checked,
                    onCheckedChange = {
                        check(it, pos)
                    },
                )
            }
        }
    }
}


@Composable
@Preview
fun CardsPreview() {
    Cards(
        pos = 0,
        max = 5,
        title = "Title",
        description = "Description",
        delete = { },
        check = { _, _ -> },
        checked = false
    )
}