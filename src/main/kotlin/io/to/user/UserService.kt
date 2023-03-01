package io.to.user

import io.to.user.dto.CreateUser
import io.to.user.entities.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserService {
    @Inject
    lateinit var userRepository: UserRepository

    fun findAll(): List<User> {
        return userRepository.listAll()
    }

    fun create(createUser: CreateUser): User {
        val user = User()
        user.name = createUser.name
        user.email = createUser.email
        user.password = createUser.password

        userRepository.persist(user)
        return user
    }

    fun findById(userId: Long): User? {
        return userRepository.findById(userId)
    }

    fun delete(user: User) {
        try {
            userRepository.delete(user)
        } catch (e: Exception) {
            throw InternalError("Error deleting user")
        }
    }
}