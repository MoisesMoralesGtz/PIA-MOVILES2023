package com.example.administradordeunidadesmviles_e2023

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.administradordeunidadesmviles_e2023.databinding.ActivityNuevaUnidadBinding


class nueva_unidad : AppCompatActivity() {
    private lateinit var binding:ActivityNuevaUnidadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNuevaUnidadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //dropCarroceriaNuevo
        val arrayOpciones=listOf("Perfecto","Bueno","Malo","Muy Malo")

        //Adapter
        val adapter = ArrayAdapter(this, R.layout.elemento_lista,arrayOpciones)

        //Seteo de DropDownMenus

        //Placas
        var SelectPlacas=""
        binding.dropCarroceriaNuevo.setAdapter(adapter)

        binding.dropCarroceriaNuevo.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->
            SelectPlacas = adapterView.getItemAtPosition(i).toString()
            Toast.makeText(this,SelectPlacas, Toast.LENGTH_SHORT).show()
        }

        binding.btnContinuar.setOnClickListener {

            val dialogBinding=layoutInflater.inflate(R.layout.alertas_para_usuarios,null)
            val myDialog = Dialog(this)

            myDialog.setContentView(dialogBinding)
            myDialog.setCancelable(false)

            val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
            val height = (resources.displayMetrics.heightPixels * 0.40).toInt()

            myDialog.getWindow()?.setLayout(width, height)
            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            myDialog.show()


            //Codigo de las opciones


            /*
            val intent = Intent(this, administrar_unidades::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_right_in, R.anim.from_left_out)
            */
            val titulo = dialogBinding.findViewById<TextView>(R.id.tituloAlerta)
            val texto = dialogBinding.findViewById<TextView>(R.id.textoAlerta)

            titulo.text="AGUAS!!"
            texto.text="TILINES FC"

            //Codigo de alertas
            val BtnClose = dialogBinding.findViewById<Button>(R.id.btnCerrarz)
            BtnClose.setOnClickListener{
                myDialog.dismiss()
            }
        }

        binding.btnVolver.setOnClickListener{
            val intent = Intent(this, administrar_unidades::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_left_in, R.anim.from_right_out)
        }
    }
}