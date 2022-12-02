package project.android.pocketpods.podcasts.data.remote.models.justListen

data class JustListenPodcast(
    val id: String,
    val image: String,
    val listen_score: Any,
    val listen_score_global_rank: Any,
    val listennotes_url: String,
    val publisher: String,
    val thumbnail: String,
    val title: String
)