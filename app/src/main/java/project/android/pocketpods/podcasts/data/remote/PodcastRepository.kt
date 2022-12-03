package project.android.pocketpods.podcasts.data.remote

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import project.android.pocketpods.podcasts.PodcastApplication.Companion.getContext
import project.android.pocketpods.podcasts.data.remote.interfaces.PodcastApiService
import project.android.pocketpods.podcasts.data.remote.models.genres.Genre
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PodcastRepository @Inject constructor(
    private val podcastInterface : PodcastApiService
) {
    private val TAG = "podcastRepo"

    private val _genres = mutableStateOf(JSONArray())

    val genres : MutableState<JSONArray>
    get() = _genres

    suspend fun getGenres() {
        Log.d(TAG, "getGenres: repo called")
        val response = podcastInterface.getGenreTypes(1)

        if(response.body() != null){
            val jsonResponse = JSONObject(response.body()!!.toString())
            val genresArr = jsonResponse.getJSONArray("genres")

            _genres.value = genresArr
            Log.d(TAG, "getGenres: respone body ${jsonResponse}")
            Log.d(TAG, "getGenres: respone body genres ${genresArr}")
        }
    }
}