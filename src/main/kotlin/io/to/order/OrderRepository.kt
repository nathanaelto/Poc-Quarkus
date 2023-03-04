package io.to.order

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import io.to.order.entities.Order
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class OrderRepository : PanacheRepository<Order> {
    fun findByUserId(userId: Long): List<Order> {
        return find("user.id", userId).list()
    }
}