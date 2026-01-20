package com.to_do.backend_kotlin.application.service.Task

import Task.UpdateTaskUseCase
import TaskRepositoryPort
import UserRepositoryPort
import com.to_do.backend_kotlin.domain.models.Task
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UpdateTaskService(
    private val taskRepositoryPort: TaskRepositoryPort,
    private val userRepositoryPort: UserRepositoryPort
): UpdateTaskUseCase {
    override fun updateTask(data: Task, id: Long): Task {
        val task = taskRepositoryPort.findById(id) ?: throw IllegalArgumentException("La tarea no existe")

        val updatedTask = task.copy(
            title = data.title,
            description = data.description,
            completed = data.completed,
            priority = data.priority,
            due_date = data.due_date,
            updated_at = LocalDateTime.now()
        )

        return taskRepositoryPort.update(updatedTask)
    }
}