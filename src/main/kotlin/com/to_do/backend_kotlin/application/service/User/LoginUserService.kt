package com.to_do.backend_kotlin.application.service.User

import JwtTokenProviderPort
import PasswordEncoderPort
import User.LoginUserUseCase
import UserRepositoryPort
import com.to_do.backend_kotlin.application.Exceptions.InvalidCredentialsException
import org.springframework.stereotype.Service

@Service
class LoginUserService(
    private val userRepositoryPort: UserRepositoryPort,
    private val passwordEncoderPort: PasswordEncoderPort,
    private val jwtTokenProviderPort: JwtTokenProviderPort
): LoginUserUseCase
{
    override fun loginUser(email: String, password: String): String {

        val user = userRepositoryPort.findByEmail(email)
            ?: throw IllegalArgumentException("Usuario no encontrado con el correo: $email")
1
        if (!passwordEncoderPort.matches(password, user.password)) throw InvalidCredentialsException("Contraseña Incorrecta")

       return jwtTokenProviderPort.generateToken(user)
    }

}