package com.example.boardgamesboji.core.mapper

import com.example.boardgamesboji.data.model.retrofit.Game
import com.example.boardgamesboji.data.room.GameEntity

class GameMapper {

    companion object{

        fun toEntity(game: Game): GameEntity{
            with(game){
                return GameEntity(id, nombre, imagen, precio, player, edad, year, tiempoJuego, descripcion, oficialLink, designer, artista, editor)
            }
        }
    }
}