package com.rupp.newsapp.core.data

import com.rupp.newsapp.core.utils.ImageUrlHelper
import com.rupp.newsapp.core.domain.model.Category

object CategoryData {
    val categories = listOf(
        Category(1, "Technology", ImageUrlHelper.getPicsumUrl(400, 300, 1)),
        Category(2, "Sports", ImageUrlHelper.getPicsumUrl(400, 300, 2)),
        Category(3, "Politics", ImageUrlHelper.getPicsumUrl(400, 300, 3)),
        Category(4, "Health", ImageUrlHelper.getPicsumUrl(400, 300, 4)),
        Category(5, "Entertainment", ImageUrlHelper.getPicsumUrl(400, 300, 5)),
        Category(6, "Science", ImageUrlHelper.getPicsumUrl(400, 300, 6)),
        Category(7, "Business", ImageUrlHelper.getPicsumUrl(400, 300, 7)),
        Category(8, "World", ImageUrlHelper.getPicsumUrl(400, 300, 8)),
        Category(9, "Lifestyle", ImageUrlHelper.getPicsumUrl(400, 300, 9)),
        Category(10, "Travel", ImageUrlHelper.getPicsumUrl(400, 300, 10))
    )
}