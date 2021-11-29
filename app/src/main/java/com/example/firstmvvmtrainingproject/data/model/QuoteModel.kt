package com.example.firstmvvmtrainingproject.data.model

import com.google.gson.annotations.SerializedName

data class QuoteModel (@SerializedName("image_url") val image: String, @SerializedName("description") val quote: String, @SerializedName("name") val author: String)