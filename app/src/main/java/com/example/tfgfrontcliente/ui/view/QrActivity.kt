package com.example.tfgfrontcliente.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.tfgfrontcliente.R
import com.example.tfgfrontcliente.data.model.Usuario
import com.example.tfgfrontcliente.ui.viewmodel.MesaViewModel
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions


class QrActivity : AppCompatActivity() {

    private val mesaViewModel: MesaViewModel by viewModels()
    private var mesaId:Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr)

        val usuario:Usuario = intent.getSerializableExtra("usuario")as Usuario
        findViewById<TextView>(R.id.txtUserQrLector).setText("Usuario: "+usuario.userName)


        findViewById<Button>(R.id.btnQr).setOnClickListener{
            barcodeLauncher.launch(ScanOptions())
        }

        mesaViewModel.mesaModel.observe(this, Observer {
            val intent = Intent(this@QrActivity, CategoriaProductoActivity::class.java )
            intent.putExtra("mesa", it)
            intent.putExtra("usuario", usuario)
            startActivity(intent)
        })

    }

    private val barcodeLauncher = registerForActivityResult<ScanOptions, ScanIntentResult>(
        ScanContract()
    ) { result: ScanIntentResult ->
        if (result.contents == null) {
            Toast.makeText(this@QrActivity, "Cancelado", Toast.LENGTH_LONG).show()
        } else {
            mesaId=result.contents.toLong()
            mesaViewModel.getMesaById(mesaId)
            Toast.makeText(this@QrActivity, "Escaneado", Toast.LENGTH_LONG)
                .show()
        }
    }


    override fun onBackPressed()
    {
            val intent = Intent(this@QrActivity, LoginActivity::class.java )
            this@QrActivity.finish()
            startActivity(intent)
    }


}