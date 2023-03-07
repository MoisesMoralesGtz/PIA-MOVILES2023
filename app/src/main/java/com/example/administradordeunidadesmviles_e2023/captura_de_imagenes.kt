package com.example.administradordeunidadesmviles_e2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.administradordeunidadesmviles_e2023.databinding.ActivityCapturaDeImagenesBinding

class captura_de_imagenes : AppCompatActivity() {
    private lateinit var binding:ActivityCapturaDeImagenesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCapturaDeImagenesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnContinuar.setOnClickListener{
            val intent = Intent(this, main_empleado::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_right_in, R.anim.from_left_out)
        }

        binding.btnVolver.setOnClickListener{
            val intent = Intent(this, inicio_turno_empleado::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_left_in, R.anim.from_right_out)
        }

    }
}