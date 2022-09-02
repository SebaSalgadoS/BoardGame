package com.example.boardgamesboji.repository

import com.example.boardgamesboji.core.helper.GameHelper
import com.example.boardgamesboji.data.model.retrofit.GameModel
import com.example.boardgamesboji.data.network.GameApiService
import com.example.boardgamesboji.data.room.GameDao
import com.example.boardgamesboji.domain.GameRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class GameRepositoryTest {

    private lateinit var gameApi: GameApiService
    private lateinit var gameDao: GameDao
    private lateinit var repository: GameRepository
    private lateinit var response: Response<List<GameModel>>

    @Before
    fun setup(){
        gameApi = mockk<GameApiService>()
        gameDao = mockk<GameDao>(relaxed = true)
        response = mockk<Response<List<GameModel>>>()
        repository = GameRepository(gameDao, gameApi)
    }


    @Test
    fun `probar que se guarden en BD los datos de la API`() = runBlocking {



        every { response.body() } returns listOf(GameHelper.emplyGameModel())
        every { response.isSuccessful } returns true
        coEvery { gameApi.listGames() } returns response

        Assert.assertEquals(repository.findAll().size, 1)

        coVerify(exactly = 1){gameDao.deleteAll()}
        coVerify(exactly = 1){gameDao.insertAll(any())}

        coVerify(exactly = 0){gameDao.getAll()}
    }

    @Test
    fun `probar que los datos vengan de  BD los datos de la API falle`() = runBlocking {

        // configuracion

        every { response.body() } returns listOf()
        every { response.isSuccessful } returns false
        coEvery { gameApi.listGames() } returns response

        // ASSERTS
        repository.findAll()

        //CHECKEO DE INVOCACIONES

        coVerify(exactly = 0){ gameDao.deleteAll()}
        coVerify(exactly = 0){gameDao.insertAll(any())}
        coVerify(exactly = 1){gameDao.getAll()}
    }
}