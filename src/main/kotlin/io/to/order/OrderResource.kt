package io.to.order

import io.to.order.dto.CreateOrder
import javax.inject.Inject
import javax.transaction.Transactional
import javax.ws.rs.*
import javax.ws.rs.core.Response

@Path("/orders")
class OrderResource {

    @Inject
    lateinit var orderService: OrderService

    @POST
    @Transactional
    @Consumes("application/json")
    @Produces("application/json")
    fun create(createOrder: CreateOrder): Response {
        val order = orderService.create(createOrder)
        val uri = "/orders/${order.id}"
        return Response.created(java.net.URI(uri)).entity(order).build()
    }

    @GET
    @Produces("application/json")
    fun findAll(): Response {
        return Response.ok(orderService.findAll()).build()
    }

    @GET
    @Path("/user/{userId}")
    @Produces("application/json")
    fun findByUserId(@PathParam("userId") userId: Long): Response {
        return Response.ok(orderService.findByUserId(userId)).build()
    }

    @GET
    @Path("/{orderId}")
    @Produces("application/json")
    fun findById(@PathParam("orderId") orderId: Long): Response {
        val order = orderService.findById(orderId) ?: throw NotFoundException()
        return Response.ok(order).build()
    }
}