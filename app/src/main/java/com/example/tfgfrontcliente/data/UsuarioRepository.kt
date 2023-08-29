package com.example.tfgfrontcliente.data

import com.example.tfgfrontcliente.data.model.Usuario
import com.example.tfgfrontcliente.data.network.UsuarioService

class UsuarioRepository {
    private val api = UsuarioService()

    suspend fun getAllUsuarios():List<Usuario>{
        val response = api.getUsuarios()
        return response
    }

    suspend fun login(usuario:Usuario):Usuario?{
        val response = api.login(usuario)
        return response
    }

    suspend fun registrar(usuario:Usuario):Usuario?{
        val response = api.registrar(usuario)
        return response
    }
}