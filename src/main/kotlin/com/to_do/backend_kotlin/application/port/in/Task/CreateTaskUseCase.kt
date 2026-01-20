package Task

import com.to_do.backend_kotlin.domain.models.Task

interface CreateTaskUseCase {
    fun createTask(task: Task): Task
}