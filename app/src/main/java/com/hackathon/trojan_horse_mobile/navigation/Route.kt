package com.hackathon.trojan_horse_mobile.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.hackathon.trojan_horse_mobile.R
import com.hackathon.trojan_horse_mobile.screens.ActivitiesScreen
import com.hackathon.trojan_horse_mobile.screens.HomeScreen
import com.hackathon.trojan_horse_mobile.screens.ProfileScreen
import com.hackathon.trojan_horse_mobile.screens.SignInScreen
import com.hackathon.trojan_horse_mobile.screens.SignUpScreen
import com.hackathon.trojan_horse_mobile.sharedprefs.AuthManager
import com.hackathon.trojan_horse_mobile.viewmodel.SignInViewModel
import com.hackathon.trojan_horse_mobile.viewmodel.SignUpViewModel

sealed class Screen (val route: String) {
    object SignUpScreen: Screen("signup")
    object SignInScreen: Screen("signin")

    object HomeScreen: Screen("home")
    object ActivitiesScreen : Screen("activities")
    object ProfileScreen: Screen("profile")

    object AuthRoute: Screen("auth")
    object AppRoute: Screen("app")

}

sealed class BottomNavItem(
    val route: String,
    val selectedIcon: Int,
) {
    object HomeItems: BottomNavItem("home", R.drawable.house_solid)
    object ActivityItems: BottomNavItem("activities", R.drawable.note_sticky_solid)
    object Profile: BottomNavItem("profile", R.drawable.user_solid)

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavController(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.AuthRoute.route
    ) {
         //application navigation route before logging in
        navigation(startDestination = Screen.SignInScreen.route, route = Screen.AuthRoute.route){
            composable(Screen.SignUpScreen.route) {
                SignUpScreen(navController, SignUpViewModel(navController))
            }
            composable(Screen.SignInScreen.route) {
                SignInScreen(navController, SignInViewModel(navController))
            }
        }
        // application navigation route after successful log in
        navigation(startDestination = Screen.HomeScreen.route, route = Screen.AppRoute.route){
            composable(Screen.HomeScreen.route) {
                HomeScreen(navController)
            }
            composable(Screen.ActivitiesScreen.route) {
                ActivitiesScreen(navController)
            }
            composable(Screen.ProfileScreen.route){
                ProfileScreen(navController)
            }
        }
    }
}

//@Composable
//fun determineStartDestination(): String {
//    return if (AuthManager.isLoggedIn()) {
//        Screen.AppRoute.route
//    } else {
//        Screen.AuthRoute.route
//    }
//}