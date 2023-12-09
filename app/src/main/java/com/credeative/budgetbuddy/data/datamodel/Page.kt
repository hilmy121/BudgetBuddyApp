package com.credeative.budgetbuddy.data.datamodel

data class Page (
    val header:Int,
    val subHeader:Int,
    val onDisplay:Boolean = false,
    val img:Int?
)