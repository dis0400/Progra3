package com.grupod.am

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import com.grupod.am.databinding.ActivityFormularioBinding
import com.grupod.am.databinding.ActivityMainBinding

class FormularioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormularioBinding
    private lateinit var preferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        managePreferences()


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
    companion object{
        var NOMBRE:String="name"
        var APELLIDO:String="lastname"
        var FECHA:String="date"
        var CELULAR:String="phone"
        var CORREO:String="email"
    }
    fun managePreferences(){
        val id = "idname"
        preferences = PreferenceManager.getDefaultSharedPreferences(this)
        binding.edittextName.setOnClickListener { this
            val editor = preferences.edit()
            var savedData = binding.edittextName.text.toString()
            editor.putString(id, savedData)
            editor.apply()
        }

    }
}