package com.example.boardgamesboji.data.network

import com.example.boardgamesboji.data.model.retrofit.GameModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GameApiService {


    @GET("board_games")
    suspend fun listGames(): Response<List<GameModel>>

    @GET("board_games/{id}")
    suspend fun detalleGame(@Path("id") gameID: Int): Response<GameModel>

}