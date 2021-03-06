package com.example.testfriends_jetpackcompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testfriends_jetpackcompose.screen.*
import com.example.testfriends_jetpackcompose.viewmodel.CreateTestViewModel
import com.google.accompanist.pager.ExperimentalPagerApi


@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String,
    viewModel: CreateTestViewModel,

) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }

        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController, viewModel)
        }
        composable(route = Screen.Create.route) {
            TestMain(navHostController = navController, viewModel = viewModel)
        }
        composable(route = Screen.ShareTest.route) {
            ShareTest(viewModel=viewModel)
        }

        composable(route = Screen.FinalScreen.route) {
            FinalScreen(navHostController = navController, viewModel = viewModel)
        }

    }
}