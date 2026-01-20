package com.to_do.backend_kotlin.infrastructure.Security

import JwtTokenProviderPort
import com.to_do.backend_kotlin.domain.models.User
import com.to_do.backend_kotlin.infrastructure.security.CustomUserDetails
import org.springframework.stereotype.Component

@Component
class JwtTokenProviderAdapter(
    private val jwtService: JwtService
): JwtTokenProviderPort {
    override fun generateToken(user: User): String {
        val customUserDetails = CustomUserDetails(user)
        return jwtService.generateToken(customUserDetails)
    }



}