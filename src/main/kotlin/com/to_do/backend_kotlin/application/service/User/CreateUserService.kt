package com.to_do.backend_kotlin.application.service.User

import PasswordEncoderPort
import User.CreateUserUseCase
import UserRepositoryPort
import com.to_do.backend_kotlin.domain.models.User
import org.springframework.stereotype.Service

@Service
class CreateUserService(
    private val userRepositoryPort: UserRepositoryPort,
    private val passwordEncoderPort: PasswordEncoderPort
): CreateUserUseCase {
    override fun createUser(user: User): User {

        val userPasswordEncode = user.copy(
            password = passwordEncoderPort.encode(user.password)
        )
       return userRepositoryPort.save(userPasswordEncode)
    }
}