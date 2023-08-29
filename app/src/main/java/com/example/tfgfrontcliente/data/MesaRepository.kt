package com.example.tfgfrontcliente.data

import com.example.tfgfrontcliente.data.model.Mesa
import com.example.tfgfrontcliente.data.network.MesaService

class MesaRepository {
    private val api = MesaService()

    suspend fun getAllMesas():List<Mesa>{
        val response = api.getMesas()
        return response
    }

    suspend fun getMesaById(mesaId:Long):Mesa?{
        val response = api.getMesaById(mesaId)
        return response?:null
    }
}