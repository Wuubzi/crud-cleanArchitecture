package com.to_do.backend_kotlin.infrastructure.persistence

import com.to_do.backend_kotlin.infrastructure.persistence.Entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SpringDataUserRepository: JpaRepository<UserEntity, Long> {
    fun findByEmail(email: String): UserEntity?
}