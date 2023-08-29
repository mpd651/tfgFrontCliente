package com.example.tfgfrontcliente.data

import com.example.tfgfrontcliente.data.dto.ProductoDto
import com.example.tfgfrontcliente.data.model.Pedido
import com.example.tfgfrontcliente.data.model.Producto
import com.example.tfgfrontcliente.data.network.ProductoService
import com.example.tfgfrontcliente.data.network.UsuarioService

class ProductoRepository {
    private val api = ProductoService()

    suspend fun getProductosByCategoria(categoriaId:Long): List<ProductoDto> {
        val response = api.getProductosByCategoria(categoriaId)
        return response
    }
}