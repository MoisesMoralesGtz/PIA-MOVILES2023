package com.example.administradordeunidadesmviles_e2023


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import com.example.administradordeunidadesmviles_e2023.databinding.ActivityInicioTurnoEmpleadoBinding
import android.widget.TextView

class inicio_turno_empleado : AppCompatActivity() {
    private lateinit var binding:ActivityInicioTurnoEmpleadoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioTurnoEmpleadoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Arreglos
        val arrayOpciones=listOf("A","B","C","D","E","F")

        val adapter = ArrayAdapter(this, R.layout.elemento_lista,arrayOpciones)

        binding.dropNeumatico.setAdapter(adapter)

        binding.dropNeumatico.setOnItemClickListener{adapter, view,i,l->
            val vias = view as TextView
        }



        binding.btnContinuar.setOnClickListener{
            val intent = Intent(this, captura_de_imagenes::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_right_in, R.anim.from_left_out)
        }

        binding.btnVolver.setOnClickListener{
            val intent = Intent(this, main_empleado::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_left_in, R.anim.from_right_out)
        }
    }
}