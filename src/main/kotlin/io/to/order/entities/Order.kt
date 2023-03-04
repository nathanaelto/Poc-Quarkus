package io.to.order.entities

import io.to.product.entities.Product
import io.to.user.entities.User
import javax.persistence.*

@Entity
@Table(name = "orders")
class Order {
    @Id
    @GeneratedValue
    var id: Long? = null

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    lateinit var user: User

    var totalPrice: Double? = null

    @ManyToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.PERSIST, CascadeType.MERGE]
    )
    @JoinTable(
        name = "order_products",
        joinColumns = [JoinColumn(name = "order_id")],
        inverseJoinColumns = [JoinColumn(name = "product_id")]
    )
    var products: List<Product> = emptyList()
}