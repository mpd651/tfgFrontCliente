package com.example.tfgfrontcliente.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tfgfrontcliente.data.CategoriaRepository
import com.example.tfgfrontcliente.data.ProductoRepository
import com.example.tfgfrontcliente.data.dto.ProductoDto
import com.example.tfgfrontcliente.data.model.Categoria
import com.example.tfgfrontcliente.data.model.Producto
import kotlinx.coroutines.launch

class ProductoViewModel : ViewModel() {
    private val repository = ProductoRepository()

    val productosModelDto = MutableLiveData<List<ProductoDto>>()

    fun getProductosByCategoria(categoriaId: Long){
        viewModelScope.launch {
            val result:List<ProductoDto> = repository.getProductosByCategoria(categoriaId)
            productosModelDto.postValue(result)

        }
    }

}