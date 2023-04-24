package com.example.administradordeunidadesmviles_e2023

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.administradordeunidadesmviles_e2023.databinding.ActivityUnidadExistenteBinding


class unidad_existente : AppCompatActivity() {
    private lateinit var binding:ActivityUnidadExistenteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnidadExistenteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Adpatador DropDown


        binding.btnEliminarUnidad.setOnClickListener{

            val dialogBinding=layoutInflater.inflate(R.layout.alertas_para_usuarios,null)
            val myDialog = Dialog(this)

            myDialog.setContentView(dialogBinding)
            myDialog.setCancelable(false)

            //Texto del Dialog
            val titulo = dialogBinding.findViewById<TextView>(R.id.tituloAlerta)
            val texto = dialogBinding.findViewById<TextView>(R.id.textoAlerta)

            titulo.text="¡Atención!"
            texto.text="Si continuas con esta acción la unidad, serán eliminada por completo, y junto con ella todos los registros que se han realizado, ¿está seguro de continuar?"

            //Dimensiones del Dialog
            val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
            val height = (resources.displayMetrics.heightPixels * 0.42).toInt()

            myDialog.window?.setLayout(width, height)
            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            myDialog.show()

            //Botones del Dialog
            val BtnClose = dialogBinding.findViewById<Button>(R.id.btnCerrarz)
            BtnClose.setOnClickListener{
                //Cancelar
                myDialog.dismiss()
            }

            val Seguir = dialogBinding.findViewById<Button>(R.id.btnSeguirz)

            Seguir.setOnClickListener{
                //Continuar
                val intent = Intent(this, administrar_unidades::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.from_right_in, R.anim.from_left_out)

                Toast.makeText(this,"Unidad Eliminada con éxito",Toast.LENGTH_SHORT).show()
            }



        }

        binding.btnVolver.setOnClickListener{
            val intent = Intent(this, administrar_unidades::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_left_in, R.anim.from_right_out)
        }
    }
}