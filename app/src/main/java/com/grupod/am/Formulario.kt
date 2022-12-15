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


    private lateinit var binding: ActivityFormularioBinding
    lateinit var formus: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        formus.addTextChangedListener{
                text -> Log.d("llene datos", text.toString())
        }

        binding=ActivityFormularioBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val form = binding.form
        form.setOnClickListener{
            Toast.makeText(this, "Su formulario esta completo", Toast.LENGTH_SHORT).show()
        }

        binding.form.setOnClickListener {
            val intent = Intent(this, Confirm::class.java)
            startActivity(intent)
        }


    }
}