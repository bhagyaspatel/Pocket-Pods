package project.android.pocketpods.podcasts.data.remote.models.trendingPodcasts

import com.google.gson.annotations.SerializedName

data class Podcast(
    val audio_length_sec: Int,
    val country: String,
    val description: String,
    val earliest_pub_date_ms: Long,
    val genre_ids: List<Int>,
    val id: String,
    val language: String,
    val latest_pub_date_ms: Long,
    val publisher: String,
    val thumbnail: String,
    val title: String,
    val total_episodes: Int,
    val type: String,
    val website: String
)