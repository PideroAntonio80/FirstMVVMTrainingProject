package com.example.firstmvvmtrainingproject.data.network

import com.example.firstmvvmtrainingproject.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("beers")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}