package com.rupp.newsapp.feature.home.presentation

import com.rupp.newsapp.shared.domain.model.Article

data class HomeUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val breakingArticles: List<Article> = emptyList(),
    val featuredArticles: List<Article> = emptyList(),
    val latestArticles: List<Article> = emptyList(),
)
