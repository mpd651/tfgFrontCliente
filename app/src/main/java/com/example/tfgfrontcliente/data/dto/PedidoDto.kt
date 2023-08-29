package com.example.tfgfrontcliente.data.dto

import com.example.tfgfrontcliente.data.model.ActualizacionPedido
import com.example.tfgfrontcliente.data.model.Mesa
import com.example.tfgfrontcliente.data.model.Pedido
import com.example.tfgfrontcliente.data.model.ProductosPedido
import java.io.Serializable

data class PedidoDto(
    val id:Long,
    var mesa: Mesa,
    var importe:Float,
    var fechaApertura: String,
    var fechaCierre: String,
    var pagado:Boolean,
    var anulado:Boolean,
    var asignadoCamarero:Boolean
): Serializable
