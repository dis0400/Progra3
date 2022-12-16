package com.grupod.am

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.grupod.am.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding
    var currentUser: FirebaseUser?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
    }
    private fun initUi(){
        auth = FirebaseAuth.getInstance()
        currentUser= auth.currentUser

        binding.run {
                buttonLogin.setOnClickListener{
                    val email = edittextMail.text.toString()
                    val password= editTextPASS.text.toString()
                    if(validData(email, password)){
                    loginUser(email, password)}
                }
            buttonIngresardirect.setOnClickListener{
                if (currentUser!= null) {
                    redirectActivity()
                }else{
                    showMessage("Debes iniciar sesion antes de ingresar")
                }
            }
            buttonCrear.setOnClickListener{
                val email=edittextMail.text.toString()
                val password= editTextPASS.text.toString()
                if (validData(email, password)){
                    createNewUser(email, password)
                }
            }
            }
        }

    private fun createNewUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){task ->
            if(task.isSuccessful){
                sendToast("Usuario Creado")
               redirectActivityNEW()
            }else{
                sendToast("Error")
            }

        }
    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this){task ->
            if (task.isSuccessful){
                redirectActivity()
            }else{
                sendToast("Error")
            }

        }
    }

    private fun sendToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun validData(email: String, password: String): Boolean {
        var valid = true
        if(email.isEmpty()){
            valid=false
            showMessage("Ingrese un correo")
        }else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            valid = false
            showMessage("Ingresa un correo valido")
        }else if (password.isEmpty()){
            valid= false
            showMessage("Ingresa Contrasena")
        }else if (password.length < 8){
            valid=false
            showMessage("La contrasena debe tener 8 digitos")
        }
        return  valid
    }

    private fun showMessage(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()

    }
    private fun redirectActivity(){
        val intentRedirect = Intent(this, PantallaDoctores::class.java)
        startActivity(intentRedirect)
        finish()
    }
    private fun redirectActivityNEW(){
        val intentRedirect = Intent(this, CrearCuentaActivity::class.java)
        startActivity(intentRedirect)
        finish()
    }
}

