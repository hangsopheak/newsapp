package com.rupp.newsapp.core.di

import com.rupp.newsapp.core.network.RetrofitInstance
import com.rupp.newsapp.shared.data.remote.ArticleApiService
import com.rupp.newsapp.shared.data.remote.CategoryApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {


    @Provides
    @Singleton
    fun provideArticleApiService(): ArticleApiService =
        RetrofitInstance.retrofit.create(ArticleApiService::class.java)

    @Provides
    @Singleton
    fun provideCategoryApiService(): CategoryApiService =
        RetrofitInstance.retrofit.create(CategoryApiService::class.java)



}