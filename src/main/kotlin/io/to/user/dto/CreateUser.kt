package io.to.user.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateUser (
    @JsonProperty("name")
    val name: String,

    @JsonProperty("email")
    val email: String,

    @JsonProperty("password")
    val password: String
)