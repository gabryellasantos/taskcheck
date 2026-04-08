package com.example.taskcheck.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.taskcheck.databinding.ActivityMainBinding
import com.example.taskcheck.databinding.ItemTarefaBinding
import com.example.taskcheck.repository.TaskRepository
import kotlinx.coroutines.launch

class TelaInicial : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(0, systemBars.top, 0, 0)
            insets
        }

        lifecycleScope.launch {
            TaskRepository.tasksFlow.collect { listaDeTarefas ->
                exibirTarefas(listaDeTarefas)
            }
        }

        binding.btnFavoritos.setOnClickListener {
            startActivity(Intent(this, TelaFavoritos::class.java))
        }

        binding.btnCreateTask.setOnClickListener {
            startActivity(Intent(this, TelaAtividade::class.java))
        }
    }

    private fun exibirTarefas(tarefas: List<com.example.taskcheck.model.Task>) {
        binding.containerTarefas.removeAllViews()

        tarefas.forEach { tarefa ->
            val itemBinding = ItemTarefaBinding.inflate(
                LayoutInflater.from(this),
                binding.containerTarefas,
                false
            )
            itemBinding.txtTituloTarefa.text = tarefa.titulo

            binding.containerTarefas.addView(itemBinding.root)
        }
    }
}