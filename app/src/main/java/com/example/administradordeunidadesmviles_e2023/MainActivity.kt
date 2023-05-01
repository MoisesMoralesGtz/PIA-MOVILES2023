package com.example.administradordeunidadesmviles_e2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.administradordeunidadesmviles_e2023.databinding.ActivityMainBinding
import com.example.administradordeunidadesmviles_e2023.ValoresGlobales

import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.firestore.FirebaseFirestore

private lateinit var firebaseAuth: FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth

    private val db = FirebaseFirestore.getInstance()

    var password=""
    var autorizado=false
    var permisos=false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIngresar.setOnClickListener{
            //Validación del usuario

            val usuarioIngresado = binding.TxtUser.text.toString()

            var flagUser=false

            val empleadosRf = db.collection("empleados")
            empleadosRf.get()
                .addOnSuccessListener { querySnapshot ->
                    for (document in querySnapshot) {
                        if(document.id == usuarioIngresado){
                            flagUser=true
                            password = document.data["password"] as String
                            autorizado =document.data["autorizado"] as Boolean
                            permisos = document.data["esAdministrador"] as Boolean

                            break
                        }
                    }
                }

            if(flagUser){

                if(password===binding.txtContra.text.toString()){
                    //Contraseña y usuario coinciden
                    if(autorizado){
                        if(permisos){
                            val intent = Intent(this, main_administrador::class.java)
                            startActivity(intent)
                            overridePendingTransition(R.anim.from_right_in, R.anim.from_left_out)
                        }else{
                            val intent = Intent(this, main_empleado::class.java)
                            startActivity(intent)
                            overridePendingTransition(R.anim.from_right_in, R.anim.from_left_out)
                        }

                    }else{
                        //La cuenta aun no ha sido autorizada
                        Toast.makeText(this,"La cuenta aún no ha sido autorizada, consulte a su superior.",Toast.LENGTH_SHORT).show()
                    }

                }else{
                    //Contraseña Incorrecta
                    Toast.makeText(this,"La contraseña introducida es incorrecta, verifique nuevamente",Toast.LENGTH_SHORT).show()
                }

            }else{
                //Usuario Inexistente
                Toast.makeText(this,"El usuario introducido no existe, consulte a su superior",Toast.LENGTH_SHORT).show()
            }

        }

        binding.txtNuevaCuenta.setOnClickListener {
            val intent = Intent(this, nuevo_usuario::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_down_in, R.anim.from_up_out)
        }
    }




}