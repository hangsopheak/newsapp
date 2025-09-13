package com.rupp.newsapp.shared.data.repository

import com.rupp.newsapp.core.network.ApiResult
import com.rupp.newsapp.core.network.NetworkUtils
import com.rupp.newsapp.core.network.RetrofitInstance
import com.rupp.newsapp.shared.data.remote.CategoryApiService
import com.rupp.newsapp.shared.domain.model.Category

class CategoryRepository {
    private val api = RetrofitInstance.retrofit.create(CategoryApiService::class.java)

    suspend fun getCategories(): ApiResult<List<Category>> {
        return NetworkUtils.safeApiCall { api.getCategories() }
    }
}