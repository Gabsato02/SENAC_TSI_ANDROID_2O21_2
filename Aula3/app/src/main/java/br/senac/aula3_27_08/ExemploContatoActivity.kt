package br.senac.aula3_27_08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.telephony.PhoneNumberFormattingTextWatcher
import android.widget.Button
import android.widget.CheckBox

class ExemploContatoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exemplo_contato)

        val inputName = findViewById<EditText>(R.id.inputName)
        val inputPhone = findViewById<EditText>(R.id.inputPhone)
        inputPhone.addTextChangedListener(PhoneNumberFormattingTextWatcher())
        val inputEmail = findViewById<EditText>(R.id.inputEmail)
        val checkBoxPhone = findViewById<CheckBox>(R.id.checkBoxPhone)
        val checkBoxEmail = findViewById<CheckBox>(R.id.checkBoxEmail)
        val saveButton = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener {
            /* Declaração de Raw String """""" - permite pular linhas e respeita a exata forma
            como o código está escrito - o pipe | serve pra quebrar linhas */
            var message = """Nome: ${inputName.text}
                |Telefone: ${inputPhone.text}
                |Email: ${inputEmail.text}
                |
                |Preferência de contato
            """.trimMargin()

            if (checkBoxPhone.isChecked) {
                message += "\n - Telefone"
            }

            if (checkBoxEmail.isChecked) {
                message += "\n - Email"
            }

            alert("Cadastro realizado!", message, this)
        }
    }



}