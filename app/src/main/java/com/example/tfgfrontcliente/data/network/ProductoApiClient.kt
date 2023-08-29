package com.example.tfgfrontcliente.data.network

import com.example.tfgfrontcliente.data.dto.ProductoDto
import com.example.tfgfrontcliente.data.model.Categoria
import com.example.tfgfrontcliente.data.model.Producto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ProductoApiClient {
    @GET("producto/categoria/categoriaId")
    @Headers("Accept: application/json")
    suspend fun getProductosByCategoria(@Query("categoriaId") categoriaId: Long): Response<List<ProductoDto>>
}