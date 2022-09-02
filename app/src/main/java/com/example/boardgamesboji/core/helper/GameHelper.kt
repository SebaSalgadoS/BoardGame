package com.example.boardgamesboji.core.helper


import com.example.boardgamesboji.data.model.retrofit.GameModel
import com.example.boardgamesboji.data.room.GameEntity

class GameHelper {

    companion object{


        fun emptyGameEntity(): GameEntity{
            return GameEntity(
                        0,
                "S/I",
                "https://via.placeholder.com/140x100",
                "0",
                "0",
                "0",
                0,
                "0",
                "Sin descripcion",
                "No existe Link",
                "S/I",
                "S/I",
                "S/I"
            )
        }

        fun emplyGameModel(): GameModel{
            return GameModel(
                0,
                "S/I",
                "https://via.placeholder.com/140x100",
                "0",
                "0",
                "0",
                0,
                "0",
                "Sin descripcion",
                "No existe Link",
                "S/I",
                "S/I",
                "S/I",

            )
        }
    }
}