import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.MainActivity
import com.example.restaurante.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding // Declaração da variável para vincular a atividade ao layout usando data binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater) // Infla o layout da atividade usando binding e atribui à variável binding
        setContentView(binding.root)

        binding.buttonEntrar.setOnClickListener { // Configura o listener de clique para o botão de entrar
            val username = binding.editUsername.text.toString().trim() // variável do usuário
            val password = binding.editPassword.text.toString().trim() // variável da senha

            if (username == "abc" && password == "123") { // Verifica se o usuário e a senha são iguais a "abc" e "123" respectivamente
                val i = Intent(this, MainActivity::class.java)
                i.putExtra("username", username) // Passa o nome de usuário como extra para a MainActivity
                startActivity(i) // Inicia a MainActivity
                finish()
            } else {
                Toast.makeText(applicationContext, "Errou", Toast.LENGTH_LONG).show() // se não deixar as credencias corretar, colocar o texto erro
            }
        }
    }
}
