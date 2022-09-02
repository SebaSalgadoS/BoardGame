package com.example.boardgamesboji.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.boardgamesboji.app.BoardGamesBojiApplication
import com.example.boardgamesboji.data.model.retrofit.Game
import com.example.boardgamesboji.domain.GameRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {

    val games = MutableLiveData<List<Game>>()

    fun cargarGames(){
        viewModelScope.launch {
            val app = getApplication<BoardGamesBojiApplication>()
            val repo = GameRepository(app.gameDao, app.gameApi)
            val gamesFromRepository = repo.findAll()
            if (!gamesFromRepository.isNullOrEmpty()){
                games.postValue(gamesFromRepository)
            }
        }
    }
}