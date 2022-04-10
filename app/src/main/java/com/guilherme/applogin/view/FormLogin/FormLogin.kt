package com.guilherme.applogin.view.FormLogin

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.guilherme.applogin.R
import com.guilherme.applogin.databinding.ActivityFormCadastroBinding
import com.guilherme.applogin.databinding.ActivityFormLoginBinding
import com.guilherme.applogin.view.FormCadastro.FormCadastro

class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botaoEntrar.setOnClickListener{ view ->
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            if (email.isEmpty() || senha.isEmpty()){
                val snackbar = Snackbar.make(view,"Preencha todos os campos!", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            }else{
                auth.signInWithEmailAndPassword(email,senha).addOnCompleteListener { atenticacao ->
                    if (atenticacao.isSuccessful){

                    }

                }
            }
        }

        binding.txtTelaCadastro.setOnClickListener{
            val intent = Intent(this,FormCadastro::class.java)
            startActivity(intent)
        }

    }
}