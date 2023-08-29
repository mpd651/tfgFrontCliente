package com.example.tfgfrontcliente.data.network

import com.example.tfgfrontcliente.data.dto.ProductosPedidoDto
import com.example.tfgfrontcliente.data.model.Categoria
import com.example.tfgfrontcliente.data.model.Producto
import com.example.tfgfrontcliente.data.model.ProductosPedido
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ProductosPedidoApiClient {
    @GET("productosPedido")
    @Headers("Accept: application/json")
    suspend fun getProductosPedidoByPedidoId(@Query("pedidoId") pedidoId: Long): Response<List<ProductosPedidoDto>>
}