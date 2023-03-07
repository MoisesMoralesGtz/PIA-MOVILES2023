package com.example.administradordeunidadesmviles_e2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.administradordeunidadesmviles_e2023.databinding.ActivityMainEmpleadoBinding

class main_empleado : AppCompatActivity() {
    private lateinit var binding:ActivityMainEmpleadoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainEmpleadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInicioFinTurno.setOnClickListener{
            val intent = Intent(this, inicio_turno_empleado::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_right_in, R.anim.from_left_out)
        }

        binding.btnCerrarSesion.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_left_in, R.anim.from_right_out)
        }
    }
}