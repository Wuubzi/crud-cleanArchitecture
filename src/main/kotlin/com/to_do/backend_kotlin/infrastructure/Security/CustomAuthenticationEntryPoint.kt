package com.to_do.backend_kotlin.infrastructure.security

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Component
class CustomAuthenticationEntryPoint : AuthenticationEntryPoint {

    private val objectMapper = ObjectMapper()

    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authException: AuthenticationException
    ) {
        val body = mapOf(
            "message" to "No estas autorizado para acceder a esta ruta",
            "status" to HttpServletResponse.SC_UNAUTHORIZED,
            "exception" to authException::class.simpleName,
            "path" to request.requestURI,
            "timestamp" to LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
        )

        response.status = HttpServletResponse.SC_UNAUTHORIZED
        response.contentType = "application/json"
        response.writer.write(objectMapper.writeValueAsString(body))
    }
}
