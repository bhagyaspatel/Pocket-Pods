package project.android.pocketpods.podcasts.data.remote.models.justListen

data class JustListen(
    val audio: String,
    val audio_length_sec: Int,
    val description: String,
    val explicit_content: Boolean,
    val id: String,
    val image: String,
    val link: String,
    val maybe_audio_invalid: Boolean,
    val justListenPodcast: JustListenPodcast,
    val pub_date_ms: Long,
    val thumbnail: String,
    val title: String
)