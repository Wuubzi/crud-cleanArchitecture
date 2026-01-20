package com.to_do.backend_kotlin.application.service.Task

import Task.GetTaskUseCase
import TaskRepositoryPort
import com.to_do.backend_kotlin.domain.models.Task
import org.springframework.stereotype.Service

@Service
class GetTaskService(
    private val taskRepositoryPort: TaskRepositoryPort
): GetTaskUseCase {
    override fun getTaskById(id: Long): Task = taskRepositoryPort.findById(id) ?: throw IllegalArgumentException("No existe la tarea con el id: $id")
}