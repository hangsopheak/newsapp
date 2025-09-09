package com.rupp.newsapp.feature.home.data

import com.rupp.newsapp.core.utils.ImageUrlHelper
import com.rupp.newsapp.core.data.CategoryData.categories
import com.rupp.newsapp.core.domain.model.Article
import java.util.Calendar
import java.util.Date
import kotlin.random.Random

object HomeData {


    // ---------------- Breaking News ----------------
    val breakingArticles = listOf(
        Article(
            id = 1,
            categoryId = 2,
            title = "Breaking: Star Striker Injured Ahead of Championship",
            content = "In a shocking turn, the leading scorer has been sidelined just hours before the finals.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 22),
            author = "Sports Desk",
            publishedAt = randomPublishedAt(10),
            category = categories[1],
            isBreaking = true
        ),
        Article(
            id = 2,
            categoryId = 3,
            title = "Breaking: Parliament Dissolved Amid Political Turmoil",
            content = "The Prime Minister announced the immediate dissolution of parliament, triggering early elections.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 23),
            author = "Political Analyst",
            publishedAt = randomPublishedAt(10),
            category = categories[2],
            isBreaking = true
        ),
        Article(
            id = 3,
            categoryId = 8,
            title = "Breaking: Earthquake Strikes Coastal Region",
            content = "Authorities confirm a 6.8 magnitude earthquake hit the coastal area, with evacuation underway.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 24),
            author = "World News",
            publishedAt = randomPublishedAt(10),
            category = categories[7],
            isBreaking = true
        ),
        Article(
            id = 4,
            categoryId = 1,
            title = "Breaking: Major Data Breach at Leading Tech Firm",
            content = "Hackers accessed sensitive customer data, raising cybersecurity concerns worldwide.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 25),
            author = "Tech Insider",
            publishedAt = randomPublishedAt(10),
            category = categories[0],
            isBreaking = true
        ),
        Article(
            id = 5,
            categoryId = 4,
            title = "Breaking: New Virus Variant Detected in Asia",
            content = "Health officials warn of a new fast-spreading variant, urging renewed precautions.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 26),
            author = "Medical Correspondent",
            publishedAt = randomPublishedAt(10),
            category = categories[3],
            isBreaking = true
        ),
        Article(
            id = 6,
            categoryId = 7,
            title = "Breaking: Stock Market Plunges Amid Global Fears",
            content = "Markets saw the steepest drop in years as investors reacted to uncertainty.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 27),
            author = "Finance Team",
            publishedAt = randomPublishedAt(10),
            category = categories[6],
            isBreaking = true
        )
    )

    // ---------------- Featured Articles ----------------
    val featuredArticles = listOf(
        Article(
            id = 101,
            categoryId = 1,
            title = "The Future of Artificial Intelligence in Daily Life",
            content = "From healthcare to education, AI is reshaping how we live and work.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 28),
            author = "Tech Review",
            publishedAt = randomPublishedAt(120),
            category = categories[0],
            isFeatured = true
        ),
        Article(
            id = 102,
            categoryId = 5,
            title = "Behind the Scenes of This Summer’s Biggest Blockbuster",
            content = "A look at the cast, crew, and production challenges of the year’s hottest movie.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 29),
            author = "Entertainment Weekly",
            publishedAt = randomPublishedAt(120),
            category = categories[4],
            isFeatured = true
        ),
        Article(
            id = 103,
            categoryId = 6,
            title = "Exploring Space: The Next Decade of Discovery",
            content = "Scientists plan ambitious missions to Mars and beyond, with global cooperation.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 30),
            author = "Science Editor",
            publishedAt = randomPublishedAt(120),
            category = categories[5],
            isFeatured = true
        ),
        Article(
            id = 104,
            categoryId = 9,
            title = "Minimalist Living: How Less Can Be More",
            content = "A growing number embrace simplicity, cutting clutter for better mental health.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 31),
            author = "Lifestyle Blogger",
            publishedAt = randomPublishedAt(120),
            category = categories[8],
            isFeatured = true
        ),
        Article(
            id = 105,
            categoryId = 10,
            title = "Top 10 Underrated Travel Destinations for 2025",
            content = "Hidden gems across the globe offer unique experiences away from tourist crowds.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 32),
            author = "Travel Journal",
            publishedAt = randomPublishedAt(120),
            category = categories[9],
            isFeatured = true
        ),
        Article(
            id = 106,
            categoryId = 7,
            title = "Green Investments: The Future of Business Growth",
            content = "Companies that prioritize sustainability are seeing long-term financial success.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 33),
            author = "Business Insights",
            publishedAt = randomPublishedAt(120),
            category = categories[6],
            isFeatured = true
        )
    )

    // ---------------- Latest Articles ----------------
    val latestArticles = listOf(
        Article(
            id = 201,
            categoryId = 2,
            title = "Local Team Secures Victory in Friendly Match",
            content = "Fans celebrated as the underdogs secured a surprising 2-1 win.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 34),
            author = "Sports Reporter",
            publishedAt = randomPublishedAt(30),
            category = categories[1],
            isLatest = true
        ),
        Article(
            id = 202,
            categoryId = 3,
            title = "Government Proposes New Tax Reform Bill",
            content = "The proposed changes aim to simplify filing and reduce rates for small businesses.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 35),
            author = "Political Desk",
            publishedAt = randomPublishedAt(30),
            category = categories[2],
            isLatest = true
        ),
        Article(
            id = 203,
            categoryId = 4,
            title = "Doctors Recommend New Daily Habits for Heart Health",
            content = "Experts suggest small lifestyle changes can dramatically improve heart health.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 36),
            author = "Health Reporter",
            publishedAt = randomPublishedAt(30),
            category = categories[3],
            isLatest = true
        ),
        Article(
            id = 204,
            categoryId = 5,
            title = "Streaming Service Adds Award-Winning Drama Series",
            content = "The critically acclaimed show is now available for subscribers worldwide.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 37),
            author = "Culture Critic",
            publishedAt = randomPublishedAt(30),
            category = categories[4],
            isLatest = true
        ),
        Article(
            id = 205,
            categoryId = 6,
            title = "Breakthrough in Renewable Energy Storage Announced",
            content = "Scientists reveal a new battery technology with double the capacity.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 38),
            author = "Science Correspondent",
            publishedAt = randomPublishedAt(30),
            category = categories[5],
            isLatest = true
        ),
        Article(
            id = 206,
            categoryId = 7,
            title = "Tech Giants Report Strong Quarterly Earnings",
            content = "Leading firms in the industry posted higher-than-expected profits.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 39),
            author = "Market Watch",
            publishedAt = randomPublishedAt(30),
            category = categories[6],
            isLatest = true
        )
    )

}


// helper for publishedAt
fun randomPublishedAt(maxMinutesAgo: Int): Date {
    val minutesAgo = Random.nextInt(1, maxMinutesAgo)
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.MINUTE, -minutesAgo)
    return calendar.time
}
