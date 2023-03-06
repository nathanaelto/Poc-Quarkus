package io.to

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/welcome")
class DefaultResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun welcome() = "Welcome to Quarkus Kotlin POC!"
}