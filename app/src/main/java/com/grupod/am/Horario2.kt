package com.grupod.am

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import com.grupod.am.databinding.ActivityHorario2Binding
import com.grupod.am.databinding.ActivityPantallaHorariosBinding

class Horario2 : AppCompatActivity() {
        private lateinit var binding: ActivityHorario2Binding
        private lateinit var preference: SharedPreferences
        var radioSelected=""

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityHorario2Binding.inflate(layoutInflater)
            setContentView(binding.root)
            managePreferences()
        }
        fun manageRadioButton() {
            binding.run {
                radiolButtonOne.setOnClickListener {
                    if (radiolButtonOne.isChecked)
                        Toast.makeText(this@Horario2, "Se guardo el horario seleccionado", Toast.LENGTH_SHORT).show()
                }
            }
        }
        fun managePreferences() {
            val id = "ID"
            preference = PreferenceManager.getDefaultSharedPreferences(this)
            binding.buttonSave2.setOnClickListener {
                val  editor = preference.edit()
                var savedData = ""
                savedData= radioSelected
                editor.putString(id,savedData)
                editor.apply()
            }


        }
    }
