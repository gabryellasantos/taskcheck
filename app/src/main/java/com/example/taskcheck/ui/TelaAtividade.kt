package com.example.taskcheck.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.taskcheck.R
import com.example.taskcheck.repository.TaskRepository

class TelaAtividade : AppCompatActivity() {

    private lateinit var edtNome: EditText
    private lateinit var btnCriar: Button
    private lateinit var btnCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tela_atividade)

        edtNome = findViewById(R.id.edtNomeTarefa)
        btnCriar = findViewById(R.id.btnCriar)
        btnCancelar = findViewById(R.id.btnCancelar)

        btnCriar.setOnClickListener {
            val nome = edtNome.text.toString()
            if (nome.isNotEmpty()) {
                TaskRepository.addTask(nome)
                finish()
            }
        }

        btnCancelar.setOnClickListener {
            finish()
        }
    }
}