package com.example.tfgfrontcliente.data.network

import com.example.tfgfrontcliente.core.RetrofitHelper
import com.example.tfgfrontcliente.data.model.Categoria
import com.example.tfgfrontcliente.data.model.Pedido
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoriaService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAllCategorias(): List<Categoria> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(CategoriaApiClient::class.java).getAllCategorias()
            response.body() ?: emptyList()
        }
    }
}