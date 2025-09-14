package com.rupp.newsapp.feature.home.presentation

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rupp.newsapp.core.network.ApiResult
import com.rupp.newsapp.shared.data.repository.ArticleRepository
import com.rupp.newsapp.shared.domain.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for the Home screen.
 *
 * This class is responsible for preparing and managing the data for the Home UI.
 * It communicates with the data layer to fetch news articles and exposes them
 * to the UI, handling business logic and state management.
 */
@HiltViewModel
class HomeViewModel @Inject constructor (private val repository: ArticleRepository) : ViewModel()  {
    /**
     * Private mutable state flow that holds the current state of the Home screen.
     * This is internal to the ViewModel and should not be exposed to the UI directly.
     * It is used to emit new states from within the ViewModel.
     */
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: MutableStateFlow<HomeUiState> = _uiState

    fun loadHomeArticles(){
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)

            // to call multiple suspend functions concurrently and await their results
            val breakingDeferred = async { repository.getBreakingArticles() }
            val featuredDeferred = async { repository.getFeaturedArticles() }
            val latestDeferred = async { repository.getLatestArticles() }

            val breaking = breakingDeferred.await()
            val featured = featuredDeferred.await()
            val latest = latestDeferred.await()

            if (breaking is ApiResult.Success &&
                featured is ApiResult.Success &&
                latest is ApiResult.Success
            ) {
                _uiState.value = HomeUiState(
                    breakingArticles = breaking.data,
                    featuredArticles = featured.data,
                    latestArticles = latest.data,
                    isLoading = false
                )
            } else {
                // If any of them failed, treat it as an error
                val errorMessage = listOfNotNull(
                    (breaking as? ApiResult.Error)?.exception?.message,
                    (featured as? ApiResult.Error)?.exception?.message,
                    (latest as? ApiResult.Error)?.exception?.message
                ).joinToString(" | ")

                _uiState.value = HomeUiState(
                    error = errorMessage.ifEmpty { "Failed to load articles" },
                    isLoading = false
                )
            }

        }
    }
}