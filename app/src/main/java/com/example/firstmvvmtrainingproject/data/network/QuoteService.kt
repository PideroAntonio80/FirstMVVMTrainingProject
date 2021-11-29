package com.example.firstmvvmtrainingproject.data.network

import com.example.firstmvvmtrainingproject.core.RetrofitHelper
import com.example.firstmvvmtrainingproject.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            /*Aquí debajo, "response.body()" me devolvería una lista de quotes, y con el operador
            elvis "?:" le digo que si la lista que me devuelve es nula, me de una lista vacía*/
            response.body() ?: emptyList()
        }
    }
}

// Línea 14, después de "val response" -->  : Response<List<QuoteModel>>