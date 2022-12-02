package project.android.pocketpods.podcasts.data.remote.models.bestPodcasts

import project.android.pocketpods.podcasts.data.remote.models.trendingPodcasts.Podcast

//TODO : Implement get /languages

data class BestPodcastsByGenre(
    val has_next: Boolean,
    val has_previous: Boolean,
    val id: Int,
    val name: String, //genre name if (genre id not given in api then "Podcasts")
    val next_page_number: Int,
    val page_number: Int,
    val parent_id: Int,
    val podcasts: List<Podcast>,
    val previous_page_number: Int,
    val total: Int
)