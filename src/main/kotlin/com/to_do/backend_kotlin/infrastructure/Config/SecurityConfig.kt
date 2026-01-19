package com.to_do.backend_kotlin.infrastructure.Config


import com.to_do.backend_kotlin.infrastructure.security.CustomAuthenticationEntryPoint
import com.to_do.backend_kotlin.infrastructure.security.CustomUserDetailsService
import com.to_do.backend_kotlin.infrastructure.security.JwtAuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class SecurityConfig(
    private val customUserDetailsService: CustomUserDetailsService,
    private val jwtAuthenticationFilter: JwtAuthenticationFilter,
    private val customAuthenticationEntryPoint: CustomAuthenticationEntryPoint,
)
{

    @Bean
    fun securityFilterChain(http: HttpSecurity

    ): SecurityFilterChain {
          http
                .csrf { it.disable() }
                .cors { it.disable() }
              .authorizeHttpRequests {
                  it.requestMatchers("/api/v1/auth/**").permitAll()
                  it.anyRequest().authenticated()
              }
              .exceptionHandling { it.authenticationEntryPoint(customAuthenticationEntryPoint) }
              .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
              .authenticationProvider(authenticationProvider())
              .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)
        return http.build()
    }

    @Bean
    fun authenticationProvider(): AuthenticationProvider {
        val authProvider = DaoAuthenticationProvider(customUserDetailsService)
        authProvider.setPasswordEncoder(passwordEncoder())
        return authProvider
    }

    @Bean
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}