package com.credeative.budgetbuddy.data.ui

import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title:String,
    val selectedIcon : Painter,
    val unselectedIcon: Painter,
    val hasNews : Boolean,
    val notificationCount : Int? = null
)