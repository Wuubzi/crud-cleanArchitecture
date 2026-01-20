package com.to_do.backend_kotlin.infrastructure.Security

import PasswordEncoderPort
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class PasswordEncoderAdapter
    (
    private val passwordEncoder: PasswordEncoder
): PasswordEncoderPort {
    override fun encode(rawPassword: String): String = passwordEncoder.encode(rawPassword) ?: throw IllegalStateException("Error encoding password")

    override fun matches(rawPassword: String, encodedPassword: String): Boolean = passwordEncoder.matches(rawPassword, encodedPassword)

}