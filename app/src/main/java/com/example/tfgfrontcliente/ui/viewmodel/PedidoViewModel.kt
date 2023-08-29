package com.example.tfgfrontcliente.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tfgfrontcliente.data.model.Pedido
import com.example.tfgfrontcliente.data.PedidoRepository
import com.example.tfgfrontcliente.data.dto.PedidoDto
import kotlinx.coroutines.launch

class PedidoViewModel: ViewModel() {

    private val repository = PedidoRepository()

    val pedidoModel = MutableLiveData<Pedido>()
    val pedidoModelDto = MutableLiveData<PedidoDto>()
    val pedidoIdDevuelto = MutableLiveData<Long>()


    fun getPedidoByMesaId(mesaId: Long){
        viewModelScope.launch {
            val result:PedidoDto? = repository.getPedidoByMesaId(mesaId)
            pedidoModelDto.postValue(result?:null)

        }
    }

    fun crearPedido(pedido: Pedido, usuarioId: Long){
        viewModelScope.launch {
            val result: Long?=repository.crearPedido(pedido, usuarioId)
            pedidoIdDevuelto.postValue(result?:null)
        }
    }

    fun actualizarPedido(pedido: Pedido, usuarioId: Long){
        viewModelScope.launch {
            val result: Long?=repository.actualizarPedido(pedido, usuarioId)
            pedidoIdDevuelto.postValue(result?:null)
        }
    }

}