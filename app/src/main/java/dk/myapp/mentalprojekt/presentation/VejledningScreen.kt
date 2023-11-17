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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dk.myapp.mentalprojekt.R

@Composable
fun VejledningScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .size(220.dp)
            .background(Color.LightGray, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ClickableImage(
                    foto = R.drawable.musik,
                    onClick = { navController.navigate("musik") }
                    , testTag = "musikIconTag")
                ClickableImage(
                    foto = R.drawable.ovelsee,
                    onClick = { navController.navigate("øvelse") }
                    , testTag = "øvelseIconTag")
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ClickableImage(
                    foto = R.drawable.sos,
                    onClick = { navController.navigate("sos") }
                    , testTag = "sosIconTag")
                ClickableImage(
                    foto = R.drawable.taler,
                    onClick = { navController.navigate("grænse") }
                    , testTag = "grænseIconTag")
            }
        }
    }
}

@Composable
fun ClickableImage(foto: Int, onClick: () -> Unit,testTag:String) {
    Image(
        painter = painterResource(id = foto),
        contentDescription = null,
        modifier = Modifier
            .size(70.dp)
            .clip(CircleShape)
            .clickable(onClick = onClick)
            .padding(4.dp)
            .testTag(testTag)
    )
}
