1. Screen Purpose

Let users discover news articles by category.
Always show the latest article of selected category in a big card, followed by the rest in a list.

2. UI Section Breakdown

**a) Top Bar**

Displays: Title “Explore” + Search icon.
Inputs: Static title.
Events: onSearchClick.

**b) Category Filter Chips**

Displays: Row of categories (Travel, Technology, Business, …).
Inputs: List of Category, currently selected categoryId.
Events: onCategorySelected(id).

**c) Hero Article Card**

Displays: Latest article (big image, title, author, date).
Inputs: One Article.
Events: onArticleClick(articleId).

**d) Article List (remaining)**

Displays: Vertical list of articles (small thumbnail + title + author).
Inputs: List of Article.
Events: onArticleClick(articleId).

**e) Loading / Error / Empty**

Displays: Placeholder loader, error message with retry, or empty message.
Inputs: Boolean flags or error text.
Events: onRetry.

**3. Data / Model Planning**
   Models needed

Category: id, name, imageUrl.
Article: id, categoryId, title, content, imageUrl, author, publishedAt, flags.
Sources

From repository (API or mock data).

Hero article = latest article in selected category (sorted by publishedAt).
Other articles = remaining list in same category.
Transformations

On category change → filter articles → sort descending by date → pick first as hero, rest as list.

**4. Events & Interactions**

User selects category chip → update state → show that category’s latest article + list.
User taps hero card or list item → navigate to detail screen.
User taps search icon → open search screen.

User taps retry (error) → reload categories + articles.

**5. States**

Loading: Show shimmer/loader for hero + list.
Error: Show message + Retry button.
Empty: If no articles exist for a category, show “No articles found”.
Content: Hero article + list of others.