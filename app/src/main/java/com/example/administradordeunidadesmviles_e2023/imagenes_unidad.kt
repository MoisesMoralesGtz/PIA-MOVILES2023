package com.example.administradordeunidadesmviles_e2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.administradordeunidadesmviles_e2023.databinding.ActivityImagenesUnidadBinding


class imagenes_unidad : AppCompatActivity() {
    private lateinit var binding: ActivityImagenesUnidadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImagenesUnidadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var UnidadActual=0



        val imagenesDisponibles=listOf("Imagen de Interiores","Estado de las llantas","Estado de Carroceria","Estado de Tablero")

        fun verificador(){
            binding.lblImageActual.text=imagenesDisponibles[UnidadActual]
            binding.anterior.isEnabled = UnidadActual != 0
            binding.siguiente.isEnabled = UnidadActual != 3
        }

        binding.siguiente.setOnClickListener{
            UnidadActual++
            verificador()
        }

        binding.anterior.setOnClickListener {
            UnidadActual--
            verificador()
        }


        binding.btnVolver.setOnClickListener{
            val intent = Intent(this, detalles_avanzados::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_left_in, R.anim.from_right_out)
        }
    }
}