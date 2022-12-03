package project.android.pocketpods.podcasts.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import project.android.pocketpods.podcasts.data.remote.interfaces.PodcastApiService
import project.android.pocketpods.podcasts.utilities.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PodcastModule {

    @Provides
    @Singleton
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    fun providesRetrofitPodcastApi(retrofit: Retrofit) : PodcastApiService{
        return retrofit.create(PodcastApiService::class.java)
    }

}