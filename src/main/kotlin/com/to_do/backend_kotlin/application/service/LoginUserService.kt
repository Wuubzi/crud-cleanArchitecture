package com.to_do.backend_kotlin.application.service

import LoginUserUseCase
import PasswordEncoderPort
import UserRepositoryPort
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class LoginUserService(
    private val userRepositoryPort: UserRepositoryPort,
    private val passwordEncoderPort: PasswordEncoderPort
): LoginUserUseCase
{
    override fun loginUser(email: String, password: String): String {

        return TODO("Provide the return value")
    }

}