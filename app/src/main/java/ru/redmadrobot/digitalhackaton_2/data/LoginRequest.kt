package ru.redmadrobot.digitalhackaton_2.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginRequest(
    @field:Json(name = "username")
    val username: String,

    @field:Json(name = "password")
    val password: String
)
