package com.dmdpcuatro.laboratorio5.ui.ToDo

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.dmdpcuatro.laboratorio5.Models.Card

class ToDoViewModel : ViewModel() {

    private val _taskList = mutableStateListOf<Card>()
    val taskList: List<Card> = _taskList

    fun addTask(task: Card) {
        _taskList.add(task)
    }

    fun removeTask(task: Card) {
        _taskList.remove(task)
    }
}