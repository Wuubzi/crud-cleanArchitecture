package com.to_do.backend_kotlin.infrastructure.controller.UserController

import CreateUserUseCase
import com.to_do.backend_kotlin.domain.models.User
import com.to_do.backend_kotlin.infrastructure.persistence.DTO.Request.UserRequest
import com.to_do.backend_kotlin.infrastructure.persistence.mapper.toDomain
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class UserController(private val createUserUseCase: CreateUserUseCase) {

    @PostMapping("/register")
    fun createUser(@Valid @RequestBody user: UserRequest): User = createUserUseCase.createUser(user.toDomain())

  //  @PostMapping("/login")


}