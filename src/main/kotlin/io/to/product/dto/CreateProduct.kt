package io.to.product.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateProduct (
    @JsonProperty("name")
    val name: String,

    @JsonProperty("description")
    val description: String,

    @JsonProperty("price")
    val price: Double
)