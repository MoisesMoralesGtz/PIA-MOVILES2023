package com.example.administradordeunidadesmviles_e2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.administradordeunidadesmviles_e2023.databinding.ActivityInicioTurnoEmpleadoBinding
import android.widget.Toast
import android.view.View

class inicio_turno_empleado : AppCompatActivity() {
    private lateinit var binding:ActivityInicioTurnoEmpleadoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioTurnoEmpleadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun aparecerElementos(){

            binding.NeumaticosBox.visibility = View.VISIBLE
            binding.lblNeumaticos.visibility = View.VISIBLE

            binding.LimpiezaBox.visibility = View.VISIBLE
            binding.lblLimpieza.visibility = View.VISIBLE

            binding.CarroceriaBox.visibility = View.VISIBLE
            binding.lblCarroceria.visibility = View.VISIBLE

            binding.lblGasolina.visibility = View.VISIBLE
            binding.inputKilometraje.visibility = View.VISIBLE

            binding.lblNivel.visibility = View.VISIBLE
            binding.sliderGas.visibility = View.VISIBLE
        }

        //Arreglos
        val arrayOpciones=listOf("Perfecto","Bueno","Malo","Muy Malo")

        //Adapter
        val adapter = ArrayAdapter(this, R.layout.elemento_lista,arrayOpciones)

        //Seteo de DropDownMenus

        //Placas
        var SelectPlacas=""
        binding.dropPlacas.setAdapter(adapter)

        binding.dropPlacas.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->

            SelectPlacas = adapterView.getItemAtPosition(i).toString()
            Toast.makeText(this,SelectPlacas,Toast.LENGTH_SHORT).show()

            //Linea para hacer que aparezcan todos los demas drops
            aparecerElementos()
        }
        //Neumaticos
        var EstadoNeumaticos=""
        binding.dropNeumatico.setAdapter(adapter)

        binding.dropNeumatico.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->

            EstadoNeumaticos = adapterView.getItemAtPosition(i).toString()
            Toast.makeText(this,EstadoNeumaticos,Toast.LENGTH_SHORT).show()
        }

        //Carroceria
        var EstadoCarroceria=""
        binding.dropCarroceria.setAdapter(adapter)

        binding.dropCarroceria.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->

            EstadoCarroceria = adapterView.getItemAtPosition(i).toString()
            Toast.makeText(this,EstadoCarroceria,Toast.LENGTH_SHORT).show()
        }

        //Limpieza

        var EstadoLimpieza=""
        binding.dropLimpieza.setAdapter(adapter)

        binding.dropLimpieza.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->

            EstadoLimpieza = adapterView.getItemAtPosition(i).toString()
            Toast.makeText(this,EstadoLimpieza,Toast.LENGTH_SHORT).show()
        }

        //Movilidad
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