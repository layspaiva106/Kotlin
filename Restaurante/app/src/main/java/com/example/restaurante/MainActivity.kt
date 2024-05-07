import android.content.Intent // Importa a classe Intent para navegar entre atividades
import android.os.Bundle // Importa a classe Bundle para passar dados entre atividades
import android.view.View // Importa a classe View para manipulação de elementos de interface
import androidx.appcompat.app.AppCompatActivity // Importa a classe base para atividades no estilo AppCompat
import com.example.restaurante.SplashActivity
import com.example.restaurante.databinding.ActivityMainBinding // Importa a classe gerada pelo data binding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // Declaração da variável para vincular a atividade ao layout usando data binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater) // Infla o layout da atividade usando data binding e atribui à variável binding
        setContentView(binding.root) // Define o layout inflado como o layout da atividade

        val username = intent.extras?.getString("username") // Obtém o nome de usuário passado como extra

        if (!username.isNullOrEmpty()) { // Verifica se o nome de usuário não está vazio
            binding.textOla.text = "Olá $username" // Define a saudação com o nome de usuário na tela
        }

        binding.buttonFechar.setOnClickListener { // Configura o listener de clique para o botão de fechar
            finishAffinity() // Fecha a atividade e todas as atividades relacionadas
        }

        binding.buttonPedir.setOnClickListener { // Configura o listener de clique para o botão de pedir
            val i = Intent(this, SplashActivity::class.java) // Cria um intent para iniciar a SplashActivity
            i.putExtra("quantidadePizza", binding.editQuantidadePizza.text.toString()) // Passa a quantidade de pizza como extra para a SplashActivity
            i.putExtra("quantidadeSalada", binding.editQuantidadeSalada.text.toString()) // Passa a quantidade de salada como extra para a SplashActivity
            i.putExtra("quantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString()) // Passa a quantidade de hambúrguer como extra para a SplashActivity
            startActivity(i) // Inicia a SplashActivity
            finish() // Encerra a MainActivity
        }

        // Configura os listeners de clique para os checkboxes
        binding.checkPizza.setOnClickListener {
            if (binding.checkPizza.isChecked()) {
                binding.editQuantidadePizza.setText("1")
                binding.textPrecoPizza.visibility = View.VISIBLE
            } else {
                binding.editQuantidadePizza.setText("0")
                binding.textPrecoPizza.visibility = View.GONE
            }
        }

        binding.checkSalada.setOnClickListener {
            if (binding.checkSalada.isChecked()) {
                binding.editQuantidadeSalada.setText("1")
                binding.textPrecoSalada.visibility = View.VISIBLE
            } else {
                binding.editQuantidadeSalada.setText("0")
                binding.textPrecoSalada.visibility = View.GONE
            }
        }

        binding.checkHamburger.setOnClickListener {
            if (binding.checkHamburger.isChecked()) {
                binding.editQuantidadeHamburguer.setText("1")
                binding.textPrecoHamburguer.visibility = View.VISIBLE
            } else {
                binding.editQuantidadeHamburguer.setText("0")
                binding.textPrecoHamburguer.visibility = View.GONE
            }
        }
    }
}
