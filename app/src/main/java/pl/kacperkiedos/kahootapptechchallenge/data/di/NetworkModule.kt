package pl.kacperkiedos.kahootapptechchallenge.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pl.kacperkiedos.kahootapptechchallenge.BuildConfig
import pl.kacperkiedos.kahootapptechchallenge.data.remote.QuizService
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        setLevel(
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        )
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(loggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder().also { builder ->
            builder.addInterceptor(loggingInterceptor)
        }.build()

    @Singleton
    @Provides
    fun providesJson() = Json {
        ignoreUnknownKeys = true
    }

    @Singleton
    @Provides
    fun providesKahootRetrofit(client: OkHttpClient, json: Json): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(
            json.asConverterFactory("application/json; charset=UTF8".toMediaType())
        )
        .client(client)
        .build()

    @Singleton
    @Provides
    fun provideQuizService(retrofit: Retrofit): QuizService =
        retrofit.create(QuizService::class.java)
}