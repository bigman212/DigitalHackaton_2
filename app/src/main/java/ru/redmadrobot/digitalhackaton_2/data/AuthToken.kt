package ru.redmadrobot.digitalhackaton_2.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AuthToken(
    @field:Json(name = "key")
    val value: String
)
