package project.android.pocketpods.podcasts

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext

@HiltAndroidApp
class PodcastApplication : Application(){
    init {
        app = this
    }

    companion object{
        private lateinit var app : PodcastApplication

        fun getContext() : Context {return app.applicationContext}
    }
}