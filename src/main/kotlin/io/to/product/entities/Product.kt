package io.to.product.entities

import javax.persistence.*

@Entity
@Table(name = "products")
class Product {
    @Id
    @GeneratedValue
    var id: Long? = null

    lateinit var name: String
    lateinit var description: String
    var price: Double? = null
}