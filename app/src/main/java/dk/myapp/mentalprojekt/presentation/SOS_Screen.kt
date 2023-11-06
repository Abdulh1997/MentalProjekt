package dk.myapp.mentalprojekt.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Text


@Composable
fun SOSScreen(navController: NavController, context: Context = LocalContext.current) {
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
            Button(
                onClick = {
                    val sendIntent = Intent(Intent.ACTION_VIEW).apply {
                        data =
                            Uri.parse("smsto:42156558")  // Dette er til at sende til en uspecificeret kontakt.
                        putExtra("sms_body", "Jeg har lige haft et anfald ")
                    }

                    if (sendIntent.resolveActivity(context.packageManager) != null) {
                        context.startActivity(sendIntent)
                    }
                },
                modifier = Modifier
                    .defaultMinSize(minWidth = 100.dp, minHeight = 50.dp)
                    .background(Color.White),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black)
            ) {
                Text(
                    text = "Send besked",
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("vurdering")  },
                modifier = Modifier
                    .defaultMinSize(minWidth = 100.dp, minHeight = 40.dp)
                    .background(Color.Gray),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue, contentColor = Color.White)
            ) {
                Text(
                    text = "Færdig",
                    style = TextStyle(fontSize = 14.sp)
                )
            }
        }
    }
}
