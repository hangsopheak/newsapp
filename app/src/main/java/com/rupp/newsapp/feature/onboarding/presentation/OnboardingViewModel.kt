package com.rupp.newsapp.feature.onboarding.presentation

import androidx.lifecycle.ViewModel
import com.rupp.newsapp.feature.onboarding.data.OnboardingDataSource
import com.rupp.newsapp.feature.onboarding.domain.OnboardingSection

class OnboardingViewModel : ViewModel() {
    private val dataSource = OnboardingDataSource()
    val sections: List<OnboardingSection> = dataSource.getMainOnboardingSections()
}