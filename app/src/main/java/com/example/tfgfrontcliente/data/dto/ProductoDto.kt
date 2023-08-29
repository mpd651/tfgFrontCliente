package com.example.tfgfrontcliente.data.dto

import com.example.tfgfrontcliente.data.model.Categoria
import com.example.tfgfrontcliente.data.model.ProductosPedido

data class ProductoDto(
    val id:Long,
    val nombre:String,
    val precio:Float,
    val categoria: Categoria,
    val borrado:Boolean
)
