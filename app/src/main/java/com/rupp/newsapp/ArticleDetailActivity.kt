
package com.rupp.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.rupp.newsapp.core.data.ArticleDataSource
import com.rupp.newsapp.core.domain.model.Article
import com.rupp.newsapp.feature.article.presentation.ArticleScreen
import com.rupp.newsapp.ui.theme.NewsAppTheme

class ArticleDetailActivity : ComponentActivity() {

    private var articleId:Int = 0;

    override fun onStart() {
        super.onStart()
        articleId = intent.getIntExtra("article_id", 0)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val article: Article = ArticleDataSource.allArticles.find { it.id == articleId } ?: ArticleDataSource.allArticles.first()
                    ArticleScreen(article = article, onBackClick = { finish() })
                }
            }
        }
    }
}

