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
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun HovedMenuScreen(navController: NavController) {
    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val formattedDate = currentDate.format(formatter)

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
                Text(text = "Hej med dig", fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = formattedDate, fontWeight = FontWeight.Light, color = Color.White)
                Spacer(modifier = Modifier.height(12.dp))

                Button(onClick = {
                    navController.navigate("anfaldsdetektionScreen")
                }, modifier = Modifier.size(100.dp, 30.dp)) {
                    Text("Simulere et anfald", fontSize = 11.sp)
                }

            }
        }
    }
}


