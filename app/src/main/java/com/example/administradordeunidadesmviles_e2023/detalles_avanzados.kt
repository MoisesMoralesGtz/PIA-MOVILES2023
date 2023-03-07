package com.example.administradordeunidadesmviles_e2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.administradordeunidadesmviles_e2023.databinding.ActivityDetallesAvanzadosBinding

class detalles_avanzados : AppCompatActivity() {
    private lateinit var binding:ActivityDetallesAvanzadosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallesAvanzadosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDetalles.setOnClickListener{
            val intent = Intent(this, imagenes_unidad::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_right_in, R.anim.from_left_out)
        }

        binding.btnVolver.setOnClickListener{
            val intent = Intent(this, estado_unidades::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_left_in, R.anim.from_right_out)
        }
    }
}