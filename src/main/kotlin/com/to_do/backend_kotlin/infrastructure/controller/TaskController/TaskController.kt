package com.to_do.backend_kotlin.infrastructure.controller.TaskController

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/tasks")
class TaskController {

    @GetMapping
    fun getAllTasks(): String {
        return "Hello World";
    }
}