package com.rupp.newsapp.feature.home.presentation

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.rupp.newsapp.ArticleDetailActivity
import com.rupp.newsapp.shared.domain.model.Article
import com.rupp.newsapp.feature.home.data.HomeData
import com.rupp.newsapp.ui.theme.NewsAppTheme

@Composable
fun HomeArticleItems(articles: List<Article>){
    val context = LocalContext.current

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(articles) { article ->
            ArticleCard(
                article = article,
                onClick = {
                    val intent = Intent(context, ArticleDetailActivity::class.java)
                    intent.putExtra("article_id", article.id)
                    context.startActivity(intent)
                }
            )
        }
    }
}

@Composable
fun HomeArticleItemsPreview1(){
    NewsAppTheme {
        HomeArticleItems(HomeData.latestArticles)
    }
}

//@Preview(showBackground = true)
//@Composable
//fun HomeArticleItemsPreview2(){
//    HomeArticleItems(HomeData.breakingArticles)
//}
//
//@Preview(showBackground = true)
//@Composable
//fun HomeArticleItemsPreview3(){
//    HomeArticleItems(HomeData.featuredArticles)
//}

//@Preview(showBackground = true, backgroundColor = 0XFFFFFF)
//@Composable
//fun ArticleCardPreview(){
//    NewsAppTheme {
//        ArticleCard(HomeData.latestArticles[0])
//    }
//}
//@Preview(showBackground = true, backgroundColor = 0XFFFFFF)
//@Composable
//fun ArticleCardPreview2(){
//    NewsAppTheme {
//        ArticleCard(HomeData.latestArticles[1])
//    }
//}
@Composable
fun ArticleCard(article: Article, onClick: () -> Unit = {}) {
    Card(
        modifier = Modifier
            .clickable(onClick = onClick)
            .width(210.dp)
            .padding(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
             AsyncImage(
                 model = article.imageUrl,
                 contentDescription = null,
                 modifier = Modifier
                     .fillMaxWidth()
                     .height(110.dp)
                     .clip(RoundedCornerShape(8.dp)),
                 contentScale = ContentScale.Crop
             )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = article.title,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 16.sp,
                maxLines = 2,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "By ${article.author}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = article.content,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
            )
        }
    }
}
