package com.credeative.budgetbuddy.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.credeative.budgetbuddy.R
import com.credeative.budgetbuddy.data.ui.BottomNavigationItem
import com.credeative.budgetbuddy.ui.account.AccountUI
import com.credeative.budgetbuddy.ui.home.HomeUi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeNavigationBar(modifier: Modifier=Modifier){
    val navController = rememberNavController()
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val items = listOf<BottomNavigationItem>(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = painterResource(id = R.drawable.nav_home),
            unselectedIcon = painterResource(id = R.drawable.nav_home),
            hasNews = false,
            screen = HomeScreenRoute.HOME),
        BottomNavigationItem(
            title = "Wallet",
            selectedIcon = painterResource(id = R.drawable.nav_wallet),
            unselectedIcon = painterResource(id = R.drawable.nav_wallet),
            hasNews = false,
            screen = HomeScreenRoute.WALLET),
        BottomNavigationItem(
            title = "User",
            selectedIcon = painterResource(id = R.drawable.nav_wallet),
            unselectedIcon = painterResource(id = R.drawable.nav_wallet),
            hasNews = false,
            screen = HomeScreenRoute.ACCOUNT)
    )
    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEachIndexed(action = {
                    index, bottomNavigationItem ->
                    NavigationBarItem(
                        selected = /*selectedItemIndex==index*/currentDestination?.hierarchy?.any{
                                   it.route==bottomNavigationItem.screen.name
                        }==true,
                        onClick = { selectedItemIndex=index
                                  navController.navigate(route = items[index].screen.name){
                                      popUpTo(navController.graph.findStartDestination().id){
                                          saveState = true
                                      }
                                      launchSingleTop = true
                                      restoreState = true
                                  }},
                        label = {
                                Text(text = bottomNavigationItem.title)
                        },
                        alwaysShowLabel = false,
                        icon = { BadgedBox(badge = {
                            if (bottomNavigationItem.hasNews){
                                Badge()
                            }
                        }) {
                            Icon(
                                painter = if (index==selectedItemIndex){bottomNavigationItem.selectedIcon}else{bottomNavigationItem.unselectedIcon},
                                contentDescription = bottomNavigationItem.title)
                            }
                        })
                })
                
            }
        }) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination =  items[selectedItemIndex].screen.name,
            modifier = Modifier.padding(paddingValues)
        ){
            composable(route = HomeScreenRoute.HOME.name){
                HomeUi()
            }
            composable(route = HomeScreenRoute.WALLET.name){

            }
            composable(route = HomeScreenRoute.ACCOUNT.name){
                AccountUI()
            }
        }

    }
}
enum class HomeScreenRoute(){
    HOME,
    WALLET,
    ACCOUNT
}
@Composable
fun HomeNavigationBarPreview(){
    HomeNavigationBar()
}