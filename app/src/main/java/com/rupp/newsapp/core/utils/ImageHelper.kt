package com.rupp.newsapp.core.utils

object ImageUrlHelper {

    // 4:3 Ratio dimensions
    private val LARGE_SIZE = "800x600"    // For featured articles
    private val MEDIUM_SIZE = "640x480"   // For regular articles
    private val SMALL_SIZE = "400x300"    // For thumbnails

    // Picsum Photos - Reliable, fast, beautiful images
    fun getPicsumUrl(
        width: Int = 800,
        height: Int = 600,
        seed: Int? = null
    ): String {
        return if (seed != null) {
            "https://picsum.photos/${width}/${height}?random=$seed"
        } else {
            "https://picsum.photos/${width}/${height}"
        }
    }

    // Category-specific image URLs
    fun getCategoryImageUrl(categoryId: Int, size: ImageSize = ImageSize.MEDIUM): String {
        val dimensions = when (size) {
            ImageSize.SMALL -> SMALL_SIZE
            ImageSize.MEDIUM -> MEDIUM_SIZE
            ImageSize.LARGE -> LARGE_SIZE
        }

        return when (categoryId) {
            1 -> "https://source.unsplash.com/$dimensions/?technology,computer"
            2 -> "https://source.unsplash.com/$dimensions/?sports,football"
            3 -> "https://source.unsplash.com/$dimensions/?politics,government"
            4 -> "https://source.unsplash.com/$dimensions/?health,medical"
            5 -> "https://source.unsplash.com/$dimensions/?entertainment,movie"
            6 -> "https://source.unsplash.com/$dimensions/?science,laboratory"
            7 -> "https://source.unsplash.com/$dimensions/?business,office"
            8 -> "https://source.unsplash.com/$dimensions/?world,globe"
            9 -> "https://source.unsplash.com/$dimensions/?lifestyle,people"
            10 -> "https://source.unsplash.com/$dimensions/?travel,destination"
            else -> getPicsumUrl(800, 600, categoryId)
        }
    }

}

enum class ImageSize {
    SMALL,   // 400x300
    MEDIUM,  // 640x480
    LARGE    // 800x600
}