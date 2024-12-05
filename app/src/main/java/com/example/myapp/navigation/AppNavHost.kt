package com.example.myapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android2.ui.theme.screens.client.ViewClients
import com.example.myapp.ui.theme.screen.SplashScreen
import com.example.myapp.ui.theme.screen.client.AddClientScreen
import com.example.myapp.ui.theme.screen.client.UpdateClientScreen
import com.example.myapp.ui.theme.screen.dashboard.DashBoard
import com.example.myapp.ui.theme.screen.login.LoginScreen
import com.example.myapp.ui.theme.screen.signup.SignupScreen


@Composable
fun AppNavHost(navController: NavHostController = rememberNavController(),
               startDestination: String = ROUTE_SPLASH){
    NavHost(navController = navController,
        startDestination = startDestination ){
        composable(ROUTE_SPLASH) { SplashScreen {
            navController.navigate(ROUTE_REGISTER){
                popUpTo(ROUTE_SPLASH){inclusive = true}
            }
        } }
        composable(ROUTE_REGISTER){SignupScreen(navController) }
        composable(ROUTE_LOGIN){ LoginScreen(navController) }
        composable(ROUTE_HOME){ DashBoard(navController) }
        composable(ROUTE_ADD_CLIENT){ AddClientScreen(navController) }
        composable(ROUTE_VIEW_CLIENT){ ViewClients(navController) }
        composable("$ROUTE_UPDATE_CLIENT/{id}"){
            passedData -> UpdateClientScreen(
            navController, passedData.arguments?.getString("id")!! )
        }
    }
}