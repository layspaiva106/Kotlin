package com.example.conversorlayout

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.conversorlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Infla o layout da atividade utilizando ActivityMainBinding
        setContentView(binding.root) // Define o layout inflado como o layout da atividade

        binding.buttonClicar.setOnClickListener {
            val dolares = binding.editValor.text.toString().trim() // Coloca o valor em dólar
            val taxa = binding.editTaxa.text.toString().trim() // Coloca a taxa de conversão

            if (!dolares.isEmpty() && !taxa.isEmpty()) {
                val reais = String.format("%.2f", dolares.toDouble() * taxa.toDouble()) // Converte o valor em dólares para reais e formata o resultado para duas casas decimais
                binding.textResultado.text = "R$ " + reais
            } else { // Se algum dos campos estiver vazio
                Toast.makeText(applicationContext, "Digite os dados", Toast.LENGTH_LONG).show() // Exibe uma mensagem de aviso
            }
        }
    }
}
