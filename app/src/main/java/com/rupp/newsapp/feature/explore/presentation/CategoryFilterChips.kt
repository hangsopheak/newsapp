package com.rupp.newsapp.feature.explore.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rupp.newsapp.core.domain.model.Category

@Composable
fun CategoryFilterChips(
    categories: List<Category>,
    selectedCategoryId: Int?,
    onCategorySelected: (Category) -> Unit,
    modifier: Modifier = Modifier
){
    LazyRow(modifier = modifier.padding(horizontal = 8.dp, vertical = 8.dp))
    {
        items(categories) { category ->
            val isSelected = category.id == selectedCategoryId
            FilterChip(
                selected = isSelected,
                onClick = { onCategorySelected(category) },
                label = { Text(category.name, style = MaterialTheme.typography.bodyMedium) },
                modifier = Modifier.padding(end = 8.dp),
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = MaterialTheme.colorScheme.primary,
                    selectedLabelColor = MaterialTheme.colorScheme.onPrimary,
                )
            )
        }
    }
}