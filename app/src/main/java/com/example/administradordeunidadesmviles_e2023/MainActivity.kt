package com.example.administradordeunidadesmviles_e2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

    private fun verificacionUser(toString: String):Any {
        var flagUser=0;
        val empleadosRf = db.collection("empleados")
        empleadosRf.get()
            .addOnSuccessListener { querySnapshot ->
                for (document in querySnapshot) {
                    if(document.id==binding.TxtUser.text.toString()){
                        flagUser=1
                        var password = document.data["password"] as String
                        var autorizado =document.data["autorizado"] as Boolean
                        var permisos = document.data["esAdministrador"] as Boolean

                        Log.d("ADVERTENCIAS", password)

                        if(password==binding.txtContra.text.toString()){
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
                    }
                }

                if (flagUser==0){
                    Toast.makeText(this,"El usuario introducido no existe, consulte con su superior",Toast.LENGTH_SHORT).show()
                }
            }
        return 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIngresar.setOnClickListener{
            //Validación del usuario
            if(binding.TxtUser.text.toString() == "" || binding.txtContra.text.toString()==""){
                Toast.makeText(this,"No puede dejar campos vacios, ingrese todos sus datos",Toast.LENGTH_SHORT).show();
            }else{
                verificacionUser(binding.TxtUser.text.toString())
            }


        }

        binding.txtNuevaCuenta.setOnClickListener {
            val intent = Intent(this, nuevo_usuario::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_down_in, R.anim.from_up_out)
        }
    }




}