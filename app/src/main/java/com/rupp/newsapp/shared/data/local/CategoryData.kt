package com.rupp.newsapp.shared.data.local

import com.rupp.newsapp.core.utils.ImageUrlHelper
import com.rupp.newsapp.shared.domain.model.Category

object CategoryData {
    val categories = listOf(
        Category(1, "Technology"),
        Category(2, "Sports"),
        Category(3, "Politics"),
        Category(4, "Health"),
        Category(5, "Entertainment"),
        Category(6, "Science"),
        Category(7, "Business"),
        Category(8, "World"),
        Category(9, "Lifestyle"),
        Category(10, "Travel")
    )
}