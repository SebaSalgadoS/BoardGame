package com.example.boardgamesboji.app

import android.app.Application
import androidx.room.Room
import com.example.boardgamesboji.data.network.GameApiService
import com.example.boardgamesboji.data.room.DataBase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BoardGamesBojiApplication: Application() {

    val dataBase by lazy{
        Room.databaseBuilder(
            this, DataBase::class.java, "juegos-db"
        ).build()
    }

    val gameDao by lazy {
        dataBase.gameDao()
    }

    val retrofit by lazy{
        Retrofit.Builder().baseUrl("https://board-games-fake-api.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    val gameApi by lazy{
        retrofit.create(GameApiService::class.java)
    }


}