package br.senac.aula3_27_08

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senac.aula3_27_08.databinding.ActivityExemploDataHoraBinding
import java.util.*

class ExemploDataHoraActivity : AppCompatActivity() {
    // Melhor forma de fazer View Binding - criando uma propriedade da classe pra que seja acessível
    lateinit var binding: ActivityExemploDataHoraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Melhor forma de fazer View Binding - carregando o layout dessa activity específica na propriedade
        binding = ActivityExemploDataHoraBinding.inflate(layoutInflater)
        // Setando o layout como ContentView
        setContentView(binding.root)

        binding.imageDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            // Diálogo de data e hora(context, função closure, ano_inicial, mês_inicial, dia_inicial)
            DatePickerDialog(this, { viewCalendar, selectedYear, selectedMonth, selectedDay ->
                binding.editDate.setText("$selectedDay/$selectedMonth/$selectedYear")
            }, year, month, day).show()
        }
    }

}