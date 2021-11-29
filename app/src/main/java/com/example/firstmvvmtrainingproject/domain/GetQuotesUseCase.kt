package com.example.firstmvvmtrainingproject.domain

import com.example.firstmvvmtrainingproject.data.QuoteRepository

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    /* Esta función de aquí debajo sirve para que cuando llame a esta clase "GetQuotesUseCase"
     desde otra parte, me devuelva directamente lo que aparece en esta función invoke (en este
     caso la lista de quotes)*/
    suspend operator fun invoke() = repository.getAllQuotes()

    /*Otra forma de escribirlo sería:
    suspend operator fun invoke(): List<QuoteModel>? {
        return repository.getAllQuotes()
    }*/
}


