package com.example.tfgfrontcliente.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tfgfrontcliente.R
import com.example.tfgfrontcliente.data.dto.PedidoDto
import com.example.tfgfrontcliente.data.model.Mesa
import com.example.tfgfrontcliente.data.model.Pedido
import com.example.tfgfrontcliente.data.model.ProductosPedido
import com.example.tfgfrontcliente.data.model.Usuario
import com.example.tfgfrontcliente.ui.viewmodel.PedidoViewModel
import com.example.tfgfrontcliente.ui.viewmodel.ProductosPedidosViewModel

class PedidoActivity : AppCompatActivity(), AdapterRecyclerView.OnItemClickListener {

    private val pedidoViewModel: PedidoViewModel by viewModels()
    private val productosPedidoViewModel: ProductosPedidosViewModel by viewModels()

    var precioProductosPedidoRecibido:Float = 0F
    var precioProductosNuevos:Float = 0F
    var precioTotal:Float = 0F
    var productosNuevosLista:MutableList<ProductosPedido> = emptyList<ProductosPedido>().toMutableList()
    lateinit var pedidoRecibido:PedidoDto
    lateinit var mesa:Mesa
    lateinit var usuario:Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido)

        mesa = intent.getSerializableExtra("mesa")as Mesa
        usuario = intent.getSerializableExtra("usuario")as Usuario
        pedidoRecibido = (intent.getSerializableExtra("pedido") as? PedidoDto)!!
        val productosNuevos = intent.getSerializableExtra("productosNuevos") as? MutableMap<String, ProductosPedido>
        productosNuevosLista=productosNuevos!!.values.toMutableList()

        findViewById<TextView>(R.id.txtUser).setText("Usuario: "+usuario.userName)
        findViewById<TextView>(R.id.txtMesa).setText("Mesa: "+mesa.numeroMesa)


        for (productoNuevo in productosNuevos!!.values.toList()){
            val cantidad: Int? = productoNuevo.cantidad
            val preci: Float? = productoNuevo.producto?.precio
            precioProductosNuevos += cantidad!! * preci!!
        }

        val items = mutableListOf<String>()
        if (pedidoRecibido.id != -1L) {

            productosPedidoViewModel.getProductosPedidoByPedidoId(pedidoRecibido.id)
            productosPedidoViewModel.productosPedidosModelDto.observe(this@PedidoActivity, Observer{
                for (productoPedido in it){
                    val cantidad: Int? = productoPedido.cantidad
                    val nombre: String? = productoPedido.productoNombre
                    val preci: Float? = productoPedido.productoPrecio
                    precioProductosPedidoRecibido += cantidad!! * preci!!
                    val item:String = cantidad.toString()+"x "+nombre+"   "+(cantidad!!*preci!!).toString()+" €"
                    items.add(item)
                }
                var listview = findViewById<ListView>(R.id.lstProductosPedidos)
                var arrayAdapter : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
                listview.adapter = arrayAdapter

                precioTotal=precioProductosNuevos+precioProductosPedidoRecibido
                findViewById<TextView>(R.id.txtTotal).setText("Total: "+(precioTotal)+" €")
            })

        }


        val recyclerView = findViewById<RecyclerView>(R.id.productosPedidosNuevos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = AdapterRecyclerView(productosNuevos!!.values.toMutableList())
        adapter.setOnItemClickListener(this)
        recyclerView.adapter = adapter


        findViewById<Button>(R.id.btnSolicitar).setOnClickListener{
            val productosEnviar:List<ProductosPedido> = productosNuevosLista.filterNot { it.cantidad == 0 }.toMutableList()

            if (pedidoRecibido!!.id==-1L){
                var pedidoObject :Pedido = Pedido(mesa = mesa, productosPedidos = productosEnviar)
                pedidoViewModel.crearPedido(pedidoObject, usuario.id!!)
            }else{
                var pedidoObject :Pedido = Pedido(id= pedidoRecibido.id,productosPedidos = productosEnviar)
                pedidoViewModel.actualizarPedido(pedidoObject, usuario.id!!)
            }

            pedidoViewModel.pedidoIdDevuelto.observe(this, Observer {
                val intent = Intent(this@PedidoActivity, CategoriaProductoActivity::class.java )
                intent.putExtra("usuario", usuario)
                intent.putExtra("mesa", mesa)
                this@PedidoActivity.finish()
                startActivity(intent)
            })

        }
    }

    override fun onItemClick(productosDevueltos: MutableList<ProductosPedido>) {
        precioProductosNuevos=0F
        precioTotal=0F

        for (productoNuevo in productosDevueltos){
            val cantidad: Int? = productoNuevo.cantidad
            val preci: Float? = productoNuevo.producto?.precio
            precioProductosNuevos += cantidad!! * preci!!
        }
        precioTotal=precioProductosNuevos+precioProductosPedidoRecibido
        findViewById<TextView>(R.id.txtTotal).setText("Total: "+(precioTotal)+" €")
        productosNuevosLista=productosDevueltos
    }

    override fun onBackPressed()
    {
        val productosEnviar:List<ProductosPedido> = productosNuevosLista.filterNot { it.cantidad == 0 }.toMutableList()
        val intent = Intent(this@PedidoActivity, CategoriaProductoActivity::class.java )
        intent.putExtra("usuario", usuario)
        intent.putExtra("mesa", mesa)
        intent.putExtra("productosActualizados", ArrayList(productosEnviar))
        this@PedidoActivity.finish()
        startActivity(intent)
    }
}