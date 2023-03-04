package io.to.order.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateOrder(
    @JsonProperty("userId")
    val userId: Long,

    @JsonProperty("products")
    val products: List<ProductOrder>
)
