package com.example.administradordeunidadesmviles_e2023

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.administradordeunidadesmviles_e2023.databinding.ActivitySolicitudNuevasCuentasBinding
import com.google.firebase.auth.FirebaseAuth

class solicitud_nuevas_cuentas : AppCompatActivity() {
    private lateinit var binding:ActivitySolicitudNuevasCuentasBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySolicitudNuevasCuentasBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Se leen los cambios del tipo de cuenta
        binding.lblPlacas.text = placasEspecificadas
        val usuariosRef = db.collection("automoviles").document(placasEspecificadas.toString())

        usuariosRef.get()
            .addOnSuccessListener { document ->
                var datoLeido = document.data
                binding.lblCarro.text = datoLeido?.get("stateCarroceria") as CharSequence?
                binding.lblKilometraje.text = datoLeido?.get("stateKilometraje") as CharSequence?
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this,"Placas no encontradas", Toast.LENGTH_SHORT).show()
            }

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


        binding.btnRechazar.setOnClickListener{
            val dialogBinding=layoutInflater.inflate(R.layout.alertas_para_usuarios,null)
            val myDialog = Dialog(this)

            myDialog.setContentView(dialogBinding)
            myDialog.setCancelable(false)

            //Texto del Dialog
            val titulo = dialogBinding.findViewById<TextView>(R.id.tituloAlerta)
            val texto = dialogBinding.findViewById<TextView>(R.id.textoAlerta)

            titulo.text="Atención"
            texto.text="Si declinas una solicitud, el interesado tendrá que volver a realizar la solicitud de cuenta, esta seguro de rechazar la solicitud de:\nEjemplo"

            //Dimensiones del Dialog
            val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
            val height = (resources.displayMetrics.heightPixels * 0.40).toInt()

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
                val intent = Intent(this, solicitudes_cuentas::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.from_left_in, R.anim.from_right_out)

                Toast.makeText(this,"Solicitud rechazada con éxito",Toast.LENGTH_SHORT).show()
            }


        }

        binding.btnAceptar.setOnClickListener {
            val dialogBinding=layoutInflater.inflate(R.layout.alertas_para_usuarios,null)
            val myDialog = Dialog(this)

            myDialog.setContentView(dialogBinding)
            myDialog.setCancelable(false)

            //Texto del Dialog
            val titulo = dialogBinding.findViewById<TextView>(R.id.tituloAlerta)
            val texto = dialogBinding.findViewById<TextView>(R.id.textoAlerta)

            titulo.text="Atención"
            texto.text="Está apunto de aceptar la solicitud, esta accion no se puede modificar, por favor, verifque que el nombre y permisos sean los correctos:\nUsuario: Manuel\nPermisos: Empleado"

            //Dimensiones del Dialog
            val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
            val height = (resources.displayMetrics.heightPixels * 0.45).toInt()

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
                val intent = Intent(this, solicitudes_cuentas::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.from_right_in, R.anim.from_left_out)

                Toast.makeText(this,"Solicitud aceptada con éxito",Toast.LENGTH_SHORT).show()
            }

        }

        binding.btnVolver.setOnClickListener {
            val intent = Intent(this, solicitudes_cuentas::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_left_in, R.anim.from_right_out)
        }
    }
}