package com.example.boardgamesboji.data.model.retrofit

import com.google.gson.annotations.SerializedName

data class GameModel(
    override val id: Int,
    @SerializedName("name") override val nombre: String,
    @SerializedName("image") override val imagen: String,
    @SerializedName("price") override val precio: String,
    @SerializedName("players") override val player: String,
    @SerializedName("age") override val edad: String,
    @SerializedName("year") override val year: Int,
    @SerializedName("playing_time") override val tiempoJuego: String,
    @SerializedName("description") override val descripcion: String,
    @SerializedName("official_link") override val oficialLink: String,
    @SerializedName("Designer") override val designer: String,
    @SerializedName("Artist") override val artista: String,
    @SerializedName("Publisher") override val editor: String,
    ): Game
