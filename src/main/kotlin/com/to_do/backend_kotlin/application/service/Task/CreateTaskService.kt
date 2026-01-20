package com.to_do.backend_kotlin.application.service.Task

import Task.CreateTaskUseCase
import TaskRepositoryPort
import UserRepositoryPort
import com.to_do.backend_kotlin.domain.models.Task
import org.springframework.stereotype.Service


@Service
class CreateTaskService(
    private val taskRepositoryPort: TaskRepositoryPort,
): CreateTaskUseCase {
    override fun createTask(task: Task): Task  {
        return taskRepositoryPort.save(task)
    }

}