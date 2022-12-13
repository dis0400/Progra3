package com.grupod.am

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.grupod.am.databinding.ActivityFormularioBinding

class Formulario : AppCompatActivity() {

    private lateinit var binding: ActivityFormularioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFormularioBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val form = binding.form
        form.setOnClickListener{
            Toast.makeText(this, "Suformulario esta completo", Toast.LENGTH_SHORT).show()
        }
    }
}