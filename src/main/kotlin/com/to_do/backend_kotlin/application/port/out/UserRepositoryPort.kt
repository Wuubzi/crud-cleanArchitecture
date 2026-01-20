import com.to_do.backend_kotlin.domain.models.User



interface UserRepositoryPort {
    fun save(user: User): User
    fun findByEmail(email: String): User?
    fun findById(id: Long): User?
}