package com.example.tfgfrontcliente.data.network

import com.example.tfgfrontcliente.core.RetrofitHelper
import com.example.tfgfrontcliente.data.model.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UsuarioService {

    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getUsuarios(): List<Usuario> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(UsuarioApiClient::class.java).getAllUsuarios()
            response.body() ?: emptyList()
        }
    }

    suspend fun login(usuario:Usuario): Usuario? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(UsuarioApiClient::class.java).login(usuario)
            response.body()?:null
        }
    }

    suspend fun registrar(usuario:Usuario): Usuario? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(UsuarioApiClient::class.java).registrar(usuario)
            response.body()?:null
        }
    }
}