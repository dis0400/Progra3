package com.grupod.am

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.grupod.am.databinding.ActivityFormularioBinding
import com.grupod.am.databinding.ActivityMainBinding

class FormularioActivity : AppCompatActivity() {
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
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.form.setOnClickListener {
            val intent = Intent(this, ConfirmActivity::class.java)
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