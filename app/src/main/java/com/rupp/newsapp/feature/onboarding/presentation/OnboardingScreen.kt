package com.rupp.newsapp.feature.onboarding.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rupp.newsapp.feature.onboarding.data.OnboardingDataSource
import com.rupp.newsapp.ui.theme.NewsAppTheme
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(onFinished : () -> Unit){
    val pages = OnboardingDataSource().getMainOnboardingSections()
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { pages.size })

    val buttonState = remember {
        derivedStateOf {
            when (pagerState.currentPage) {
                0 -> listOf("", "Next")
                1 -> listOf("Back", "Next")
                2 -> listOf("Back", "Start")
                else -> listOf("", "")
            }
        }
    }

    val scope = rememberCoroutineScope()


    NewsAppTheme {
        Scaffold(
            content = {
                Column(Modifier.padding(it)) {
                    HorizontalPager(state = pagerState) { page ->
                        OnboardingSection(pages[page])
                    }
                }
            },
            bottomBar = {
                Row (modifier = Modifier.padding(10.dp, 10.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.CenterStart){
                        if (buttonState.value[0].isNotEmpty()) {
                            OnboardingButton(
                                text = buttonState.value[0],
                                backgroundColor = Color.Transparent,
                                textColor = Color.Gray
                            ) {
                                scope.launch {
                                    if (pagerState.currentPage > 0) {
                                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                                    }
                                }
                            }
                        }
                    }
                    Indicator(pageSize = pages.size, currentPage = pagerState.currentPage)
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.CenterEnd){
                       OnboardingButton(text = buttonState.value[1],
                           backgroundColor = MaterialTheme.colorScheme.primary,
                           textColor = MaterialTheme.colorScheme.onPrimary
                           ) {
                           scope.launch {
                               if (pagerState.currentPage < pages.size - 1) {
                                   pagerState.animateScrollToPage(pagerState.currentPage + 1)
                               } else {
                                   onFinished()
                               }
                           }
                       }
                    }
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview(){
    OnboardingScreen {

    }
}