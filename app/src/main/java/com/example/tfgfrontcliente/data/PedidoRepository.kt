package com.example.tfgfrontcliente.data

import com.example.tfgfrontcliente.data.dto.PedidoDto
import com.example.tfgfrontcliente.data.model.Pedido
import com.example.tfgfrontcliente.data.network.PedidoService

class PedidoRepository {
    private val api = PedidoService()

    suspend fun getPedidoByMesaId(mesaId:Long): PedidoDto? {
        val response = api.getPedidoByMesaId(mesaId)
        return response
    }

    suspend fun crearPedido(pedido: Pedido, usuarioId:Long): Long? {
        val response = api.crearPedido(pedido, usuarioId)
        return response
    }

    suspend fun actualizarPedido(pedido:Pedido, usuarioId:Long): Long? {
        val response = api.actualizarPedido(pedido, usuarioId)
        return response
    }
}