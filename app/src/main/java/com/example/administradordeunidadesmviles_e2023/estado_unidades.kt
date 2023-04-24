package com.example.administradordeunidadesmviles_e2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.administradordeunidadesmviles_e2023.databinding.ActivityEstadoUnidadesBinding

class estado_unidades : AppCompatActivity() {
    private lateinit var binding:ActivityEstadoUnidadesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEstadoUnidadesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var UnidadActual=1

        fun verificador(){
            binding.anterior.isEnabled = UnidadActual != 1
            binding.siguiente.isEnabled = UnidadActual != 4
        }

        binding.siguiente.setOnClickListener{
            UnidadActual=UnidadActual+1
            binding.unidadActual.text="Unidades disponibles: "+UnidadActual+"/4"

            verificador()
        }

        binding.anterior.setOnClickListener {
            UnidadActual=UnidadActual-1
            binding.unidadActual.text="Unidades disponibles: "+UnidadActual+"/4"

            verificador()
        }


        binding.btnDetalles.setOnClickListener{
            val intent = Intent(this, detalles_avanzados::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_right_in, R.anim.from_left_out)
        }

        binding.btnVolver.setOnClickListener{
            val intent = Intent(this, main_administrador::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_left_in, R.anim.from_right_out)
        }
    }
}