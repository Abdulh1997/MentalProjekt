package dk.myapp.mentalprojekt.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Text

@Composable
fun KonfigurationScreen(navController: NavController) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier.size(200.dp).background(Color.Gray, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize().padding(16.dp)
            ) {

                Text(text = "Konfiguration view", fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = {
                    navController.navigate("hovedMenu")
                }, modifier = Modifier.size(100.dp, 30.dp)) {
                    Text("Gem konfig", fontSize = 11.sp)
                }
            }
        }
    }
}

