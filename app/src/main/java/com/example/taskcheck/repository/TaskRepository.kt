package com.example.taskcheck.repository

import com.example.taskcheck.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object TaskRepository {
    private val tasks = mutableListOf<Task>()

    private val _tasksFlow = MutableStateFlow<List<Task>>(emptyList())
    val tasksFlow: StateFlow<List<Task>> = _tasksFlow

    fun addTask(titulo: String) {
        val newTask = Task(id = tasks.size + 1, titulo = titulo)
        tasks.add(newTask)
        _tasksFlow.value = tasks.toList()
    }
}