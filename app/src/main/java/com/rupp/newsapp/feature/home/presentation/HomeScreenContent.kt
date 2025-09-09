package com.rupp.newsapp.core.utils
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices.PIXEL_5
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rupp.newsapp.ArticleDetailActivity
import com.rupp.newsapp.ArticleListByFlagActivity
import com.rupp.newsapp.core.domain.model.Article
import com.rupp.newsapp.feature.home.data.HomeData
import com.rupp.newsapp.feature.home.presentation.HomeArticleItems
import com.rupp.newsapp.feature.home.presentation.SectionTitleBar
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
    NewsAppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NewsSection(ArticleFlagEnum.BREAKING_NEWS, HomeData.breakingArticles)
            NewsSection(ArticleFlagEnum.FEATURED_NEWS, HomeData.featuredArticles)
            NewsSection(ArticleFlagEnum.LATEST_NEWS, HomeData.latestArticles)
        }
    }
}

fun onSeeMoreClicked(context: Context,  articleFlagId: Int) {
    val intent = Intent(context, ArticleListByFlagActivity::class.java)
    intent.putExtra("article_flag_id", articleFlagId)
    context.startActivity(intent)
}