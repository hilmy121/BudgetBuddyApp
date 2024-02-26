package com.credeative.budgetbuddy.ui.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)


val PrimaryColor = Color(0xFF013118)
val PrimaryColorContainer = Color(0xFF03180D)
val PrimaryColorBg = Color(0x66FFEBD4)

val BlackBorderStrokeColor = Color(0x66000000)
val GreyBorderStrokeColor = Color(0xFFBFBFBF)

//add on

val unchecked_checkbox = Color(0xFF0000AE)
val PrimaryNeeds = Color(0xFF0000AE)
val SecondaryNeeds = Color(0xFF0064FA)
val TertiaryNeeds = Color(0xFF00D1FF)
val SavingsNeeds = Color(0xFF848484)
//Light
//primary
val theme_light_onPrimary = Color(0xFFFFFFFF)
val theme_light_primary_container = Color(0xFF003BAE)
val theme_light_primary_container_border = Color(0xFFA3C8FF)

//secondary
val theme_light_onSecondary = Color(0xFF797979)
val theme_light_secondary_container = Color(0xFF78A6FF)
val theme_light_secondary_container_border = Color(0xFFA3C8FF)

//tertiary
val theme_light_onTertiary = Color(0xFF0065FF)
val theme_light_tertiary_container = Color(0xFF0050C9)


//Dark
//primary

val linearGradientCardAmount = Brush.linearGradient(
        colors = listOf(Color(0xff0A3A21), Color(0xff003017)),
        start = Offset(0f, Float.POSITIVE_INFINITY),
        end = Offset(Float.POSITIVE_INFINITY, 0f)
)
val SecondaryCardColor = Color(0xFF2B6747)
val TertiaryBorderColor = Color(0xFFCD5F1D)