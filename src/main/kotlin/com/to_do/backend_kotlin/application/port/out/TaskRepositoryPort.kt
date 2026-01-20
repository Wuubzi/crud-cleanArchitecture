import com.to_do.backend_kotlin.application.Model.PageResponse
import com.to_do.backend_kotlin.domain.models.Task

interface TaskRepositoryPort {
    fun save(task: Task): Task
    fun update(task: Task): Task
    fun findAll(page: Int?, size: Int?): PageResponse<Task>
    fun deleteById(id: Long)
    fun findById(id: Long): Task?
}