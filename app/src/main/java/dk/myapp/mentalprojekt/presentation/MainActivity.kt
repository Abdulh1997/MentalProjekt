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
import dk.myapp.mentalprojekt.business.services.PTSDService
import dk.myapp.mentalprojekt.presentation.theme.MentalProjektTheme

class MainActivity : ComponentActivity() {

    private lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        setContent {
            MentalProjektTheme(){
                val navController = rememberNavController()
                val service= PTSDService(){
                    if ("hovedMenu"==navController.currentDestination?.route)
                        navController.navigate("anfaldsdetektionScreen")
                }
                val pulsSensor=PulsSensor(this,sensorManager,service)
                pulsSensor.setupListener()
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
        composable("konfig") {
            KonfigurationScreen(navController = navController)
        }
    }
}