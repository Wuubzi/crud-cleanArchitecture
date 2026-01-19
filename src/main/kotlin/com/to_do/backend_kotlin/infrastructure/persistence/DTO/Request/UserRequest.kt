package com.to_do.backend_kotlin.infrastructure.persistence.DTO.Request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty


data class UserRequest(
    @field:NotEmpty
    val username: String,
    @field:NotEmpty
    @field:Email
    val email: String,
    @field:NotEmpty
    val password: String,
)