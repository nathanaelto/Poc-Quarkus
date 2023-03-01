package io.to.task

import io.to.task.dto.CreateTask
import io.to.task.entities.Task
import io.to.user.UserService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskService {
    @Inject
    lateinit var taskRepository: TaskRepository

    @Inject
    lateinit var userService: UserService

    fun create(createTask: CreateTask): Task {
        val user = userService.findById(createTask.userId) ?: throw IllegalArgumentException("User not found")

        val task = Task()
        task.content = createTask.content
        task.status = createTask.status
        task.user = user

        taskRepository.persist(task)
        return task
    }

    fun findById(taskId: Long): Task? {
        return taskRepository.findById(taskId)
    }

    fun findAllOfUser(userId: Long): List<Task> {
        return taskRepository.findAllOfUser(userId)
    }
}