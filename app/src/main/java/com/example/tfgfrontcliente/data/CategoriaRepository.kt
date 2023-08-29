package com.example.tfgfrontcliente.data

import com.example.tfgfrontcliente.data.model.Categoria
import com.example.tfgfrontcliente.data.model.Usuario
import com.example.tfgfrontcliente.data.network.CategoriaService
import com.example.tfgfrontcliente.data.network.UsuarioService

class CategoriaRepository {
    private val api = CategoriaService()

    suspend fun getAllCategorias():List<Categoria>{
        val response = api.getAllCategorias()
        return response
    }

}