package com.rupp.newsapp.shared.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rupp.newsapp.R
import com.rupp.newsapp.shared.data.local.ArticleDataSource
import com.rupp.newsapp.shared.domain.model.Article
import com.rupp.newsapp.core.utils.DateFormatUtil.toArticleDate

@Composable
fun ArticleTitleSection(
    modifier: Modifier = Modifier,
    article: Article,
    titleFontSize : Int = 20,
    showBookMark: Boolean = true
) {
    var isBookmarked by remember(article.isBookMarked) { mutableStateOf(article.isBookMarked) }
    Column (modifier = modifier) {
        Text(
            text = article.title,
            style = MaterialTheme.typography.titleMedium,
            fontSize = titleFontSize.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Row(
            modifier = Modifier
                .padding(bottom = 4.dp)
                .padding(top = 4.dp)
            ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.author),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.size(8.dp))
            Column {
                Text(
                    text = article.author ?: "Unknown",
                    maxLines = 1,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = " ${article.publishedAt.toArticleDate()}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            if(showBookMark){
                // Push actions to the right
                Spacer(modifier = Modifier.weight(1f))

                // Bookmark button
                IconButton(onClick = {
                    // save article as bookmark
                    isBookmarked = !isBookmarked
                }) {
                    Icon(
                        imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                        contentDescription = "Bookmark",
                        modifier = Modifier.size(20.dp),
                        tint = if (isBookmarked) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                // Share button
                IconButton(onClick = {
                    // Handle share action
                }) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share",
                        modifier = Modifier.size(20.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ArticleTitleSection(){
    ArticleTitleSection(article = ArticleDataSource.allArticles[1])
}