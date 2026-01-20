package com.to_do.backend_kotlin.infrastructure.persistence.DTO.Request

import java.time.LocalDate

data class TaskRequest(
    val title: String,
    val description: String,
    val completed: Boolean,
    val priority: String,
    val due_date: LocalDate,
    val user_id: Long,
)
