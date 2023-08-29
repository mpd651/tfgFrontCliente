package com.example.tfgfrontcliente.data.dto

import com.example.tfgfrontcliente.data.model.Pedido
import com.example.tfgfrontcliente.data.model.Producto

data class ProductosPedidoDto(
    var productoPedidoid:Long?=null,
    var cantidad: Int?=null,
    var hora: String?=null,
    var productoNombre: String?=null,
    var productoPrecio: Float?=null)
