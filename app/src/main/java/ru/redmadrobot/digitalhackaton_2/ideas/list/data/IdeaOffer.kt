package ru.redmadrobot.digitalhackaton_2.ideas.list.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IdeaOffer(
    @field:Json(name = "id")
    val id: Int,

    @field:Json(name = "like_count")
    val likeCount: String,
    @field:Json(name = "comment_count")
    val commentCount: Int,
    @field:Json(name = "idealike_set")
    val likeSet: List<IdeaLike>,
    @field:Json(name = "ideacomment_set")
    val commentSet: List<IdeaComment>,

    @field:Json(name = "status")
    val status: Int,

    @field:Json(name = "created")
    val created: String,

    @field:Json(name = "modified")
    val modified: String,

    @field:Json(name = "theme")
    val theme: String,

    @field:Json(name = "description")
    val description: String,

    @field:Json(name = "tags")
    val tags: List<Int>,

    @field:Json(name = "themes")
    val themeId: Int
)

