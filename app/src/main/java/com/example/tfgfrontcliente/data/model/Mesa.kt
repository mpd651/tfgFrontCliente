package com.example.tfgfrontcliente.data.model

import java.io.Serializable

data class Mesa(
    val id:Long? = null,
    val numeroMesa:String? = null,
    val borrado:Boolean? = null
):Serializable
