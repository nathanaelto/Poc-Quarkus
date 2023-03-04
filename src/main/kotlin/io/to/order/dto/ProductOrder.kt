package io.to.order.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductOrder (
    @JsonProperty("productId")
    val productId: Long,

    @JsonProperty("quantity")
    val quantity: Int
)