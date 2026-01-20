package Task

import com.to_do.backend_kotlin.application.Model.PageResponse
import com.to_do.backend_kotlin.domain.models.Task

interface GetAllsTaskUseCase {
    fun getAllsTask(page: Int?, size: Int?): PageResponse<Task>
}