package io.to.product

import io.to.product.dto.CreateProduct
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

@Path("/products")
class ProductResource {

    @Inject
    lateinit var productService: ProductService

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun create(createProduct: CreateProduct): Response {
        val product = productService.create(createProduct)
        val uri = "/products/${product.id}"
        return Response.created(java.net.URI(uri)).entity(product).build()
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun findAll(): Response {
        return Response.ok(productService.findAll()).build()
    }

    @GET
    @Path("/{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    fun findById(@PathParam("productId") productId: Long): Response {
        val product = productService.findById(productId)
        return if (product != null) {
            Response.ok(product).build()
        } else {
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }
}