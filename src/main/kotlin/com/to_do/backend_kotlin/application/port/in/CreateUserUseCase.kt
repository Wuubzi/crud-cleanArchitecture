import com.to_do.backend_kotlin.domain.models.User

interface CreateUserUseCase {
    fun createUser(user: User): User
}