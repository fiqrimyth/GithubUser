package id.fiqridhan.githubuser.presentation.navigation

sealed class Screens(val route: String) {
    data object Splash : Screens("splash_screen")
    data object Home : Screens("home_screen")
    data object Profile : Screens("{user}/profile_screen")
    data object List : Screens("{user}/{title}/list_screen")

    fun createRoute(user:String) = "$user/profile_screen"
    fun createRouteFollowersFollowings(user:String, title: String) = "$user/$title/list_screen"
}