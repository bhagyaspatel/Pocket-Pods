package project.android.pocketpods.podcasts.data.remote.models.trendingPodcasts

import project.android.pocketpods.podcasts.data.remote.models.trendingPodcasts.Podcast

data class TrendingPodcasts(
    val has_next: Boolean,
    val has_previous: Boolean,
    val id: Int,
    val name: String,
    val next_page_number: Int,
    val page_number: Int,
    val parent_id: Int,
    val podcasts: List<Podcast>,
    val previous_page_number: Int,
    val total: Int
)