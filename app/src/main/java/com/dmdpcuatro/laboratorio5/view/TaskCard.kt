package com.dmdpcuatro.laboratorio5.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dmdpcuatro.laboratorio5.model.Task

@Composable
fun TaskCard(
    task: Task,
    onToggleComplete: (Task) -> Unit,
    onDelete: (Task) -> Unit
) {
    val cardColor = if (task.isCompleted) Color(0xFFC8E6C9) else Color(0xFFE0E0E0)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = task.title,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = if (task.isCompleted) "\u2705" else "○",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = task.description,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {
                        onToggleComplete(task.copy(isCompleted = !task.isCompleted))
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC1CC))
                ) {
                    Text(if (task.isCompleted) "Completada" else "Pendiente", color = Color.White)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { onDelete(task) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC1CC))
                ) {
                    Text("Eliminar", color = Color.White)
                }
            }
        }
    }
}
