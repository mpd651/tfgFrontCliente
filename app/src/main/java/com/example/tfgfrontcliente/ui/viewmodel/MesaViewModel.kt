package com.example.tfgfrontcliente.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tfgfrontcliente.data.MesaRepository
import com.example.tfgfrontcliente.data.model.Mesa
import kotlinx.coroutines.launch

class MesaViewModel :ViewModel() {

    private val repository = MesaRepository()

    val mesasModel = MutableLiveData<List<Mesa>>()
    val mesaModel = MutableLiveData<Mesa>()

    fun getAllMesas(){
        viewModelScope.launch {
            val result:List<Mesa> = repository.getAllMesas()

            if (result!=null){
                mesasModel.postValue(result)
            }

        }
    }


    fun getMesaById(mesaId:Long){
        viewModelScope.launch {
            val result:Mesa? = repository.getMesaById(mesaId)

            if (result!=null){
                mesaModel.postValue(result!!)
            }

        }
    }
}