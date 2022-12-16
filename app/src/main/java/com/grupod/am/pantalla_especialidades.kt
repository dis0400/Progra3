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

    private lateinit var binding: pantalla_especialidades
    private lateinit var preferece: SharedPreferences
    var spinnerSelect: ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPantallaEspecialidadesBinding.inflate(layoutInflater)
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

        binding.spinnerSelect.adapter = adapter
        binding.spinnerSelect.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                binding.textViewSelectedSpinner.text = dataList[position]
                spinnerSelect = dataList[position]
                Toast.makeText(this@pantalla_especialidades,"Seleccionaste una especialidad",Toast.LENGTH_SHORT).show();
            }
            override fun OnNothingSelected(p0: AdapterView<*>?){
                }


            }
        }
    }
    fun managePreferences() {
        val id = "ID"
        preferece = PreferenceManager.getDefaultSharedPreferences(this)
        binding.buttonSave.setOnClickListener {
            val editor = preferece.edit()
            var savedData = ""
            if (binding.checkbox.isCheked)
                savedData = "$spinnerSelect"
            editor.putString(id, savedData)
            editor.apply
        }
        binding.buttonShow.setOnClickListener {
            val data = preferece.getString(id, "No se guardo nada")
            binding.textSaveData.text = "${getString(R.string.saved_data)} $data"
        }
        binding.buttonDelete.setonClickListener {
            editor.remove(id)
            editor.apply()
        }
    }
}