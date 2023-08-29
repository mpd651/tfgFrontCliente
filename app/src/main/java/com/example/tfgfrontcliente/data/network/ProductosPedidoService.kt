package com.example.tfgfrontcliente.data.network

import com.example.tfgfrontcliente.core.RetrofitHelper
import com.example.tfgfrontcliente.data.dto.ProductosPedidoDto
import com.example.tfgfrontcliente.data.model.Pedido
import com.example.tfgfrontcliente.data.model.Producto
import com.example.tfgfrontcliente.data.model.ProductosPedido
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductosPedidoService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getProductosPedidoByPedidoId(pedidoId:Long): List<ProductosPedidoDto> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ProductosPedidoApiClient::class.java).getProductosPedidoByPedidoId(pedidoId)
            response.body() ?: emptyList()
        }
    }
}