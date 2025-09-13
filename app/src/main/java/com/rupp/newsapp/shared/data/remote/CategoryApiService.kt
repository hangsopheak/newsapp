package com.rupp.newsapp.shared.data.remote

import com.rupp.newsapp.shared.domain.model.Article
import com.rupp.newsapp.shared.domain.model.Category
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CategoryApiService {
    @GET("categories")
    suspend fun getCategories(): Response<List<Category>>
}