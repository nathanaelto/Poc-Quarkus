package io.to.order

import io.to.order.dto.CreateOrder
import io.to.order.entities.Order
import io.to.product.ProductService
import io.to.user.UserService
import javax.inject.Inject
import javax.inject.Singleton
import javax.ws.rs.BadRequestException
import javax.ws.rs.InternalServerErrorException
import kotlin.math.roundToInt

@Singleton
class OrderService {
    @Inject
    lateinit var orderRepository: OrderRepository

    @Inject
    lateinit var productService: ProductService

    @Inject
    lateinit var userService: UserService

    fun findAll(): List<Order> {
        return orderRepository.findAll().list()
    }

    fun findById(orderId: Long): Order? {
        return orderRepository.findById(orderId)
    }

    fun findByUserId(userId: Long): List<Order> {
        return orderRepository.findByUserId(userId)
    }

    fun create(createOrder: CreateOrder): Order {
        val user = userService.findById(createOrder.userId) ?: throw BadRequestException("User not found")
        val products = productService.findByIds(createOrder.products.map { it.productId })
        if (products.size != createOrder.products.size) {
            throw BadRequestException("Some products not found")
        }

        val order = Order()
        order.user = user
        order.products = products

        val totalPrice = createOrder.products.map { productOrder ->
            val product = products.find { it.id == productOrder.productId }
                ?: throw InternalServerErrorException("Product not found")
            product.price!! * productOrder.quantity
        }.sum()
        order.totalPrice = (totalPrice * 100.0).roundToInt() / 100.0

        orderRepository.persist(order)
        return order
    }
}