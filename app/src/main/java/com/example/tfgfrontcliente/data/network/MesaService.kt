package com.example.tfgfrontcliente.data.network

import com.example.tfgfrontcliente.core.RetrofitHelper
import com.example.tfgfrontcliente.data.model.Mesa
import com.example.tfgfrontcliente.data.model.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MesaService {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getMesas(): List<Mesa> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(MesaApiClient::class.java).getAllMesas()
            response.body() ?: emptyList()
        }
    }

    suspend fun getMesaById(mesaId:Long): Mesa? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(MesaApiClient::class.java).getMesaById(mesaId)
            response.body()?:null
        }
    }

}