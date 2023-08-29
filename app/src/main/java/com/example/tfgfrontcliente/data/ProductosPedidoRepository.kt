package com.example.tfgfrontcliente.data

import com.example.tfgfrontcliente.data.dto.ProductosPedidoDto
import com.example.tfgfrontcliente.data.model.Pedido
import com.example.tfgfrontcliente.data.model.Producto
import com.example.tfgfrontcliente.data.model.ProductosPedido
import com.example.tfgfrontcliente.data.network.ProductoService
import com.example.tfgfrontcliente.data.network.ProductosPedidoService
import com.example.tfgfrontcliente.data.network.UsuarioService

class ProductosPedidoRepository {
    private val api = ProductosPedidoService()

    suspend fun getProductosPedidoByPedidoId(pedidoId:Long): List<ProductosPedidoDto> {
        val response = api.getProductosPedidoByPedidoId(pedidoId)
        return response
    }
}