package com.example.administradordeunidadesmviles_e2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.administradordeunidadesmviles_e2023.databinding.ActivityCuentaExistenteBinding

class cuenta_existente : AppCompatActivity() {
    private lateinit var binding:ActivityCuentaExistenteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCuentaExistenteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEliminarCuenta.setOnClickListener {
            val intent = Intent(this, solicitudes_cuentas::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_right_in, R.anim.from_left_out)
        }

        binding.btnVolver.setOnClickListener {
            val intent = Intent(this, solicitudes_cuentas::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_left_in, R.anim.from_right_out)
        }

    }
}