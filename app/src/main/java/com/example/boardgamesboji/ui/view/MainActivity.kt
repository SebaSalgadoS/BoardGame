package com.example.boardgamesboji.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.boardgamesboji.data.model.adapter.AdapterGame
import com.example.boardgamesboji.databinding.ActivityMainBinding
import com.example.boardgamesboji.ui.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val gameViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recyclerViewGame

        recyclerView.layoutManager = LinearLayoutManager(this)

        gameViewModel.cargarGames()

        gameViewModel.games.observe(this, Observer {
            binding.recyclerViewGame.adapter = AdapterGame(it)
        })

    }
}