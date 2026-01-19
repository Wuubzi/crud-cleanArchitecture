package com.to_do.backend_kotlin.application.service

import CreateUserUseCase
import PasswordEncoderPort
import UserRepositoryPort
import com.to_do.backend_kotlin.domain.models.User
import com.to_do.backend_kotlin.infrastructure.persistence.Entity.UserEntity
import org.springframework.stereotype.Service

@Service
class CreateUserService(
    private val userRepositoryPort: UserRepositoryPort,
    private val passwordEncoderPort: PasswordEncoderPort
):  CreateUserUseCase {
    override fun createUser(user: User): User {
       return userRepositoryPort.save(user)
    }
}