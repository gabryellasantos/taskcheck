package com.example.taskcheck.viewmodel

import androidx.lifecycle.ViewModel
import com.example.taskcheck.repository.TaskRepository

class TaskViewModel : ViewModel() {
    // A tela vai observar este cara
    val tasks = TaskRepository.tasksFlow

    fun newTask(titulo: String) {
        if (titulo.isNotEmpty()) {
            TaskRepository.addTask(titulo)
        }
    }
}