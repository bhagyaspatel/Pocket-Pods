package project.android.pocketpods.podcasts.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import project.android.pocketpods.podcasts.data.remote.PodcastRepository
import project.android.pocketpods.podcasts.data.remote.models.genres.Genre
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val podcastRepository: PodcastRepository
) : ViewModel() {

    private val TAG = "viewModal"
    private val _genreNames = mutableStateOf (ArrayList<String>())

    val genre : MutableState<ArrayList<String>>
    get() = _genreNames

    private val coroutineExceptionHandler = CoroutineExceptionHandler{ _, throwable ->
        throwable.printStackTrace()
    }

    fun getGenre() {
        Log.d(TAG, "getGenre: viewmodal called")

        viewModelScope.launch(Dispatchers.IO){
            podcastRepository.getGenres()

            withContext(Dispatchers.Main + coroutineExceptionHandler){
                for(i in 0..podcastRepository.genres.value.length() -1){
                    Log.d(TAG, "getGenre: genre name  " + podcastRepository.genres.value.getJSONObject(i).optString("name"))
                    _genreNames.value.add(podcastRepository.genres.value.getJSONObject(i).optString("name"))
                }
            }
        }
    }

}