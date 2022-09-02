package com.example.boardgamesboji.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.boardgamesboji.data.model.retrofit.Game


@Entity(tableName = "juegos")
data class GameEntity(
    @PrimaryKey override val id: Int,
    override val nombre: String,
    override val imagen: String,
    override val precio: String,
    override val player: String,
    override val edad: String,
    override val year: Int,
    override val tiempoJuego: String,
    override val descripcion: String,
    override val oficialLink: String,
    override val designer: String,
    override val artista: String,
    override val editor: String,
): Game

