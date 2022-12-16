package com.grupod.am

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.preference.PreferenceManager
import android.widget.ArrayAdapter
import android.widget.Toast
import com.grupod.am.R
import com.grupod.am.databinding.ActivityPantallaEspecialidadesBinding


class pantalla_especialidades : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaEspecialidadesBinding
    private lateinit var preferences: SharedPreferences
    var spinnerSelected: ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaEspecialidadesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initSpinner()
        managePreferences()
    }

    fun initSpinner() {
        val dataList = mutableListOf<String>()
        dataList.add("MEDICINA GENERAL")
        dataList.add("TRAUMATOLOGIA")
        dataList.add("PEDIATRIA")
        dataList.add("ODONTOLOGIA")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            dataList
        )

        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                spinnerSelected = dataList[position]
                Toast.makeText(this@pantalla_especialidades,"Seleccionaste una especialidad",Toast.LENGTH_SHORT).show();
            }
            override fun OnNothingSelected(p0: AdapterView<*>?){
                }
            }
        }
    fun managePreferences(){
        val id = "nuestro_Id"
        preferences=PreferenceManager.getDefaultSharedPreferences(this)
        binding.spinner.setOnClickListener{ this
        val editor = preferences.edit()
        var savedData = ""
        savedData = spinnerSelected
        editor.putString(id, savedData)
        editor.apply()
        }
    }
    }
