package com.to_do.backend_kotlin.domain.models


import java.time.LocalDateTime

data class Task(
    val id: Long,
    val title: String,
    val description: String,
    val completed: Boolean,
    val priority: String,
    val due_date: String,
    val user_id: Long,
    val created_at: LocalDateTime,
    val updated_at: LocalDateTime
)