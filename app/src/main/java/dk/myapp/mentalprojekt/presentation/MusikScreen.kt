package dk.myapp.mentalprojekt.presentation

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.navigation.NavController
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Text
import dk.myapp.mentalprojekt.R

@Composable
fun MusikScreen(navController: NavController) {

    val context = LocalContext.current
    val mediaPlayer = remember { MediaPlayer.create(context, R.raw.slapaf) }
    val isPlaying = remember { mutableStateOf(false) }
    var photo by remember { mutableStateOf(R.drawable.play) }
    val tag: String = "playMusikIcon"

    // Ryd op når MusikScreen forlader kompositionen
    DisposableEffect(Unit) {
        onDispose {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
            }
            mediaPlayer.release()
        }
    }
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
           // var photo: Int = R.drawable.play
            Image(

                painter = painterResource(id = photo),
                contentDescription = "Afspil musik",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .testTag(if (isPlaying.value) "stopMusicIcon" else "playMusicIcon")
                    .clickable {
                        if (isPlaying.value) {
                            mediaPlayer.pause()
                            photo=R.drawable.play
                            isPlaying.value = false
                        } else {
                            mediaPlayer.start()
                            photo=R.drawable.stopmusik
                            isPlaying.value = true
                        }
                    }
            )
            Button(onClick = { navController.navigate("vurdering") }) {
                Text("Færdig")}
            }
        }
    }