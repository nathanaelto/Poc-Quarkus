package io.to.product

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import io.to.product.entities.Product
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ProductRepository : PanacheRepository<Product> {
}