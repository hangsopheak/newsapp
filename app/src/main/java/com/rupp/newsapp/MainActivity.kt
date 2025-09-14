
package com.rupp.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.rupp.newsapp.feature.main.presentation.MainScreen
import com.rupp.newsapp.feature.onboarding.presentation.OnboardingScreen
import com.rupp.newsapp.feature.onboarding.util.OnboardingUtils
import com.rupp.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val onboardingUtils by lazy { OnboardingUtils(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            var isOnboardingCompleted by remember {
                mutableStateOf(onboardingUtils.isOnboardingCompleted())
            }

            NewsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (isOnboardingCompleted) {
                        MainScreen()
                    } else {
                        OnboardingScreen(
                            onFinished = {
                                onboardingUtils.setOnboardingCompleted()
                                isOnboardingCompleted = true
                            }
                        )
                    }
                }
            }
        }
    }
}

