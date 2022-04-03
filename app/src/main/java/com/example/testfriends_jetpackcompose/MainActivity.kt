package com.example.testfriends_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.testfriends_jetpackcompose.navigation.SetupNavGraph
import com.example.testfriends_jetpackcompose.ui.theme.TestFriends_JetPackComposeTheme
import com.example.testfriends_jetpackcompose.viewmodel.CreateTestViewModel
import com.example.testfriends_jetpackcompose.viewmodel.SplashViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@ExperimentalAnimationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @Inject
    lateinit var splashViewModel: SplashViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition {
            !splashViewModel.isLoading.value
        }

        setContent {
            TestFriends_JetPackComposeTheme {
                val screen by splashViewModel.startDestination
                val navController = rememberNavController()
                val viewModel: CreateTestViewModel = CreateTestViewModel(LocalContext.current)
                SetupNavGraph(navController = navController, startDestination = screen,viewModel)
            }
        }
    }
}
