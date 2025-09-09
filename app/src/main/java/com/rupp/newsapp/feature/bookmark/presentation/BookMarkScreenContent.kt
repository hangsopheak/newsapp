package com.rupp.newsapp.feature.bookmark.presentation

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.rupp.newsapp.ArticleDetailActivity
import com.rupp.newsapp.core.domain.model.Article
import com.rupp.newsapp.core.presentation.ArticleCardVertical
import com.rupp.newsapp.core.data.ArticleDataSource

@Composable
fun BookMarkScreenContent(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    LazyColumn(
        modifier = modifier.padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        val bookMarkedArticles = ArticleDataSource.allArticles.filter { it.isBookMarked }
        items(bookMarkedArticles.size) { index ->
            ArticleCardVertical(article = bookMarkedArticles[index], showBookMark = false, onClick = {
                onClickArticle(context, bookMarkedArticles[index])
            })
        }
    }

}

fun onClickArticle(context: Context,  article: Article) {
    val intent = Intent(context, ArticleDetailActivity::class.java)
    intent.putExtra("article_id", article.id)
    context.startActivity(intent)
}
