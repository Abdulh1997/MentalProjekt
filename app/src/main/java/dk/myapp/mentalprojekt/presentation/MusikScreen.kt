package dk.myapp.mentalprojekt.presentation

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Text
import dk.myapp.mentalprojekt.R

@Composable
fun MusikScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Afspil musik",
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            ClickableImagee(R.drawable.musik){}

            Button(onClick = { navController.navigate("vurdering") }) {
                Text("Færdig")}
            }
        }
    }

@Composable
fun ClickableImagee(foto: Int, onClick: () -> Unit) {
    Image(
        painter = painterResource(id = foto),
        contentDescription = null,
        modifier = Modifier
            .size(70.dp)
            .clip(CircleShape) // Gør billedet cirkulært
            //.background(MaterialTheme.colors.secondary, CircleShape) // Baggrundsfarve for billeder
            .clickable(onClick = onClick)
            .padding(4.dp) // Lidt mellemrum mellem billeder
    )
}


