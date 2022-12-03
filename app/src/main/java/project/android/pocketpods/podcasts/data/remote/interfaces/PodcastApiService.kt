package project.android.pocketpods.podcasts.data.remote.interfaces

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import project.android.pocketpods.podcasts.data.remote.models.genres.Genre
import project.android.pocketpods.podcasts.utilities.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PodcastApiService {

    @Headers("X-ListenAPI-Key:${API_KEY}")
    @GET("genres/")
    suspend fun getGenreTypes(@Query("top_level_only") top_level_only : Int) : Response<JsonElement>
}