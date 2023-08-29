package com.example.tfgfrontcliente.data.network

import com.example.tfgfrontcliente.data.model.Categoria
import com.example.tfgfrontcliente.data.model.Usuario
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface CategoriaApiClient {
    @GET("categoria")
    @Headers("Accept: application/json")
    suspend fun getAllCategorias(): Response<List<Categoria>>
}