import com.to_do.backend_kotlin.domain.models.User


interface JwtTokenProviderPort {
    fun generateToken(user: User): String
}