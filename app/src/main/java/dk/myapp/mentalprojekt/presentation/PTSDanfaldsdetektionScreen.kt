import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Text

@Composable
fun PTSDanfaldsdetektionScreen(navController: NavController) {

    Box(
        modifier = Modifier.size(200.dp).background(Color.Gray, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier

        ) {
            Text(text = "Høj arousal!", fontSize = 18.sp, color = Color.White)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Alarm", fontSize = 15.sp, color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("afvisAnfald") }) {
                Text("Ok")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { navController.navigate("vejledning") }) {
                Text("Vejledning")
            }
        }
    }
}
