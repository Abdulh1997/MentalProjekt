package unitTest

import PTSDanfaldsdetektionScreen
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import dk.myapp.mentalprojekt.presentation.HovedMenuScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import dk.myapp.mentalprojekt.presentation.AfvisAnfaldScreen
import dk.myapp.mentalprojekt.presentation.MusikScreen
import dk.myapp.mentalprojekt.presentation.SOSScreen
import dk.myapp.mentalprojekt.presentation.VejledningScreen
import dk.myapp.mentalprojekt.presentation.VurderingScreen
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


@RunWith(AndroidJUnit4::class)
class UITest {

    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun uItest_HovedMenuScreen() {

        //Arrange og Act
        val navController = mock(NavController::class.java)
        val dateFormatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val today = Calendar.getInstance().time
        val formattedDate = dateFormatter.format(today)

        composeTestRule.setContent {
                HovedMenuScreen(navController = navController)
        }

        //Assert
        composeTestRule.onNodeWithTag("KonfigIconTag").assertIsDisplayed().assertHasClickAction()
        composeTestRule.onNodeWithText("Hej med dig").assertIsDisplayed()
        composeTestRule.onNodeWithText(formattedDate).assertIsDisplayed()

    }

    @Test
    fun uItest_PTSDanfaldsdetektionScreen() {

        //Arrange og Act
        val navController = mock(NavController::class.java)

        composeTestRule.setContent {
            PTSDanfaldsdetektionScreen(navController = navController)
        }

        //Assert
        composeTestRule.onNodeWithText("Høj arousal!").assertIsDisplayed()
        composeTestRule.onNodeWithText("Alarm").assertIsDisplayed()
        composeTestRule.onNodeWithText("Ok").assertHasClickAction().assertIsDisplayed()
    }

    @Test
    fun uITest_AfvisAnfaldScreen() {

        //Arrange og Act
        val navController = mock(NavController::class.java)

        composeTestRule.setContent {
            AfvisAnfaldScreen(navController = navController)
        }

        //Assert
        composeTestRule.onNodeWithText("Har du oplevet noget?").assertIsDisplayed()
        composeTestRule.onNodeWithText("Ja").assertHasClickAction().assertIsDisplayed()
        composeTestRule.onNodeWithText("Nej").assertHasClickAction().assertIsDisplayed()
    }

    @Test
    fun uITest_VejledningScreen() {

        //Arrange og Act
        val navController = mock(NavController::class.java)

        composeTestRule.setContent {
            VejledningScreen(navController = navController)
        }

        //Assert
        composeTestRule.onNodeWithTag("musikIconTag").assertIsDisplayed().assertHasClickAction()
        composeTestRule.onNodeWithTag("sosIconTag").assertIsDisplayed().assertHasClickAction()
        composeTestRule.onNodeWithTag("øvelseIconTag").assertIsDisplayed().assertHasClickAction()
        composeTestRule.onNodeWithTag("grænseIconTag").assertIsDisplayed().assertHasClickAction()
    }


    @Test
    fun uITest_MusikScreen() {

        //Arrange
        val navController = mock(NavController::class.java)

        composeTestRule.setContent {
            MusikScreen(navController = navController)
        }

        //Assert
        composeTestRule.onNodeWithTag("playMusicIcon").assertIsDisplayed().assertHasClickAction()

        //Act
        composeTestRule.onNodeWithTag("playMusicIcon").performClick()

        //Assert
        composeTestRule.onNodeWithTag("stopMusicIcon").assertIsDisplayed().assertHasClickAction()
    }


    @Test
    fun uITest_SOSScreen() {

        //Arrange og Act
        val navController = mock(NavController::class.java)

        composeTestRule.setContent {
            SOSScreen(navController = navController)
        }

        //Assert
        composeTestRule.onNodeWithText("Send besked").assertIsDisplayed().assertHasClickAction()
        composeTestRule.onNodeWithText("Færdig").assertIsDisplayed().assertHasClickAction()

    }


    @Test
    fun uITest_VurderingScreen() {

        //Arrange og Act
        val navController = mock(NavController::class.java)

        composeTestRule.setContent {
            VurderingScreen(navController = navController)
        }

        //Assert
        composeTestRule.onNodeWithText("Har du brug for mere hjælp?").assertIsDisplayed()
        composeTestRule.onNodeWithText("Ja").assertIsDisplayed().assertHasClickAction()
        composeTestRule.onNodeWithText("Nej").assertIsDisplayed().assertHasClickAction()
    }
}