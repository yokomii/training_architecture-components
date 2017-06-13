package com.example.yokomii.architecturecomponents.di

import com.example.yokomii.architecturecomponents.api.MyCallAdapterFactory
import com.example.yokomii.architecturecomponents.api.MyService
import com.example.yokomii.architecturecomponents.util.MyViewModelFactory
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/**
 * Applicationモジュール
 */
@Module(subcomponents = arrayOf(ViewModelSubComponent::class))
class AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient() = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .apply {
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY
                addInterceptor(interceptor)
            }.build()

    @Singleton
    @Provides
    fun provideGson() = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    @Singleton
    @Provides
    fun provideMyService(client: OkHttpClient, gson: Gson) = Retrofit.Builder()
            .baseUrl("https://api.photozou.jp/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(MyCallAdapterFactory())
            .build()
            .create(MyService::class.java)

    @Singleton
    @Provides
    fun provideMyViewModelFactory(viewModelSubComponent: ViewModelSubComponent.Builder) =
            MyViewModelFactory(viewModelSubComponent.build())
}
