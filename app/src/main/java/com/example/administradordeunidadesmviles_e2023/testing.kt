package com.example.administradordeunidadesmviles_e2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.administradordeunidadesmviles_e2023.databinding.ActivityTestingBinding

class testing : AppCompatActivity() {
    private lateinit var binding: ActivityTestingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val arrayOpciones=listOf("A","B","C","D","E","F")

        val adapter = ArrayAdapter(this, R.layout.elemento_lista,arrayOpciones)
        binding.dropdownField.setAdapter(adapter)

        binding.dropdownField.setOnItemClickListener{adapter, view,i,l->
            val vias = view as TextView
        }


    }
}