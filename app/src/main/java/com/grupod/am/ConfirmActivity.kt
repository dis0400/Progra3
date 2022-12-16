package com.grupod.am

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ConfirmActivity : AppCompatActivity() {
    companion object {
        var NOMBRE: String = "name"
        var APELLIDO: String = "lastname"
        var FECHA: String = "date"
        var CELULAR: String = "phone"
        var CORREO: String = "email"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)
        val nombre = intent.getStringExtra(NOMBRE)
        val apellido = intent.getStringExtra(APELLIDO)
        val fecha = intent.getStringExtra(FECHA)
        val celular = intent.getStringExtra(CELULAR)
        val email = intent.getStringExtra(CORREO)
    }
}