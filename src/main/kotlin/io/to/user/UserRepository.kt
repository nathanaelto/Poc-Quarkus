package io.to.user

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import io.to.user.entities.User
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class UserRepository: PanacheRepository<User> {
    fun findByEmail(email: String): User? {
        return find("email", email).firstResult()
    }

}