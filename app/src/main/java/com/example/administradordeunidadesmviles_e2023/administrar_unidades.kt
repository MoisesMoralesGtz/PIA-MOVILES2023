package com.example.administradordeunidadesmviles_e2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.administradordeunidadesmviles_e2023.databinding.ActivityAdministrarUnidadesBinding

class administrar_unidades : AppCompatActivity() {
    private lateinit var binding:ActivityAdministrarUnidadesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdministrarUnidadesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textInputLayoutNCUENTA.setOnClickListener {
            val intent = Intent(this, unidad_existente::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_right_in, R.anim.from_left_out)
        }

        binding.btnEstadoU.setOnClickListener{
            val intent = Intent(this, nueva_unidad::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_right_in, R.anim.from_left_out)
        }

        binding.btnCerrarSesion.setOnClickListener{
            val intent = Intent(this, main_administrador::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_left_in, R.anim.from_right_out)
        }
    }
}