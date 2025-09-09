package com.rupp.newsapp.core.data

import com.rupp.newsapp.core.domain.model.Article
import com.rupp.newsapp.core.utils.ImageUrlHelper
import com.rupp.newsapp.feature.home.data.randomPublishedAt

object ArticleDataSource {
    val breakingArticles = listOf(
        Article(
            id = 1,
            categoryId = 2,
            title = "Breaking: Star Striker Injured Ahead of Championship",
            content = "In a shocking turn, the leading scorer has been sidelined just hours before the finals.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 22),
            author = "Sports Desk",
            publishedAt = randomPublishedAt(10),
            category = CategoryData.categories[1],
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
            category = CategoryData.categories[2],
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
            category = CategoryData.categories[7],
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
            category = CategoryData.categories[0],
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
            category = CategoryData.categories[3],
            isBreaking = true,
            isBookMarked = true
        ),
        Article(
            id = 6,
            categoryId = 7,
            title = "Breaking: Stock Market Plunges Amid Global Fears",
            content = "Markets saw the steepest drop in years as investors reacted to uncertainty.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 27),
            author = "Finance Team",
            publishedAt = randomPublishedAt(10),
            category = CategoryData.categories[6],
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
            category = CategoryData.categories[0],
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
            category = CategoryData.categories[4],
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
            category = CategoryData.categories[5],
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
            category = CategoryData.categories[8],
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
            category = CategoryData.categories[9],
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
            category = CategoryData.categories[6],
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
            category = CategoryData.categories[1],
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
            category = CategoryData.categories[2],
            isLatest = true,
            isBookMarked = true
        ),
        Article(
            id = 203,
            categoryId = 4,
            title = "Doctors Recommend New Daily Habits for Heart Health",
            content = "Experts suggest small lifestyle changes can dramatically improve heart health.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 36),
            author = "Health Reporter",
            publishedAt = randomPublishedAt(30),
            category = CategoryData.categories[3],
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
            category = CategoryData.categories[4],
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
            category = CategoryData.categories[5],
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
            category = CategoryData.categories[6],
            isLatest = true
        )
    )

