package br.senac.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class TestActivity : AppCompatActivity() {
    /* NOTA: override sobrescreve funções da classe pai - a função espera
    receber um Bundle do tipo savedInstanceState, que serve como um checkpoint pros lifecycles */
    override fun onCreate(savedInstanceState: Bundle?) {
        // NOTA: O super.onCreate está chamando a função onCreate do pai
        super.onCreate(savedInstanceState)
        // NOTA: A função abaixo pega o xml e monta na tela
        setContentView(R.layout.activity_test)

        /* DECLARAÇÃO DE VARIÁVEL = val (const) var (let) nomeDaVariavel : tipo
         Binding: funciona como o getElementById - ligar um elemento a uma variável

         variável = findViewById<TipoDoElemento>(ClasseGlobal.atributo.valorDoAtributo)
         */
        val inputName = findViewById<EditText>(R.id.InputName)
        val messageButton = findViewById<Button>(R.id.MessageButton)

        // addEventListener
        messageButton.setOnClickListener {
            showDialog("Boas-vindas", "Olá, " + inputName.text +"!")
        }
    }

        // Declaração de função
        fun showDialog(title: String, message: String) {
            /* As instâncias no Kotlin não precisam de New()
            alerta.Construtor(contexto)
            */
            AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .create()
                .show()
        }
    }
