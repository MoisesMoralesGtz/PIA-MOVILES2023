package com.example.administradordeunidadesmviles_e2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.administradordeunidadesmviles_e2023.databinding.ActivityCapturaDeImagenesBinding

class captura_de_imagenes : AppCompatActivity() {
    private lateinit var binding:ActivityCapturaDeImagenesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCapturaDeImagenesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuario = intent.getStringExtra("user")

        binding.btnContinuar.setOnClickListener{
            val intent = Intent(this, main_empleado::class.java)
            intent.putExtra("user",usuario)
            startActivity(intent)
            overridePendingTransition(R.anim.from_right_in, R.anim.from_left_out)
        }


    }
}