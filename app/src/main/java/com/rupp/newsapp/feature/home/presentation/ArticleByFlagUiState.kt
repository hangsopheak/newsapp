package com.rupp.newsapp.feature.home.presentation

import com.rupp.newsapp.shared.domain.model.Article

data class ArticleByFlagUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val articles: List<Article> = emptyList(),
)
