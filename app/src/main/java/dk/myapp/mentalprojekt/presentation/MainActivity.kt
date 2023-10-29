/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package dk.myapp.mentalprojekt.presentation

import PTSDanfaldsdetektionScreen
import android.content.Context
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dk.myapp.mentalprojekt.PulsSensor.PulsSensor
import dk.myapp.mentalprojekt.Services.PTSDService
import dk.myapp.mentalprojekt.presentation.theme.MentalProjektTheme


class MainActivity : ComponentActivity() {

    private lateinit var sensorManager: SensorManager
    private lateinit var pulsSensor: PulsSensor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        pulsSensor = PulsSensor(this, sensorManager)
        pulsSensor.setupListener()


        setContent {
            MentalProjektTheme(){
                val navController = rememberNavController()
                val pulsSensor=PulsSensor(this,sensorManager)
                val service= PTSDService(pulsSensor){navController.navigate("anfaldsdetektionScreen")}
                AppNav(navController)
            }
        }
    }
}

@Composable
fun AppNav(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "hovedMenu") {
        composable("hovedMenu") {
            HovedMenuScreen(navController = navController)
        }
        composable("afvisAnfald") {
            AfvisAnfaldScreen(navController = navController)
        }
        composable("anfaldsdetektionScreen") {
            PTSDanfaldsdetektionScreen(navController = navController)
        }
        composable("vejledning") {
            VejledningScreen(navController = navController)
        }
        composable("musik") {
            MusikScreen(navController = navController)
        }
        composable("sos") {
            SOSScreen(navController = navController)
        }
        composable("øvelse") {
            ØvelseScreen(navController = navController)
        }
        composable("vurdering") {
            VurderingScreen(navController = navController)
        }
        composable("grænse") {
            GrænseScreen(navController = navController)
        }
    }
}










