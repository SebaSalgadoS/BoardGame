package com.example.boardgamesboji

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.example.boardgamesboji.data.model.adapter.AdapterGame
import com.example.boardgamesboji.ui.view.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(androidx.test.ext.junit.runners.AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val mainActivity = ActivityScenarioRule(MainActivity::class.java)



    @Test
    @LargeTest
    fun prueba_click_recycler_muesta_detalle(){

        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        onView(withId(R.id.recyclerViewGame))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<AdapterGame.ViewHolder>(
                    2,
                    ViewActions.click()
                )
            )

        // revisar que se cargue el titulo
        onView(withId(R.id.txtGameName))
            .check(ViewAssertions.matches(ViewMatchers.withText("Titulo: The Divine Comedy")))
    }
}