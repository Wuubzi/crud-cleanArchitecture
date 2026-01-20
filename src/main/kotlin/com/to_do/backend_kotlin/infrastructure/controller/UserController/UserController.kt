package com.to_do.backend_kotlin.infrastructure.controller.UserController

import User.CreateUserUseCase
import User.LoginUserUseCase
import com.to_do.backend_kotlin.infrastructure.persistence.DTO.Request.LoginRequest
import com.to_do.backend_kotlin.infrastructure.persistence.DTO.Request.UserRequest
import com.to_do.backend_kotlin.infrastructure.persistence.DTO.Response.AuthResponse
import com.to_do.backend_kotlin.infrastructure.persistence.DTO.Response.Response
import com.to_do.backend_kotlin.infrastructure.persistence.mapper.toDomain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class UserController(
    private val createUserUseCase: CreateUserUseCase,
    private val loginUserUseCase: LoginUserUseCase

    ) {

    @PostMapping("/register")
    fun createUser(@Valid @RequestBody user: UserRequest, request: HttpServletRequest): Response {
        createUserUseCase.createUser(user.toDomain())
        return Response (
            message = "Usuario creado exitosamente",
            url = request.requestURL.toString(),
            code = HttpServletResponse.SC_CREATED,
            timestamp = null
        )
    }

    @PostMapping("/login")
    fun Login(@Valid @RequestBody user: LoginRequest, request: HttpServletRequest): AuthResponse {
        val token = loginUserUseCase.loginUser(user.email, user.password)

        return AuthResponse(
            message = "Inicio de Sesion Existoso",
            url = request.requestURL.toString(),
            token = token,
            code = HttpServletResponse.SC_OK,
            timestamp = null
        )
    }


}