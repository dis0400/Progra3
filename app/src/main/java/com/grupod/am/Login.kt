package com.grupod.am

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnCreateContextMenuListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase
import com.grupod.am.databinding.ActivityCrearCuentaBinding
import com.grupod.am.databinding.ActivityFormularioBinding
import com.grupod.am.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityCrearCuentaBinding
    var currentUser: FirebaseUser?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
    }
    private fun initUi{
        auth=FirebaseAuth.getInstance()
        currentUser= auth.currentUser

        binding.run {

            }
        }
    }
    //private lateinit var binding: ActivityLoginBinding
    //private lateinit var auth: FireBaseAuth
    //var currentUser: FirebaseUser?
     //override fun OnCreateContextMenuListener
}