package id.fiqridhan.githubuser.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import id.fiqridhan.githubuser.common.Constants
import id.fiqridhan.githubuser.presentation.followerswings.FollowersFollowingsScreen
import id.fiqridhan.githubuser.presentation.home.HomeScreen
import id.fiqridhan.githubuser.presentation.home.HomeViewModel
import id.fiqridhan.githubuser.presentation.profile.ProfileScreen
import id.fiqridhan.githubuser.presentation.splash.AnimatedSplashScreen

@Composable
fun SpeerGitNavGraph(navController: NavHostController) {
    val homeViewModel = hiltViewModel<HomeViewModel>()
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route,
    ) {
        composable(route = Screens.Splash.route) {
            AnimatedSplashScreen(navController = navController)
        }

        composable(
            route = Screens.Home.route
        ) {
            HomeScreen(
                navController = navController,
                homeViewModel = homeViewModel
            )
        }

        composable(
            route = Screens.Profile.route
        ) {navBackStackEntry ->
        val userArg = navBackStackEntry.arguments?.getString(Constants.PARAM_USER) ?: ""
            val user = remember{
                homeViewModel.getGithubUser(userArg)
                homeViewModel.user
            }.collectAsStateWithLifecycle()
            user.value.data?.let {
                ProfileScreen(
                    navController = navController,
                    githubUser = it,
                )
            }
        }
        composable(
            route = Screens.List.route,
            arguments = listOf(
                navArgument(Constants.PARAM_USER) { type = NavType.StringType },
                navArgument(Constants.PARAM_TITLE) { type = NavType.StringType },
            )
        ) {navBackStackEntry ->
            val username = navBackStackEntry.arguments?.getString(Constants.PARAM_USER)
            val title = navBackStackEntry.arguments?.getString(Constants.PARAM_TITLE)
            FollowersFollowingsScreen(
                username = username ?: "",
                title = title ?: "",
                navController = navController)
        }
    }
}