package com.example.boardgamesboji.data.room

import androidx.room.*

@Dao
interface GameDao {

    @Query("SELECT * FROM juegos")
    fun getAll(): List<GameEntity>

    @Query("SELECT * FROM juegos WHERE id= :gid")
    fun findById(gid: Int): GameEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg juegos: GameEntity)

    @Delete
    fun delete(juegos: GameEntity)

    @Query("DELETE FROM juegos")
    fun deleteAll()
}