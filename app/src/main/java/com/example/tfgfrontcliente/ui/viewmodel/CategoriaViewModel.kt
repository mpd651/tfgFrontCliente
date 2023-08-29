package com.example.tfgfrontcliente.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tfgfrontcliente.data.CategoriaRepository
import com.example.tfgfrontcliente.data.PedidoRepository
import com.example.tfgfrontcliente.data.model.Categoria
import com.example.tfgfrontcliente.data.model.Usuario
import kotlinx.coroutines.launch

class CategoriaViewModel: ViewModel() {

    private val repository = CategoriaRepository()

    val categoriasModel = MutableLiveData<List<Categoria>>()

    fun getAllCategorias(){
        viewModelScope.launch {
            val result:List<Categoria> = repository.getAllCategorias()
            categoriasModel.postValue(result)

        }
    }

}