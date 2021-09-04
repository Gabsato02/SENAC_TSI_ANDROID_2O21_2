package br.senac.aula3_27_08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_exemplo_tipo_telefone.*

class ExemploTipoTelefoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exemplo_tipo_telefone)

        loadSpinner()
        editTextPhone.addTextChangedListener(PhoneNumberFormattingTextWatcher())
        confirmButton.setOnClickListener {
            if(validateFields()) {
                val msg = """Nome: ${editTextName.text}
                    |Telefone: ${editTextPhone.text}
                    |
                    |Tipo do telefone: ${spinPhoneType.selectedItem}
                """.trimMargin()

                alert("Bem vindo, ${editTextName.text}!", msg, this)
            } else {
                // Acessando strings do arquivo de strings
                alert(getString(R.string.error), getString(R.string.fieldsMissing), this)
            }
        }
    }

    private fun validateFields() = (editTextName.text.isNotEmpty()
            && editTextPhone.text.isNotEmpty()
            && spinPhoneType.selectedItemPosition != 0)

    private fun loadSpinner() {
        // Declaração de array para o Spinner
        val itens = arrayOf("Selecione", "Residencial", "Comercial", "Celular", "Outros")
        // AdaptadorDeArray(contexto, layout para qual o array será adaptado, array)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, itens)
        // Aplicando um estilo de espaçamento para o spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Propriedade adapter recebe a variável adapter
        spinPhoneType.adapter = adapter
    }

}