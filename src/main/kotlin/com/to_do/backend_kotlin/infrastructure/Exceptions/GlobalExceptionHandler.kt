package com.to_do.backend_kotlin.infrastructure.Exceptions

import com.to_do.backend_kotlin.application.Exceptions.InvalidCredentialsException
import com.to_do.backend_kotlin.infrastructure.persistence.DTO.Response.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(InvalidCredentialsException::class)
    fun invalidCrendentialsException(ex: InvalidCredentialsException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            message = ex.message,
            code = 401,
            exception = ex.javaClass.simpleName,
            path = null
        )
        return ResponseEntity.status(401).body(errorResponse)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun illegalArgumentException(ex: IllegalArgumentException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            message = ex.message,
            code = 400,
            exception = ex.javaClass.simpleName,
            path = null
        )
        return ResponseEntity.status(400).body(errorResponse)
    }

}