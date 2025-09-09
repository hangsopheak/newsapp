package com.rupp.newsapp.feature.explore.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rupp.newsapp.core.domain.model.Article
import com.rupp.newsapp.core.presentation.ArticleTitleSection
import com.rupp.newsapp.core.data.ArticleDataSource
import com.rupp.newsapp.ui.theme.NewsAppTheme

@Composable
fun HeroArticleCard(modifier: Modifier = Modifier, article: Article, onClick: () -> Unit = {}) {
    Column(
        modifier = modifier
            .padding(5.dp)
            .fillMaxWidth().clickable(onClick = onClick)
    ) {
        AsyncImage(
            model = article.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        ArticleTitleSection(article = article)
        Spacer(modifier = Modifier.size(20.dp))
    }
}



@Composable
@Preview(showBackground = true)
fun HeroArticleCardPreview() {
    NewsAppTheme {
        HeroArticleCard(Modifier, ArticleDataSource.allArticles[3])
    }

}