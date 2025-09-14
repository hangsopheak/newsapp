package com.rupp.newsapp.shared.data.repository

import com.rupp.newsapp.core.network.ApiResult
import com.rupp.newsapp.core.network.NetworkUtils
import com.rupp.newsapp.shared.data.remote.CategoryApiService
import com.rupp.newsapp.shared.domain.model.Category
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryRepository @Inject constructor(private val api: CategoryApiService) {

    suspend fun getCategories(): ApiResult<List<Category>> {
        return NetworkUtils.safeApiCall { api.getCategories() }
    }
}