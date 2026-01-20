package com.to_do.backend_kotlin.application.service.Task

import Task.DeleteTaskUseCase
import TaskRepositoryPort
import org.springframework.stereotype.Service

@Service
class DeleteTaskService(
   private val taskRepositoryPort: TaskRepositoryPort
): DeleteTaskUseCase{
    override fun deleteTask(id: Long) {
        taskRepositoryPort.findById(id) ?: throw IllegalArgumentException("No existe la tarea con el id: $id")
        taskRepositoryPort.deleteById(id)
    }
}