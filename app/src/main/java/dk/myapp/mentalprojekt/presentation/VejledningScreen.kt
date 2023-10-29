package dk.myapp.mentalprojekt.presentation


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dk.myapp.mentalprojekt.R

@Composable
fun VejledningScreen(navController: NavController) {
    Box(
        modifier = Modifier.size(220.dp).background(Color.LightGray, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ClickableImage(R.drawable.musik) {navController.navigate("musik") }
                ClickableImage(R.drawable.ovelsee) { navController.navigate("øvelse")}
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ClickableImage(R.drawable.sos) { navController.navigate("sos")}
                ClickableImage(R.drawable.taler) { navController.navigate("grænse")}
            }
        }
    }
}

@Composable
fun ClickableImage(foto: Int, onClick: () -> Unit) {
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





