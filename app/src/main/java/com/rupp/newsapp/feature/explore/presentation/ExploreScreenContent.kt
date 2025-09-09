package com.rupp.newsapp.feature.explore.presentation

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.tooling.preview.Preview
import com.rupp.newsapp.ArticleDetailActivity
import com.rupp.newsapp.core.data.CategoryData
import com.rupp.newsapp.core.domain.model.Article
import com.rupp.newsapp.core.domain.model.Category
import com.rupp.newsapp.core.presentation.ArticleCardVertical
import com.rupp.newsapp.core.data.ArticleDataSource

@Composable
@Preview
fun ExploreScreenContent() {
    var selectedCategory by remember { mutableStateOf<Category?>(null) }
    val context = LocalContext.current
    var filteredArticles by remember(selectedCategory) { mutableStateOf(ArticleDataSource.allArticles) }

    Column {
        // Category Chips
        CategoryFilterChips(
            categories = CategoryData.categories,
            selectedCategoryId = selectedCategory?.id,
            onCategorySelected = { selectedCategory = it }
        )

        // Articles for selected category
        filteredArticles = if (selectedCategory == null) {
            ArticleDataSource.allArticles // Show all articles if no category is selected
        } else {
            ArticleDataSource.articlesByCategory[selectedCategory!!.id] ?: emptyList() // Show articles for the selected category
        }

        LazyColumn(
            modifier = Modifier.padding(horizontal = 10.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (filteredArticles.isNotEmpty()) {
                item {
                    HeroArticleCard(article = filteredArticles[0], onClick = {onClickArticle(context, filteredArticles[0])})
                }
                val remainingArticles = filteredArticles.drop(1)
                items(remainingArticles.size) { index ->
                    ArticleCardVertical(article = remainingArticles[index], showBookMark = false, onClick = {
                        onClickArticle(context, remainingArticles[index])
                    })
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