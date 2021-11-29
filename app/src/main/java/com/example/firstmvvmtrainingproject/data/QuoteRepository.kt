package com.example.firstmvvmtrainingproject.data

import com.example.firstmvvmtrainingproject.data.model.QuoteModel
import com.example.firstmvvmtrainingproject.data.model.QuoteProvider
import com.example.firstmvvmtrainingproject.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}
