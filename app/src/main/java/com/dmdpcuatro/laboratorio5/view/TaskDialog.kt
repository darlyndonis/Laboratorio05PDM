package com.dmdpcuatro.laboratorio5.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TaskDialog(
    onDismiss: () -> Unit,
    onAdd: (String, String) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Nueva Tarea") },
        text = {
            Column {
                TextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Nombre de la tarea") },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color(0xFFFFC1CC),
                        unfocusedIndicatorColor = Color(0xFFFFC1CC),
                        cursorColor = Color(0xFFFFC1CC)
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Descripción de la tarea") },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color(0xFFFFC1CC),
                        unfocusedIndicatorColor = Color(0xFFFFC1CC),
                        cursorColor = Color(0xFFFFC1CC)
                    )
                )
            }
        },
        confirmButton = {
            Button(
                onClick = { onAdd(title, description) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC1CC))
            ) {
                Text("Agregar", color = Color.White)
            }
        },
        dismissButton = {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC1CC))
            ) {
                Text("Cancelar", color = Color.White)
            }
        }
    )
}
