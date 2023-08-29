package com.example.tfgfrontcliente.data.network

import com.example.tfgfrontcliente.core.RetrofitHelper
import com.example.tfgfrontcliente.data.dto.PedidoDto
import com.example.tfgfrontcliente.data.model.Pedido
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PedidoService {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getPedidoByMesaId(mesaId:Long): PedidoDto? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(PedidoApiClient::class.java).getPedidoByMesaId(mesaId)
            response.body() ?: null
        }
    }

    suspend fun crearPedido(pedido: Pedido, usuarioId:Long): Long? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(PedidoApiClient::class.java).crearPedido(usuarioId, pedido)
            response.body()
        }
    }

    suspend fun actualizarPedido(pedido:Pedido, usuarioId:Long): Long? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(PedidoApiClient::class.java).actualizarPedido(usuarioId, pedido.id!!, pedido)
            response.body()
        }
    }
}