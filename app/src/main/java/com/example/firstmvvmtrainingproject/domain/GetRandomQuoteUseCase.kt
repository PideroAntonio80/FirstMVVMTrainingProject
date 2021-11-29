package com.example.firstmvvmtrainingproject.domain

import com.example.firstmvvmtrainingproject.data.model.QuoteModel
import com.example.firstmvvmtrainingproject.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    operator  fun invoke(): QuoteModel? {
        val quotes: List<QuoteModel> = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random() // <-- Esto de indices es igual que poner: (0..quotes.size - 1).random()
            return quotes[randomNumber]
        }
        return null
    }
}