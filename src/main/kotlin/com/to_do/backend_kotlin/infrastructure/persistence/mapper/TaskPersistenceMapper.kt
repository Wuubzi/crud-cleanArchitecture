package com.to_do.backend_kotlin.infrastructure.persistence.mapper

import com.to_do.backend_kotlin.domain.models.Task
import com.to_do.backend_kotlin.infrastructure.persistence.DTO.Request.TaskRequest
import com.to_do.backend_kotlin.infrastructure.persistence.Entity.TaskEntity
import com.to_do.backend_kotlin.infrastructure.persistence.Entity.UserEntity
import java.time.LocalDateTime


fun Task.toEntity(userEntity: UserEntity): TaskEntity =
    TaskEntity().apply {
        id = this@toEntity.id
        title = this@toEntity.title
        description = this@toEntity.description
        completed = this@toEntity.completed
        priority = this@toEntity.priority
        due_date = this@toEntity.due_date
        user = userEntity
        created_at = this@toEntity.created_at ?: LocalDateTime.now()
        updated_at = this@toEntity.updated_at ?: LocalDateTime.now()
    }

fun TaskEntity.toDomain(): Task =
    Task(
        id = id,
        title = title,
        description = description ?: "",
        completed = completed,
        priority = priority,
        due_date = due_date,
        user= user.id!!,
        created_at = created_at,
        updated_at = updated_at
    )


fun TaskRequest.toDomain(): Task =
    Task(
        id = null,
        title = title,
        description = description,
        completed = completed,
        priority = priority,
        due_date = due_date,
        user = user_id,
        created_at = null,
        updated_at = null
    )
