package com.to_do.backend_kotlin.infrastructure.persistence.mapper

import com.to_do.backend_kotlin.domain.models.User
import com.to_do.backend_kotlin.infrastructure.persistence.DTO.Request.UserRequest
import com.to_do.backend_kotlin.infrastructure.persistence.Entity.UserEntity
import java.time.LocalDateTime

fun User.toEntity(): UserEntity =
    UserEntity().apply {
        id = this@toEntity.id
        username = this@toEntity.username
        email = this@toEntity.email
        password = this@toEntity.password
        enabled = this@toEntity.enabled
        createdAt = this@toEntity.created_at
    }

fun UserEntity.toDomain(): User =
    User(
        id = id,
        username = username,
        email = email,
        password = password,
        enabled = enabled,
        created_at = createdAt
    )

fun UserRequest.toDomain(): User = User(
    id = null,
    username = username,
    email = email,
    password = password,
    enabled = true,
    created_at = LocalDateTime.now()
)


