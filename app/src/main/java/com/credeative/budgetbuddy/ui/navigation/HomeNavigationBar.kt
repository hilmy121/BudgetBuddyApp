package com.credeative.budgetbuddy.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.credeative.budgetbuddy.R
import com.credeative.budgetbuddy.data.ui.BottomNavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeNavigationBar(modifier: Modifier=Modifier){
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val items = listOf<BottomNavigationItem>(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = painterResource(id = R.drawable.bg_wallet_card),
            unselectedIcon = painterResource(id = R.drawable.bg_wallet_card),
            hasNews = false),
        BottomNavigationItem(
            title = "Wallet",
            selectedIcon = painterResource(id = R.drawable.bg_wallet_card),
            unselectedIcon = painterResource(id = R.drawable.bg_wallet_card),
            hasNews = false),
        BottomNavigationItem(
            title = "User",
            selectedIcon = painterResource(id = R.drawable.bg_wallet_card),
            unselectedIcon = painterResource(id = R.drawable.bg_wallet_card),
            hasNews = false)
    )
    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed(action = {
                    index, bottomNavigationItem ->
                    NavigationBarItem(
                        selected = selectedItemIndex==index,
                        onClick = { selectedItemIndex=index},
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
        }) {

    }
}

@Composable
fun HomeNavigationBarPreview(){
    HomeNavigationBar()
}