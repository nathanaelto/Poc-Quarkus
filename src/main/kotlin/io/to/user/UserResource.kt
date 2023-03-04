package io.to.user

import io.to.user.dto.CreateUser
import io.to.user.entities.User
import javax.inject.Inject
import javax.transaction.Transactional
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/users")
class UserResource {
    @Inject
    lateinit var userService: UserService

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun findAll(): Response {
        return Response.ok(userService.findAll()).build()
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun create(@Valid createUser: CreateUser): Response {
        val user = userService.create(createUser)
        val uri = "/users/${user.id}"
        return Response.created(java.net.URI(uri)).entity(user).build()
    }

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    fun findById(@PathParam("userId") userId: Long): Response {
        val user = userService.findById(userId)
        return if (user != null) {
            Response.ok(user).build()
        } else {
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }

    @DELETE
    @Path("/{userId}")
    fun delete(@PathParam("userId") userId: Long): Response {
        val user = userService.findById(userId)
        return if (user != null) {
            userService.delete(user)
            Response.ok().build()
        } else {
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }
}