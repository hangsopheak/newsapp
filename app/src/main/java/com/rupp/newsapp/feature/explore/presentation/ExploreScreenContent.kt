package com.rupp.newsapp.feature.explore.presentation

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rupp.newsapp.ArticleDetailActivity
import com.rupp.newsapp.shared.data.repository.ArticleRepository
import com.rupp.newsapp.shared.data.repository.CategoryRepository
import com.rupp.newsapp.shared.domain.model.Article
import com.rupp.newsapp.shared.presentation.ArticleCardVertical

@Composable
@Preview
fun ExploreScreenContent() {

    val articleRepository = remember { ArticleRepository() }
    val categoryRepository = remember { CategoryRepository() }
    val viewModel = remember {
        ExploreViewModel(
            articleRepository = articleRepository,
            categoryRepository = categoryRepository
        )
    }
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    Column {


        // --- Categories Section ---
        when {
            uiState.categoriesState.isLoading -> {
                // Placeholder or shimmer for chips
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator(modifier = Modifier.size(24.dp))
                }
            }

            uiState.categoriesState.error != null -> {
                LaunchedEffect(uiState.categoriesState.error) {
                    Toast.makeText(
                        context,
                        "Error: ${uiState.categoriesState.error}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            uiState.categoriesState.categories.isNotEmpty() -> {
                CategoryFilterChips(
                    categories = uiState.categoriesState.categories,
                    selectedCategoryId = uiState.categoriesState.selectedCategoryId,
                    onCategorySelected = { id ->
                        viewModel.loadArticlesByCategory(id)
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // --- Articles Section ---
        when {
            uiState.articlesState.isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            uiState.articlesState.error != null -> {
                LaunchedEffect(uiState.articlesState.error) {
                    Toast.makeText(
                        context,
                        "Error: ${uiState.articlesState.error}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            uiState.articlesState.articles.isNotEmpty() -> {
                LazyColumn(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        val first = uiState.articlesState.articles.first()
                        HeroArticleCard(
                            article = first,
                            onClick = { onClickArticle(context, first) }
                        )
                    }
                    // Remaining articles
                    items(uiState.articlesState.articles.drop(1)) { article ->
                        ArticleCardVertical(
                            article = article,
                            showBookMark = false,
                            onClick = { onClickArticle(context, article) }
                        )
                    }
                }
            }
        }
    }
}

private fun onClickArticle(
    context: Context,
    article: Article
) {
    val intent = Intent(context, ArticleDetailActivity::class.java)
    intent.putExtra("article_id", article.id)
    context.startActivity(intent)
}