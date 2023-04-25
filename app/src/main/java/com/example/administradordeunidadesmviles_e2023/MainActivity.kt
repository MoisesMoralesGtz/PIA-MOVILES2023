package com.example.administradordeunidadesmviles_e2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.administradordeunidadesmviles_e2023.databinding.ActivityMainBinding
import com.example.administradordeunidadesmviles_e2023.ValoresGlobales

import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.firestore.FirebaseFirestore

private lateinit var firebaseAuth: FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth

    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIngresar.setOnClickListener{

            db.collection("empleados").document("s").set(
                hashMapOf("NombreCompleto" to "TILINES A TIERRA",
                    "Password" to "YA LLEGO",
                    "Usuario" to "TILIN",
                    "esAdministrador" to false,
                    "idEmpleado" to 1
                    )
            )


            Toast.makeText(this,"FUNCIONO",Toast.LENGTH_SHORT).show()

            val intent = Intent(this, main_administrador::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_right_in, R.anim.from_left_out)

        }

        binding.txtNuevaCuenta.setOnClickListener {
            val intent = Intent(this, nuevo_usuario::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_down_in, R.anim.from_up_out)
        }
    }
}