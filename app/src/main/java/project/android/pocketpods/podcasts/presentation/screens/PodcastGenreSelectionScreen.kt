package project.android.pocketpods.podcasts.presentation.screens

import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.json.JSONArray
import project.android.pocketpods.podcasts.data.remote.models.genres.Genre
import project.android.pocketpods.podcasts.presentation.widgets.cards
import project.android.pocketpods.ui.theme.PocketPodsTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PodcastGenreSelectionScreen(
    genreState: ArrayList<String>
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(8.dp)
        ) {
            items(genreState.size) {
                cards(
                    data = genreState[it]
                )
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Gray
                ),
                contentPadding = PaddingValues(), //try removing this and see the result
                onClick = {},

                ) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .height(50.dp)
                        .width(80.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Next",
                        color = Color.Black,
                        fontSize = MaterialTheme.typography.h5.fontSize
                    )
                }
            }
        }


    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PocketPodsTheme {
        PodcastGenreSelectionScreen(genreState = arrayListOf("Gujarati", "Hindi", "saf"))
    }
}


