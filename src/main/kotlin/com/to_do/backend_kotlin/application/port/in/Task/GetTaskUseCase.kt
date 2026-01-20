package Task

import com.to_do.backend_kotlin.domain.models.Task

interface GetTaskUseCase {
    fun getTaskById(id: Long): Task
}