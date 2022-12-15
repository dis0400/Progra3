package com.grupod.am

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Toast





class pantalla_especialidades : AppCompatActivity() {

    private lateinit var binding: pantalla_especialidades
    private lateinit var prefereces: SharedPreferences
    var spinnerSelect: ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pantalla_especialidades
        binding= pantalla_especialidades.inflate(layoutInflater)
        setContentView(binding.root)
        initSpinner()
    }

    fun initSpinner(){
        val dataList= mutableListOf<String>()
        dataList.add("MEDICINA GENERAL")
        dataList.add("TRAUMATOLOGIA")
        dataList.add("PEDIATRIA")
        dataList.add("ODONTOLOGIA")

        val adapter = ArrayAdapter(this,
        android.R.layout.simple_spinner_item,
            dataList)

        binding.spinner.adapter= adapter
        binding.spinner.onItemSelectedListener=object
                AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                    binding.textViewSelected.spinner.text= dataList[position]
                    spinnerSelect=dataList[position]
                }



        }



    }
}