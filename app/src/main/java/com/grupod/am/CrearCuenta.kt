package com.grupod.am

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase
import com.grupod.am.databinding.ActivityCrearCuentaBinding
import com.grupod.am.databinding.ActivityFormularioBinding



class CrearCuenta : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityCrearCuentaBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cuenta)

        binding= ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

    }

    fun SingIn(ema)

}