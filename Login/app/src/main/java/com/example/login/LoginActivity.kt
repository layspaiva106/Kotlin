package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.login.MainActivity
import com.example.login.databinding.ActivityLoginBinding
import com.example.restaurante.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) { // Sobrescreve o método onCreate
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonEntrar.setOnClickListener { // Define um listener de clique para o "buttonEntrar"
            val username = binding.editUsername.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()

            if (username.equals("abc") && password.equals("123")) { // Verifica se o nome de usuário é "abc" e a senha é "123"
                val i = Intent(this, MainActivity::class.java)
                i.putExtra("username", username) // Adiciona um extra à intenção, contendo o nome de usuário
                startActivity(i) // Inicia a atividade MainActivity
                finish()
            } else { // Caso as credenciais não estiverem certas, coloque "Errou"
                Toast.makeText(applicationContext, "Errou", Toast.LENGTH_LONG).show()
            }
        }
    }
}
