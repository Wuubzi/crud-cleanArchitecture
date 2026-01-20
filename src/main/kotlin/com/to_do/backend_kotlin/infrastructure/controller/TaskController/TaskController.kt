package com.to_do.backend_kotlin.infrastructure.controller.TaskController

import Task.CreateTaskUseCase
import Task.DeleteTaskUseCase
import Task.GetAllsTaskUseCase
import Task.GetTaskUseCase
import Task.UpdateTaskUseCase
import com.to_do.backend_kotlin.application.Model.PageResponse
import com.to_do.backend_kotlin.domain.models.Task
import com.to_do.backend_kotlin.infrastructure.persistence.DTO.Request.TaskRequest
import com.to_do.backend_kotlin.infrastructure.persistence.DTO.Response.Response
import com.to_do.backend_kotlin.infrastructure.persistence.DTO.Response.TaskReponse
import com.to_do.backend_kotlin.infrastructure.persistence.mapper.toDomain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/tasks")
class TaskController(
    private val getAllsTaskUseCase: GetAllsTaskUseCase,
    private val getTaskUseCase: GetTaskUseCase,
    private val createTaskUseCase: CreateTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    taskUseCase: DeleteTaskUseCase

) {

    @GetMapping
    fun getAllTasks(
        @RequestParam(required = false ) page: Int?,
        @RequestParam(required = false ) size: Int?
    ): PageResponse<Task> = getAllsTaskUseCase.getAllsTask(page,size)


    @GetMapping("/{id}")
    fun getTaskById(@PathVariable id: Long): Task = getTaskUseCase.getTaskById(id)

    @PostMapping
    fun createTask(@Valid @RequestBody task: TaskRequest, request: HttpServletRequest): Response {
        createTaskUseCase.createTask(task.toDomain())
        return Response(
            message = "Task creada exitosamente",
            url = request.requestURL.toString(),
            code = HttpServletResponse.SC_OK,
            timestamp = null
        );
    }

    @PutMapping("/{id}")
    fun updateTask(@PathVariable id: Long, @Valid @RequestBody task: TaskRequest, request: HttpServletRequest): Response {
        updateTaskUseCase.updateTask(task.toDomain(), id)
        return Response(
            message = "Task Actualizada exitosamente",
            url = request.requestURL.toString(),
            code = HttpServletResponse.SC_OK,
            timestamp = null
        );
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: Long, request: HttpServletRequest): Response {

        deleteTaskUseCase.deleteTask(id)
        return Response(
            message = "Task Eliminada exitosamente",
            url = request.requestURL.toString(),
            code = HttpServletResponse.SC_OK,
            timestamp = null
        );
    }

}