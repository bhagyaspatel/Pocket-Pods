package project.android.pocketpods.podcasts.data.remote.models.search

import project.android.pocketpods.podcasts.data.remote.models.search.PodcastSearchResult

data class Result(
    val audio: String,
    val audio_length_sec: Int,
    val description_original: String,
    val id: String,
    val podcast: PodcastSearchResult,
    val thumbnail: String,
    val title_original: String,
)