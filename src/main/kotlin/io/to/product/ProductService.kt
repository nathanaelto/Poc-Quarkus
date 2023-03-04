package io.to.product

import io.to.product.dto.CreateProduct
import io.to.product.entities.Product
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductService {
    @Inject
    lateinit var productRepository: ProductRepository

    fun create(createProduct: CreateProduct): Product {
        val product = Product()
        product.name = createProduct.name
        product.description = createProduct.description
        product.price = createProduct.price
        productRepository.persist(product)
        return product
    }

    fun findById(productId: Long): Product? {
        return productRepository.findById(productId)
    }

    fun findAll(): List<Product> {
        return productRepository.findAll().list()
    }

    fun findByIds(productIds: List<Long>): List<Product> {
        return productRepository.list("id in ?1", productIds)
    }
}