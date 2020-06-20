package ru.redmadrobot.digitalhackaton_2.ideas.list.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "username")
    val username: String,
    @field:Json(name = "first_name")
    val firstName: String,
    @field:Json(name = "last_name")
    val lastName: String
)
