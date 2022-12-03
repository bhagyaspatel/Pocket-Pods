package project.android.pocketpods.podcasts.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import project.android.pocketpods.podcasts.presentation.screens.PodcastGenreSelectionScreen
import project.android.pocketpods.podcasts.presentation.viewmodel.MainViewModel
import project.android.pocketpods.ui.theme.PocketPodsTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val TAG = "Main_activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PocketPodsTheme {
                PocketPods()
            }
        }
    }

    @Composable
    private fun PocketPods() {
        val navController : NavHostController = rememberNavController()
        NavHost(navController = navController, startDestination = "homepage"){

            composable(route = "homepage") {
                val viewModel: MainViewModel = hiltViewModel()
                viewModel.getGenre()

                PodcastGenreSelectionScreen(viewModel.genre.value)
            }
        }
    }
}
