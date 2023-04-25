package com.example.administradordeunidadesmviles_e2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.administradordeunidadesmviles_e2023.databinding.ActivityNuevoUsuarioBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class nuevo_usuario : AppCompatActivity() {
    private lateinit var binding:ActivityNuevoUsuarioBinding
    private lateinit var firebaseAuth: FirebaseAuth

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNuevoUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIngresar.setOnClickListener {


            db.collection("empleados").document(binding.inputUser.text.toString()).set(
                hashMapOf(
                    "password" to binding.inputContra.text.toString(),
                    "nombreCompleto" to binding.inputNombre.text.toString(),
                    "autorizado" to false,
                    "esAdministrador" to false
                )
            )

            val intent = Intent(this, main_empleado::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_right_in, R.anim.from_left_out)
        }

        binding.btnVolver.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_up_in, R.anim.from_down_out)
        }
    }
}