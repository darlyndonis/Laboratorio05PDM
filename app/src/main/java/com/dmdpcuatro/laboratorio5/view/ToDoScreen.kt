package com.dmdpcuatro.laboratorio5.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dmdpcuatro.laboratorio5.ViewModel.TaskViewModel
import com.dmdpcuatro.laboratorio5.model.Task
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoScreen(viewModel: TaskViewModel = viewModel()) {
    var showDialog by remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Lista de Tareas", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFFC1CC),
                    titleContentColor = Color.White
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true },
                containerColor = Color(0xFFFFC1CC)
            ) {
                Text("+", fontSize = 24.sp, color = Color.White)
            }
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(viewModel.tasks) { task ->
                    TaskCard(
                        task = task,
                        onToggleComplete = { updated ->
                            viewModel.updateTask(updated)
                        },
                        onDelete = { taskToDelete ->
                            viewModel.deleteTask(taskToDelete)
                            scope.launch {
                                snackbarHostState.showSnackbar("Tarea eliminada")
                            }
                        }
                    )
                }
            }

            Button(
                onClick = { viewModel.clearAllTasks() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC1CC))
            ) {
                Text("Eliminar todo", color = Color.White)
            }
        }

        if (showDialog) {
            TaskDialog(
                onDismiss = { showDialog = false },
                onAdd = { title, description ->
                    if (title.isNotBlank()) {
                        viewModel.addTask(title, description)
                        showDialog = false
                    }
                }
            )
        }
    }
}
