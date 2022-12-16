package com.grupod.am

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import com.grupod.am.databinding.ActivityHorario2Binding
import com.grupod.am.databinding.ActivityHorario3Binding

class horario3 : AppCompatActivity() {
    private lateinit var binding: ActivityHorario3Binding
    private lateinit var preference: SharedPreferences
    var radioSelected=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHorario3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        managePreferences()
    }
    fun manageRadioButton() {
        binding.run {
            radiolButtonOne.setOnClickListener {
                if (radiolButtonOne.isChecked)
                    Toast.makeText(this@horario3, "Se guardo el horario seleccionado", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun managePreferences() {
        val id = "ID"
        preference = PreferenceManager.getDefaultSharedPreferences(this)
        binding.radioGroup.setOnClickListener {
            val  editor = preference.edit()
            var savedData = ""
            savedData= radioSelected
            editor.putString(id,savedData)
            editor.apply()
        }
        binding.buttonContin.setOnClickListener {
            val intent = Intent(this, FormularioActivity:: class.java)
            startActivity(intent)
        }
        binding.buttonDelete.setOnClickListener {
            val editor = preference.edit()
            editor.remove(id)
            editor.apply()
        }


    }
}
