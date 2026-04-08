package com.example.taskcheck.model

data class Task(
    val id: Int,
    val titulo: String,
    val isConcluida: Boolean = false
)