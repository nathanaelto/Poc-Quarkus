package io.to.task

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import io.to.task.entities.Task
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TaskRepository: PanacheRepository<Task> {
    fun findAllOfUser(userId: Long): List<Task> {
        return find("user.id", userId).list()
    }
}