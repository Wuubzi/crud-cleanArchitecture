package User

interface LoginUserUseCase {
    fun loginUser(email: String, password: String): String
}