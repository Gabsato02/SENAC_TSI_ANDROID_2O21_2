package br.senac.aula3_27_08

import android.content.Context
import androidx.appcompat.app.AlertDialog

fun alert(title: String, message: String, context: Context) {
    // Função para exibição de alerta
    AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton("OK", null)
        .create()
        .show()
}