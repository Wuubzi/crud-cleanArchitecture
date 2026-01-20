package Task

import com.to_do.backend_kotlin.domain.models.Task

interface UpdateTaskUseCase {
    fun updateTask(task: Task, id: Long): Task
}