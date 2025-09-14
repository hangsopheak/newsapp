
package com.rupp.newsapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.rupp.newsapp.feature.article.presentation.ArticleScreen
import com.rupp.newsapp.feature.article.presentation.ArticleViewModel
import com.rupp.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint

class ArticleDetailActivity : ComponentActivity() {

    private var articleId:Int = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        articleId = intent.getIntExtra("article_id", 0)

        setContent {
            val viewModel : ArticleViewModel = hiltViewModel()
            val state by viewModel.uiState.collectAsState()
            val context = LocalContext.current

            LaunchedEffect(Unit) {
                if (articleId != 0) { // Add safety check
                    viewModel.loadArticleDetail(articleId)
                }
            }

            NewsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when {
                        state.isLoading -> {
                            // Show loading indicator
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator()
                            }
                        }
                        state.error != null -> {
                            LaunchedEffect(state.error) {
                                Toast.makeText(context, "Error: ${state.error}", Toast.LENGTH_SHORT).show()
                            }
                            // Show error UI instead of just toast
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("Error: ${state.error}")
                            }
                        }
                        state.article != null -> {
                            ArticleScreen(
                                article = state.article!!,
                                onBackClick = { finish() }
                            )

                        }
                        else -> {
                            // Handle case where article is null but no error
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("No article found")
                            }
                        }
                    }
                }
            }
        }
    }
}

