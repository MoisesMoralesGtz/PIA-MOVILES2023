package com.example.administradordeunidadesmviles_e2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.administradordeunidadesmviles_e2023.databinding.ActivitySolicitudNuevasCuentasBinding

class solicitud_nuevas_cuentas : AppCompatActivity() {
    private lateinit var binding:ActivitySolicitudNuevasCuentasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySolicitudNuevasCuentasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Arreglos
        val arrayOpciones=listOf("Administrador","Empleado")

        //Adapter
        val adapter = ArrayAdapter(this, R.layout.elemento_lista,arrayOpciones)

        //Seteo de DropDownMenus

        //Placas
        var permisosSeleccionados=""
        binding.dropTipoCuenta.setAdapter(adapter)

        binding.dropTipoCuenta.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->

            permisosSeleccionados = adapterView.getItemAtPosition(i).toString()
            Toast.makeText(this,permisosSeleccionados, Toast.LENGTH_SHORT).show()

            //Linea para hacer que aparezcan todos los demas drops
            //Se cambia a una linea de activacion de botones
            binding.btnAceptar.isEnabled=true
        }


        binding.btnRechazar.setOnClickListener {
            val intent = Intent(this, solicitudes_cuentas::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_left_in, R.anim.from_right_out)
        }

        binding.btnAceptar.setOnClickListener {
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