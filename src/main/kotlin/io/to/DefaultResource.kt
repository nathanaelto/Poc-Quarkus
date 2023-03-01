package io.to

import org.eclipse.microprofile.config.inject.ConfigProperty
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/welcome")
class DefaultResource {

    @ConfigProperty(name = "greeting.developer")
    lateinit var developer: String

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun welcome() = "Welcome to Quarkus Kotlin POC by !"

    @GET
    @Path("/2")
    @Produces(MediaType.TEXT_PLAIN)
    fun welcome2() = "Welcome 2 by natha"
}