package com.example.administradordeunidadesmviles_e2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.administradordeunidadesmviles_e2023.databinding.ActivitySolicitudesCuentasBinding


class solicitudes_cuentas : AppCompatActivity() {
    private lateinit var binding: ActivitySolicitudesCuentasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySolicitudesCuentasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrayOpciones=listOf("Fernando","Olivia","Manuel","Antonio")

        //Adapter
        val adapter = ArrayAdapter(this, R.layout.elemento_lista,arrayOpciones)


        binding.dropNueva.setAdapter(adapter)
        binding.dropExistente.setAdapter(adapter)

        var selecExistente=""

        binding.dropExistente.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->
            selecExistente = adapterView.getItemAtPosition(i).toString()
            Toast.makeText(this,selecExistente, Toast.LENGTH_SHORT).show()

            val intent = Intent(this, cuenta_existente::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_right_in, R.anim.from_left_out)
        }

        binding.dropNueva.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->
            selecExistente = adapterView.getItemAtPosition(i).toString()
            Toast.makeText(this,selecExistente, Toast.LENGTH_SHORT).show()

            val intent = Intent(this, solicitud_nuevas_cuentas::class.java)
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