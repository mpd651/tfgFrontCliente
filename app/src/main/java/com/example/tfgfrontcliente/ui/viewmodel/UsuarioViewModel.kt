package com.example.tfgfrontcliente.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tfgfrontcliente.data.UsuarioRepository
import com.example.tfgfrontcliente.data.model.Usuario
import kotlinx.coroutines.launch

class UsuarioViewModel : ViewModel() {

    private val repository = UsuarioRepository()
    val usuarioModel = MutableLiveData<Usuario>()


    fun loginMethod(usuario:Usuario){
        viewModelScope.launch {
            val result:Usuario?=repository.login(usuario)
            usuarioModel.postValue(result?:null)

        }
    }

    fun registrarMethod(usuario:Usuario){
        viewModelScope.launch {
            val result:Usuario?=repository.registrar(usuario)
            usuarioModel.postValue(result?:null)

        }
    }
}