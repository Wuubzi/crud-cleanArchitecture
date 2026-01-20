package com.to_do.backend_kotlin.infrastructure.persistence.DTO.Request

import jakarta.validation.constraints.NotEmpty

data class LoginRequest(
    @field:NotEmpty
    val email: String,
    @field:NotEmpty
    val password: String
)