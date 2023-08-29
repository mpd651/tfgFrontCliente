package com.example.tfgfrontcliente.data.network

import com.example.tfgfrontcliente.core.RetrofitHelper
import com.example.tfgfrontcliente.data.dto.ProductoDto
import com.example.tfgfrontcliente.data.model.Pedido
import com.example.tfgfrontcliente.data.model.Producto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductoService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getProductosByCategoria(categoriaId:Long): List<ProductoDto> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ProductoApiClient::class.java).getProductosByCategoria(categoriaId)
            response.body() ?: emptyList()
        }
    }
}