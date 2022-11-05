package project.android.pocketpods.podcasts.data.remote.models.search

data class PodcastSearchResult(
    val genre_ids: List<Int>,
    val id: String,
    val image: String,
    val publisher_original: String,
    val thumbnail: String,
    val title_original: String
)