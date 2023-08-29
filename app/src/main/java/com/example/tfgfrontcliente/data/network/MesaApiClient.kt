package com.example.tfgfrontcliente.data.network

import com.example.tfgfrontcliente.data.model.Mesa
import com.example.tfgfrontcliente.data.model.Usuario
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MesaApiClient {

    @GET("mesa")
    @Headers("Accept: application/json")
    suspend fun getAllMesas(): Response<List<Mesa>>

    @GET("mesa/id")
    @Headers("Accept: application/json")
    suspend fun getMesaById(@Query("id") mesaId: Long): Response<Mesa>
}