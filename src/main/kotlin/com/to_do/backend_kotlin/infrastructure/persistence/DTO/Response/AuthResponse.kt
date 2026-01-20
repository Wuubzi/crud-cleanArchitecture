package com.to_do.backend_kotlin.infrastructure.persistence.DTO.Response

data class AuthResponse (
    var message: String? = null,
    var url: String? = null,
    var token: String? = null,
    var code: Int? = null,
    var timestamp: String? = null
)