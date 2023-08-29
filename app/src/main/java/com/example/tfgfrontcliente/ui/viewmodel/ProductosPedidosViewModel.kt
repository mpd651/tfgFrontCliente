package com.example.tfgfrontcliente.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tfgfrontcliente.data.CategoriaRepository
import com.example.tfgfrontcliente.data.ProductoRepository
import com.example.tfgfrontcliente.data.ProductosPedidoRepository
import com.example.tfgfrontcliente.data.dto.ProductosPedidoDto
import com.example.tfgfrontcliente.data.model.Categoria
import com.example.tfgfrontcliente.data.model.Producto
import com.example.tfgfrontcliente.data.model.ProductosPedido
import kotlinx.coroutines.launch

class ProductosPedidosViewModel : ViewModel() {
    private val repository = ProductosPedidoRepository()

    val productosPedidosModelDto = MutableLiveData<List<ProductosPedidoDto>>()

    fun getProductosPedidoByPedidoId(pedidoId: Long){
        viewModelScope.launch {
            val result:List<ProductosPedidoDto> = repository.getProductosPedidoByPedidoId(pedidoId)
            productosPedidosModelDto.postValue(result)

        }
    }

}