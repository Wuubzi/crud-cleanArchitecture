package com.to_do.backend_kotlin.infrastructure.persistence

import UserRepositoryPort
import com.to_do.backend_kotlin.domain.models.User
import com.to_do.backend_kotlin.infrastructure.persistence.mapper.toDomain
import com.to_do.backend_kotlin.infrastructure.persistence.mapper.toEntity
import org.springframework.stereotype.Repository



@Repository
class JpaUserRepositoryAdapter(
    private val springDataUserRepository: SpringDataUserRepository
): UserRepositoryPort {

    override fun save(user: User): User {
        val entity = user.toEntity()
       val userSaved = springDataUserRepository.save(entity)
        return userSaved.toDomain()
    }

    override fun findByEmail(email: String): User? = springDataUserRepository.findByEmail(email)?.toDomain()


    override fun findById(id: Long): User? =  springDataUserRepository.findById(id).orElse(null)?.toDomain()

}