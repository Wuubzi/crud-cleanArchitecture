package com.to_do.backend_kotlin.infrastructure.persistence

import com.to_do.backend_kotlin.infrastructure.persistence.Entity.TaskEntity
import com.to_do.backend_kotlin.infrastructure.persistence.Entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SpringDataTaskRepository: JpaRepository<TaskEntity, Long> {
    fun user(user: UserEntity): MutableList<TaskEntity>
}