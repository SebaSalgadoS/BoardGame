package com.example.boardgamesboji.domain

import com.example.boardgamesboji.core.helper.GameHelper
import com.example.boardgamesboji.core.mapper.GameMapper
import com.example.boardgamesboji.data.model.retrofit.Game
import com.example.boardgamesboji.data.network.GameApiService
import com.example.boardgamesboji.data.room.GameDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GameRepository(val gameDao: GameDao, val gameApi: GameApiService) {


    suspend fun findById(id: Int): Game{
        return withContext(Dispatchers.IO){
            val response = gameApi.detalleGame(id)
            if (response.isSuccessful){
                val game = response.body() ?: GameHelper.emptyGameEntity()
                gameDao.insertAll(GameMapper.toEntity(game))
                game
            }else{
                gameDao.findById(id)
            }
        }
    }

    suspend fun findAll(): List<Game>{
        return withContext(Dispatchers.IO){
            val response = gameApi.listGames()
            if (response.isSuccessful){
                val games = response.body() ?: emptyList()
                gameDao.deleteAll()
                for (game in games){
                    gameDao.insertAll( GameMapper.toEntity(game))
                }
                games
            }else{
                gameDao.getAll()
            }
        }
    }
}