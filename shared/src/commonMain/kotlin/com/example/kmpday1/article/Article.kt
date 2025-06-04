package com.example.kmpday1.article

import kotlinx.serialization.Serializable

@Serializable
data class Article (
    val title : String,
    val publishedAt:String,
    val description:String,
    val urlToImage : String
)