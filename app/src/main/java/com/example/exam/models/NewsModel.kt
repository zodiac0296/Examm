package com.example.exam.models

import java.io.Serializable


data class NewsModel(
    var category: Categories,
    var description: String,
    var name: String,
    var imageUrl: String
) : Serializable
