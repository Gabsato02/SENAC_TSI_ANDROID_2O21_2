package br.senac.aula3_27_08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup

class ExemploPronomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exemplo_pronome)

        // Fazendo o View Binding para associar um elemento da tela a uma variável
        // val variável = procurarPorId<tipo>(Referência a tudo que está no res.id.id)
        val editName = findViewById<EditText>(R.id.editName)
        val pronounGroup = findViewById<RadioGroup>(R.id.pronounGroup)
        val registerButton = findViewById<Button>(R.id.registerButton)

        // EventListener para click
        registerButton.setOnClickListener {
            // O WHEN funciona como um Switch/Case
            // variável = quando(Grupo.TiverRadioButtonChecado)
            // R.id.IdDoRadio -> retorna valor
            val pronoun = when(pronounGroup.checkedRadioButtonId) {
                R.id.radioShe -> "Ela"
                R.id.radioHe -> "Ele"
                else -> "Neutro"
            }

            alert("Olá, ${editName.text}!", "Você escolheu o pronome '$pronoun'", this)
        }
    }
}