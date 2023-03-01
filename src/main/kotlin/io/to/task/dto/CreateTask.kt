package io.to.task.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.to.task.entities.TaskStatus

data class CreateTask(
    @JsonProperty("content")
    val content: String,

    @JsonProperty("status")
    val status: TaskStatus,

    @JsonProperty("userId")
    val userId: Long
)