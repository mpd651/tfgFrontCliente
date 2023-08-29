package com.example.tfgfrontcliente.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.tfgfrontcliente.R
import com.example.tfgfrontcliente.data.model.Usuario
import com.example.tfgfrontcliente.ui.viewmodel.UsuarioViewModel

class RegistrarActivity : AppCompatActivity() {

    private val usuarioViewModel: UsuarioViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        val btnRegistrar: Button = findViewById(R.id.btnRegistrar)
        val inputUsername: EditText = findViewById(R.id.txtUsernameRegistrar);
        val inputContrasena: EditText = findViewById(R.id.txtContrasenaRegistrar);
        val inputNombre: EditText=findViewById(R.id.txtNombre)
        val inputApellidos: EditText = findViewById(R.id.txtApellidos)
        val linkToLogin:TextView = findViewById(R.id.linkToLogin)

        fun validarDatos(): Boolean{
            if (inputUsername.text.toString().trim().isEmpty()){
                val toast = Toast.makeText(this, "El campo Usuario esta vacío", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
                inputUsername.requestFocus()
                return false
            }
            if (inputContrasena.text.toString().trim().isEmpty()){
                val toast = Toast.makeText(this, "El campo Contraseña esta vacío", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
                inputContrasena.requestFocus()
                return false
            }
            if (inputNombre.text.toString().trim().isEmpty()){
                val toast = Toast.makeText(this, "El campo Nombre esta vacío", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
                inputNombre.requestFocus()
                return false
            }

            return true
        }

        btnRegistrar.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?){

                if (validarDatos()==true){
                    val usuario = Usuario()
                    usuario.userName=inputUsername.text.toString()
                    usuario.password=inputContrasena.text.toString()
                    usuario.rol="CLIENTE"
                    usuario.nombre=inputNombre.text.toString()
                    usuario.apellidos=inputApellidos.text.toString()

                    usuarioViewModel.registrarMethod(usuario)
                    usuarioViewModel.usuarioModel.observe(this@RegistrarActivity, Observer {
                        if (it!=null){
                            val toast = Toast.makeText(this@RegistrarActivity, "Registro completado", Toast.LENGTH_SHORT)
                            toast.setGravity(Gravity.CENTER, 0, 0)
                            toast.show()
                            inputUsername.setText("")
                            inputContrasena.setText("")
                            inputApellidos.setText("")
                            inputNombre.setText("")
                        }else{
                            val toast = Toast.makeText(this@RegistrarActivity, "Registro erroneo", Toast.LENGTH_SHORT)
                            toast.setGravity(Gravity.CENTER, 0, 0)
                            toast.show()
                            inputUsername.setText("")
                            inputContrasena.setText("")
                            inputApellidos.setText("")
                            inputNombre.setText("")
                        }
                    })


                }

            }
        })

        linkToLogin.setOnClickListener(object:View.OnClickListener{
            override fun onClick(view: View?) {
                val intent = Intent(this@RegistrarActivity, LoginActivity::class.java )
                inputUsername.setText("")
                inputContrasena.setText("")
                inputApellidos.setText("")
                inputNombre.setText("")
                startActivity(intent)
            }
        })
    }
}