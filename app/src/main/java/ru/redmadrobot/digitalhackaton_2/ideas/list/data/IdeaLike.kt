package ru.redmadrobot.digitalhackaton_2.ideas.list.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IdeaLike(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "created")
    val created: String,
    @field:Json(name = "modified")
    val modified: String,
    @field:Json(name = "idea")
    val idea: Int
)
