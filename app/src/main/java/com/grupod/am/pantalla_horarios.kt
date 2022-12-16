package com.grupod.am

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.widget.Toast
import com.grupod.am.databinding.ActivityFormularioBinding
import com.grupod.am.databinding.ActivityPantallaHorariosBinding

class pantalla_horarios : AppCompatActivity() {
    private lateinit var binding: ActivityPantallaHorariosBinding
    private lateinit var preference: SharedPreferences
    var radioSelected=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaHorariosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        managePreferences()
    }
    fun manageRadioButton() {
        binding.run {
            radiolButtonOne.setOnClickListener {
                if (radiolButtonOne.isChecked)
                    Toast.makeText(this@pantalla_horarios, "Se guardo el horario seleccionado", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun managePreferences() {
        val id = "ID"
        preference = PreferenceManager.getDefaultSharedPreferences(this)
        binding.ButtonSave.setOnClickListener {
            val  editor = preference.edit()
            var savedData = ""
            savedData= radioSelected
            editor.putString(id,savedData)
            editor.apply()
        }
        binding.buttonContinuar.setOnClickListener {
            val intent = Intent(this, ActivityFormulario:: class.java)
            intent.apply {
                
            }
        }
        binding.buttonDelete.setOnClickListener {
            val editor = preference.edit()
            editor.remove(id)
            editor.apply()
        }
    }

}