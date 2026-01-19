package com.to_do.backend_kotlin.infrastructure.persistence.DTO.Response

data class ErrorResponse (
    var message: String? = null,
    var code: Int? = null,
    var exception: String? = null,
    var path: String? = null
)