    private val otherArticles = listOf(
        // Tech (Category 1)
        Article(
            id = 301,
            categoryId = 1,
            title = "New Smartphone with Holographic Display Unveiled",
            content = "A startup has just launched a phone that projects 3D images.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 40),
            author = "Gadget Guru",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[0]
        ),
        Article(
            id = 302,
            categoryId = 1,
            title = "Cybersecurity Trends to Watch in the Coming Year",
            content = "Experts weigh in on the biggest threats and solutions in digital security.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 41),
            author = "Security Today",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[0]
        ),
        Article(
            id = 303,
            categoryId = 1,
            title = "The Rise of Quantum Computing",
            content = "How quantum machines are set to revolutionize industries from medicine to finance.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 42),
            author = "Future Tech",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[0]
        ),

        // Sports (Category 2)
        Article(
            id = 304,
            categoryId = 2,
            title = "Underdog Tennis Star Wins Grand Slam",
            content = "An unseeded player shocked the world with a stunning final victory.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 43),
            author = "Sports Illustrated",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[1]
        ),
        Article(
            id = 305,
            categoryId = 2,
            title = "Formula 1 Announces New Sustainable Fuel Initiative",
            content = "The racing giant is moving towards a greener future.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 44),
            author = "AutoSport",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[1]
        ),
        Article(
            id = 306,
            categoryId = 2,
            title = "A Look Back at the Greatest Olympic Moments",
            content = "Reliving the most memorable triumphs and heartbreaks in Olympic history.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 45),
            author = "History Buff",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[1],
            isBookMarked = true
        ),

        // Politics (Category 3)
        Article(
            id = 307,
            categoryId = 3,
            title = "Global Leaders Meet for Climate Summit",
            content = "Nations pledge to take decisive action against climate change.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 46),
            author = "Global Affairs",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[2]
        ),
        Article(
            id = 308,
            categoryId = 3,
            title = "New Trade Agreement Signed Between Continents",
            content = "The historic deal is expected to boost economies worldwide.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 47),
            author = "Economic Times",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[2]
        ),
        Article(
            id = 309,
            categoryId = 3,
            title = "Youth Activism and Its Impact on Modern Politics",
            content = "Young voices are shaping policy like never before.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 48),
            author = "The Thinker",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[2],
            isBookMarked = true
        ),

        // Health (Category 4)
        Article(
            id = 310,
            categoryId = 4,
            title = "The Benefits of a Mediterranean Diet",
            content = "Research continues to show the long-term health advantages of this diet.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 49),
            author = "Wellness Weekly",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[3],
            isBookMarked = true
        ),
        Article(
            id = 311,
            categoryId = 4,
            title = "Mental Health: The Importance of Mindfulness",
            content = "Experts explain how meditation can reduce stress and improve focus.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 50),
            author = "Mind & Body",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[3]
        ),
        Article(
            id = 312,
            categoryId = 4,
            title = "Breakthrough in Alzheimer's Research",
            content = "A new drug shows promise in slowing the progression of the disease.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 51),
            author = "Medical Journal",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[3]
        ),

        // Entertainment (Category 5)
        Article(
            id = 313,
            categoryId = 5,
            title = "Legendary Director Announces Retirement",
            content = "After a 50-year career, the acclaimed filmmaker is stepping away.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 52),
            author = "Hollywood Reporter",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[4]
        ),
        Article(
            id = 314,
            categoryId = 5,
            title = "Music Festival Lineup for Summer Revealed",
            content = "Headliners include some of the biggest names in pop, rock, and electronic music.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 53),
            author = "Music Today",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[4],
            isBookMarked = true
        ),
        Article(
            id = 315,
            categoryId = 5,
            title = "The Resurgence of Vinyl Records",
            content = "Why music lovers are returning to the classic format.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 54),
            author = "Retro Cool",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[4]
        ),

        // Science (Category 6)
        Article(
            id = 316,
            categoryId = 6,
            title = "New Dinosaur Species Discovered in Patagonia",
            content = "Paleontologists have unearthed the remains of a previously unknown giant.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 55),
            author = "Discovery News",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[5],
            isBookMarked = true
        ),
        Article(
            id = 317,
            categoryId = 6,
            title = "Understanding Black Holes: The Latest Findings",
            content = "Telescopes provide new insights into the mysterious cosmic phenomena.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 56),
            author = "Cosmos Weekly",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[5]
        ),
        Article(
            id = 318,
            categoryId = 6,
            title = "The Science of Sleep: Why We Need It",
            content = "Researchers uncover more reasons why a good night's rest is crucial.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 57),
            author = "Health & Science",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[5]
        ),

        // Business (Category 7)
        Article(
            id = 319,
            categoryId = 7,
            title = "The Rise of the Four-Day Work Week",
            content = "Companies report increased productivity and employee satisfaction.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 58),
            author = "Workplace Future",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[6]
        ),
        Article(
            id = 320,
            categoryId = 7,
            title = "How to Invest in a Volatile Market",
            content = "Financial advisors offer tips for navigating economic uncertainty.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 59),
            author = "Investor's Guide",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[6]
        ),
        Article(
            id = 321,
            categoryId = 7,
            title = "Small Businesses Thriving with E-Commerce",
            content = "The digital marketplace has opened new doors for entrepreneurs.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 60),
            author = "Business Today",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[6]
        ),

        // World (Category 8)
        Article(
            id = 322,
            categoryId = 8,
            title = "Ancient City Uncovered in Amazon Rainforest",
            content =
                """<!DOCTYPE html><html lang="en"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1.0"><title>Ancient City Uncovered</title></head><body style="margin:0;padding:12px;font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,sans-serif;background-color:#f5f5f5;color:#333;line-height:1.5;font-size:15px"><div style="max-width:100%;margin:0 auto;background:white;padding:18px;border-radius:6px;box-shadow:0 1px 3px rgba(0,0,0,0.1)"><p style="margin:0 0 16px 0">Researchers have discovered a vast ancient city hidden deep within the Amazon rainforest using advanced satellite imaging technology.</p><div style="background:#e8f4e8;padding:14px;border-radius:6px;margin:16px 0"><p style="margin:0;font-style:italic;font-size:15px">"This discovery completely changes our understanding of pre-Columbian history in the Amazon."</p><p style="margin:6px 0 0 0;text-align:right;font-weight:bold;font-size:14px">- Dr. Elena Torres, Lead Archaeologist</p></div><h2 style="color:#2c5f2d;font-size:18px;margin-top:22px;margin-bottom:10px">Key Findings</h2><ul style="padding-left:20px;margin:12px 0"><li style="margin-bottom:8px">Advanced road networks connecting various city sections</li><li style="margin-bottom:8px">Sophisticated water management systems</li><li style="margin-bottom:8px">Agricultural terraces showing advanced farming</li><li style="margin-bottom:8px">Residential areas for thousands of inhabitants</li></ul><h2 style="color:#2c5f2d;font-size:18px;margin-top:22px;margin-bottom:10px">Discovery Timeline</h2><p style="margin:8px 0"><strong>2018:</strong> Initial satellite surveys identify unusual patterns</p><p style="margin:8px 0"><strong>2020:</strong> LIDAR technology confirms artificial structures</p><p style="margin:8px 0"><strong>2023:</strong> Ground verification begins</p><h2 style="color:#2c5f2d;font-size:18px;margin-top:22px;margin-bottom:10px">Significance</h2><p style="margin:0 0 20px 0">This discovery challenges the notion that the Amazon was sparsely populated by nomadic tribes. Instead, it reveals complex societies that shaped their environment in sustainable ways.</p><p style="border-top:1px solid #ddd;padding-top:14px;margin-top:22px;font-size:13px;color:#777">© 2023 Archaeological Discovery Journal. This content is for educational purposes.</p></div></body></html>""",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 61),
            author = "Archaeology Now",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[7]
        ),
        Article(
            id = 323,
            categoryId = 8,
            title = "Cultural Festival Celebrates Global Diversity",
            content = "Artists from over 50 countries gather for a week of performances.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 62),
            author = "Culture Hub",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[7]
        ),
        Article(
            id = 324,
            categoryId = 8,
            title = "Efforts to Combat Deforestation Show Progress",
            content = "New data indicates a decline in forest loss in key regions.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 63),
            author = "Planet Earth",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[7]
        ),
        Article(
            id = 325,
            categoryId = 8,
            title = "New Canal to Reshape Global Shipping Routes",
            content = "Construction begins on a major new waterway.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 80),
            author = "World News",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[7]
        ),
        Article(
            id = 326,
            categoryId = 8,
            title = "Volcanic Eruption Creates New Island",
            content = "A submarine volcano has breached the surface, forming new land.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 81),
            author = "Geo Today",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[7]
        ),

