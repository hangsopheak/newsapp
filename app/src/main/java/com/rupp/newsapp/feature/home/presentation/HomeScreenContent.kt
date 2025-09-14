package com.rupp.newsapp.feature.home.presentation
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices.PIXEL_5
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rupp.newsapp.ArticleListByFlagActivity
import com.rupp.newsapp.shared.domain.model.Article
import com.rupp.newsapp.shared.utils.ArticleFlagEnum
import com.rupp.newsapp.ui.theme.NewsAppTheme


@Composable
fun NewsSection(
    articleFlagEnum: ArticleFlagEnum,
    articles: List<Article>,

    ) {
    val context = LocalContext.current
    SectionTitleBar(articleFlagEnum.description, onSeeMoreClicked = { onSeeMoreClicked(context, articleFlagEnum.id) })
    HomeArticleItems(articles)
    Spacer(modifier = Modifier.size(10.dp))
}

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, device = PIXEL_5)
fun HomeScreenContent() {
    val viewModel: HomeViewModel = hiltViewModel()
    val state by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    LaunchedEffect(Unit) { viewModel.loadHomeArticles() }

    NewsAppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            when {
                state.isLoading -> CircularProgressIndicator()
                state.error != null -> {
                    LaunchedEffect(state.error) {
                        Toast.makeText(context, "Error: ${state.error}", Toast.LENGTH_SHORT).show()
                    }
                }
                else -> {
                    NewsSection(ArticleFlagEnum.BREAKING_NEWS, state.breakingArticles)
                    NewsSection(ArticleFlagEnum.FEATURED_NEWS, state.featuredArticles)
                    NewsSection(ArticleFlagEnum.LATEST_NEWS, state.latestArticles)
                }
            }

        }
    }
}

fun onSeeMoreClicked(context: Context,  articleFlagId: Int) {
    val intent = Intent(context, ArticleListByFlagActivity::class.java)
    intent.putExtra("article_flag_id", articleFlagId)
    context.startActivity(intent)
}