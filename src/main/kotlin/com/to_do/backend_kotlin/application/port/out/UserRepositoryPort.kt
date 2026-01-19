import com.to_do.backend_kotlin.domain.models.User
import com.to_do.backend_kotlin.infrastructure.persistence.Entity.UserEntity


interface UserRepositoryPort {
    fun save(user: User): User
    fun findByEmail(email: String): User?
}