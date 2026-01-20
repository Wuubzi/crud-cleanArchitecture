package com.to_do.backend_kotlin.infrastructure.persistence

import TaskRepositoryPort

import com.to_do.backend_kotlin.application.Model.PageResponse
import com.to_do.backend_kotlin.domain.models.Task
import com.to_do.backend_kotlin.infrastructure.persistence.mapper.toDomain
import com.to_do.backend_kotlin.infrastructure.persistence.mapper.toEntity
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Repository


@Repository
class JpaTaskRepositoryAdapter(
    private val taskRepository: SpringDataTaskRepository,
    private val userRepository: SpringDataUserRepository
): TaskRepositoryPort {

    override fun findAll(page: Int?, size: Int?): PageResponse<Task> {
        val safePage = page ?: 0
        val safeSize = size ?: 10

        val pageable = PageRequest.of(safePage,safeSize)
        val result = taskRepository.findAll(pageable)
        return PageResponse(
            content =  result.content.map { it.toDomain() },
            page = pageable.pageNumber,
            size = pageable.pageSize,
            totalElements = result.totalElements,
            totalPages = result.totalPages,
            hasNext = result.hasNext(),
            hasPrevious = result.hasPrevious()
        )
    }

    override fun findById(id: Long): Task? = taskRepository.findById(id).map { it.toDomain() }.orElse(null)

    override fun save(task: Task): Task {
        val userEntity = userRepository.findById(task.user).orElseThrow { IllegalArgumentException("El usuario no existe") }
        val taskEntity = task.toEntity(userEntity)
        return taskRepository.save(taskEntity).toDomain()
    }

    override fun update(task: Task): Task {
        val userEntity = userRepository.findById(task.user).orElseThrow { IllegalArgumentException("El usuario no existe") }
        val taskEntity = task.toEntity(userEntity)
        return taskRepository.save(taskEntity).toDomain()
    }



    override fun deleteById(id: Long) {
        return taskRepository.deleteById(id)
    }


}