package com.to_do.backend_kotlin.application.service.Task

import Task.GetAllsTaskUseCase
import TaskRepositoryPort
import com.to_do.backend_kotlin.application.Model.PageResponse
import com.to_do.backend_kotlin.domain.models.Task
import org.springframework.stereotype.Service

@Service
class GetAllTaskService(
    private val taskRepositoryPort: TaskRepositoryPort
): GetAllsTaskUseCase {
    override fun getAllsTask(page: Int?, size: Int?): PageResponse<Task>  = taskRepositoryPort.findAll(page,size)
}