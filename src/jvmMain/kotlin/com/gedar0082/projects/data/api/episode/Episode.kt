package com.gedar0082.projects.data.api.episode

data class Episode(
    val id: Int,
    val name: String,
    val airDate: String,
    val episode: String,
    val character: List<String>,
    val url: String,
    val created: String
)