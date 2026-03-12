package com.jungiantarot.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jungiantarot.presentation.home.HomeScreen
import com.jungiantarot.presentation.tarot.TarotScreen
import com.jungiantarot.presentation.astrology.BirthChartScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jungiantarot.presentation.tarot.TarotViewModel

sealed class Screen(val route: String, val title: String) {
    object Home : Screen("home", "Hoy")
    object Tarot : Screen("tarot", "Tarot")
    object Astrology : Screen("astrology", "Astros")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navController = navController)
            }
            composable(Screen.Tarot.route) {
                val viewModel: TarotViewModel = viewModel()
                TarotScreen(viewModel = viewModel)
            }
            composable(Screen.Astrology.route) {
                BirthChartScreen()
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        Screen.Home,
        Screen.Tarot,
        Screen.Astrology
    )
    
    NavigationBar(
        containerColor = Color(0xFF101423), // Color oscuro más profundo
        contentColor = Color(0xFFD4AF37)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { screen ->
            NavigationBarItem(
                icon = { Text(text = screen.title.take(1)) }, // Placeholder icon
                label = { Text(text = screen.title) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF101423),
                    selectedTextColor = Color(0xFFD4AF37),
                    indicatorColor = Color(0xFFD4AF37),
                    unselectedIconColor = Color.LightGray,
                    unselectedTextColor = Color.LightGray
                )
            )
        }
    }
}