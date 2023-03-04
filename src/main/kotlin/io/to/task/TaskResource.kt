package io.to.task

import io.to.task.dto.CreateTask
import javax.inject.Inject
import javax.transaction.Transactional
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/tasks")
class TaskResource {

    @Inject
    lateinit var taskService: TaskService

    @GET
    @Path("/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    fun findById(@PathParam("taskId") taskId: Long): Response {
        val task = taskService.findById(taskId)
        return if (task != null) {
            Response.ok(task).build()
        } else {
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }

    @GET
    @Path("/users/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    fun findAllOfUser(@PathParam("userId") userId: Long): Response {
        return Response.ok(taskService.findAllOfUser(userId)).build()
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun create(createTask: CreateTask): Response {
        val task = taskService.create(createTask)
        val uri = "/tasks/${task.id}"
        return Response.created(java.net.URI(uri)).entity(task).build()
    }
}