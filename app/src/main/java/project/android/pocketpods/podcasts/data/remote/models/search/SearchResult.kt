package project.android.pocketpods.podcasts.data.remote.models.search

data class SearchResult(
    val count: Int,
    val next_offset: Int,
    val results: List<Result>,
    val total: Int
)