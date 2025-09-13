package com.rupp.newsapp.feature.article.presentation

import com.rupp.newsapp.shared.domain.model.Article

data class ArticleUiState (
    val isLoading: Boolean = false,
    val error: String? = null,
    val article: Article? = null
)