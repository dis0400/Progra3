package com.grupod.am

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.grupod.am.databinding.ActivityFormularioBinding

class Formulario : AppCompatActivity() {
    companion object{
        var NOMBRE:String="name"
        var APELLIDO:String="lastname"
        var FECHA:String="date"
        var CELULAR:String="phone"
        var CORREO:String="email"
    }

    private lateinit var binding: ActivityFormularioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.form.setOnClickListener {
            val intent = Intent(this, Confirm::class.java)
            intent.apply {
                putExtra(NOMBRE,binding.edittextName.text.toString())
                putExtra(APELLIDO,binding.editLastname.text.toString())
                putExtra(FECHA,binding.editEdad.text.toString())
                putExtra(CELULAR,binding.editphone.text.toString())
                putExtra(CORREO,binding.editmail.text.toString())
            }
            startActivity(intent)
        }


    }
}