        // Lifestyle (Category 9)
        Article(
            id = 327,
            categoryId = 9,
            title = "The Art of Urban Gardening",
            content = "How to grow your own food in a small city space.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 64),
            author = "Green Living",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[8]
        ),
        Article(
            id = 328,
            categoryId = 9,
            title = "Digital Detox: Reconnecting with the Real World",
            content = "Tips for reducing screen time and improving well-being.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 65),
            author = "Modern Life",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[8],
            isBookMarked = true
        ),
        Article(
            id = 329,
            categoryId = 9,
            title = "DIY Home Renovation Trends",
            content = "Popular projects that can add value and style to your home.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 66),
            author = "Home & Garden",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[8]
        ),
        Article(
            id = 330,
            categoryId = 9,
            title = "The Joy of Cooking: A Beginner's Guide",
            content = "Simple recipes to get you started in the kitchen.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 82),
            author = "Foodie Fun",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[8]
        ),
        Article(
            id = 331,
            categoryId = 9,
            title = "Sustainable Fashion: A Guide to Ethical Shopping",
            content = "How to build a wardrobe that's kind to the planet.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 83),
            author = "Eco Style",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[8]
        ),

        // Travel (Category 10)
        Article(
            id = 332,
            categoryId = 10,
            title = "Solo Travel: Is It Right for You?",
            content = "Exploring the pros and cons of traveling alone.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 67),
            author = "Wanderlust",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[9]
        ),
        Article(
            id = 333,
            categoryId = 10,
            title = "Exploring the Ancient Silk Road",
            content = "A journey through the historic trade route connecting East and West.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 68),
            author = "Adventure Seeker",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[9]
        ),
        Article(
            id = 334,
            categoryId = 10,
            title = "Budget-Friendly European Cities to Visit",
            content = "Discover charming destinations that won't break the bank.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 69),
            author = "Travel Smart",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[9]
        ),
        Article(
            id = 335,
            categoryId = 10,
            title = "The World's Most Spectacular Train Journeys",
            content = "Experience breathtaking scenery from the comfort of a train.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 84),
            author = "The Voyager",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[9]
        ),
        Article(
            id = 336,
            categoryId = 10,
            title = "Island Hopping in the Philippines",
            content = "A guide to the best beaches and hidden lagoons.",
            imageUrl = ImageUrlHelper.getPicsumUrl(640, 480, 85),
            author = "Beach Bum",
            publishedAt = randomPublishedAt(180),
            category = CategoryData.categories[9]
        )
    )
    val allArticles = breakingArticles + featuredArticles + latestArticles + otherArticles

    val articlesByCategory: Map<Int, List<Article>> = allArticles.groupBy { it.categoryId }
}