package com.to_do.backend_kotlin.domain.models

import java.time.LocalDateTime

data class User(
    val id: Long?,
    val username: String,
    val email: String,
    val password: String,
    val enabled: Boolean,
    val created_at: LocalDateTime,
)