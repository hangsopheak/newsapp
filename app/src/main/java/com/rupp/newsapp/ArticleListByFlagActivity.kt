
package com.rupp.newsapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.rupp.newsapp.core.data.ArticleDataSource
import com.rupp.newsapp.core.domain.model.Article
import com.rupp.newsapp.core.presentation.ArticleCardVertical
import com.rupp.newsapp.core.utils.ArticleFlagEnum
import com.rupp.newsapp.ui.theme.NewsAppTheme

class ArticleListByFlagActivity : ComponentActivity() {

    var articleFlagId:Int = 0;

    override fun onStart() {
        super.onStart()
        articleFlagId = intent.getIntExtra("article_flag_id", 0)
    }
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                val context = LocalContext.current
                val articles: List<Article> = when (ArticleFlagEnum.fromId(articleFlagId)) {
                    ArticleFlagEnum.BREAKING_NEWS -> ArticleDataSource.allArticles.filter { it.isBreaking }
                    ArticleFlagEnum.FEATURED_NEWS -> ArticleDataSource.allArticles.filter { it.isFeatured }
                    ArticleFlagEnum.LATEST_NEWS -> ArticleDataSource.allArticles.filter { it.isLatest }
                    else -> ArticleDataSource.allArticles
                }
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(ArticleFlagEnum.fromId(articleFlagId)?.description ?: "") },
                            navigationIcon = {
                                IconButton(onClick = { this.finish() }) {
                                    Icon(
                                        Icons.AutoMirrored.Filled.ArrowBack,
                                        contentDescription = "Back"
                                    )
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier.padding(innerPadding),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {

                        items(articles.size) { index ->
                            ArticleCardVertical(
                                article = articles[index],
                                showBookMark = false,
                                onClick = {
                                    onClickArticle(context, articles[index])
                                })
                        }
                    }
                }
            }
        }
    }

    fun onClickArticle(context: Context,  article: Article) {
        val intent = Intent(context, ArticleDetailActivity::class.java)
        intent.putExtra("article_id", article.id)
        context.startActivity(intent)
    }


}

