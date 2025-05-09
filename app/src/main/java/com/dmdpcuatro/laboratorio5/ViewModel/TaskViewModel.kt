package com.dmdpcuatro.laboratorio5.ViewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.dmdpcuatro.laboratorio5.model.Task

class TaskViewModel : ViewModel() {
    private var nextId = 1
    var tasks = mutableStateListOf<Task>()
        private set

    fun addTask(title: String, description: String) {
        val task = Task(
            id = nextId++,
            title = title,
            description = description
        )
        tasks.add(task)
    }

    fun updateTask(updatedTask: Task) {
        val index = tasks.indexOfFirst { it.id == updatedTask.id }
        if (index != -1) tasks[index] = updatedTask
    }

    fun deleteTask(task: Task) {
        tasks.remove(task)
    }

    fun clearAllTasks() {
        tasks.clear()
    }
}
