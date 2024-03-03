@file:OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class,
    ExperimentalFoundationApi::class
)

package com.credeative.budgetbuddy.ui.home

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.credeative.budgetbuddy.data.datamodel.Needs
import com.credeative.budgetbuddy.ui.PieChart
import com.credeative.budgetbuddy.ui.theme.PrimaryNeeds
import com.credeative.budgetbuddy.ui.theme.SecondaryNeeds
import com.credeative.budgetbuddy.ui.theme.Shape
import com.credeative.budgetbuddy.ui.theme.TertiaryNeeds
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FundOptionTab(
    
){
    val pages = listOf<String>("Transaksi","Alokasi Kebutuhan")
    val pagerState = rememberPagerState {
        pages.size
    }

    val indicator = @Composable {
        tabPosition : List<TabPosition> -> CustomIndicator(tabPositions = tabPosition, pagerState = pagerState)
    }
    ScrollableTabRow(
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .height(50.dp)
            .wrapContentSize(Alignment.Center),
        selectedTabIndex = pagerState.currentPage,
        indicator = indicator) {

        pages.forEachIndexed { index, label ->

            Tab(
                modifier = Modifier.zIndex(6f),
                text = {
                    Text(text = label, color = if (pagerState.currentPage == index)Color.White else Color.Gray)
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    /*TODO*/

                }
            )
            //
        }
    }
    HorizontalPager(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        state = pagerState) {
            page ->  when(page){
                0 -> TransactionTab()
                1 -> AllocationTab()
            }

    }
    
}

@Composable
private fun TransactionTab(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        androidx.compose.material3.Text(text = "Periode")

        androidx.compose.material3.Text(text = "25 Jan 2024 - 25 Feb 2024")

        FundDialog()
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(25.dp))

        Row (modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
            PieChart(modifier = Modifier.height(200.dp).width(100.dp),
                input = listOf(
                    Needs(color = PrimaryNeeds,"Primary",15, false),
                    Needs(color = SecondaryNeeds,"Secondary",15,false),
                    Needs(color = TertiaryNeeds,"Tertiary",15,false)
                ),
                radius = 240f)


            Card(
                modifier = Modifier
                    .wrapContentSize(align = Alignment.Center)
                    .padding(10.dp),
                shape = RoundedCornerShape(4.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Gray)

            ){
                Column(modifier = Modifier.padding(10.dp),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(15.dp)) {
                    FundFraction()
                    FundFraction()
                    Text(modifier = Modifier.padding(vertical = 5.dp),text = "Lihat Lebih Banyak")
                }
            }

        }



    }
}
@Composable
private fun AllocationTab(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        androidx.compose.material3.Text(text = "Periode")

        androidx.compose.material3.Text(text = "25 Jan 2024 - 25 Feb 2024")

        FundDialog()
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(25.dp))

        Row (modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
            PieChart(modifier = Modifier.height(200.dp).width(100.dp),
                input = listOf(
                    Needs(color = PrimaryNeeds,"Primary",15, false),
                    Needs(color = SecondaryNeeds,"Secondary",15,false),
                    Needs(color = TertiaryNeeds,"Tertiary",15,false)
                ),
                radius = 240f)


            Card(
                modifier = Modifier
                    .wrapContentSize(align = Alignment.Center)
                    .padding(10.dp),
                shape = RoundedCornerShape(4.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Gray)

            ){
                Column(modifier = Modifier.padding(10.dp),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(15.dp)) {
                    FundFraction()
                    FundFraction()
                    Text(modifier = Modifier.padding(vertical = 5.dp),text = "Lihat Lebih Banyak")
                }
            }

        }



    }
}

@Composable
private fun FundFraction(){
    Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)){
        Box(
            modifier = Modifier
                .size(25.dp)
                .background(shape = RoundedCornerShape(2.dp), color = Color.Red),

            )
        Column() {
            Text(text = "Pemasukan")

            Text(text = "Rp 2.300.000,00,-")
        }
    }
}



@Composable
private fun CustomIndicator(tabPositions: List<TabPosition>,pagerState: PagerState){
    val transition = updateTransition(targetState = pagerState.currentPage, label = "")

    val indicatorStart by transition.animateDp(
        transitionSpec = {
            if (initialState<targetState){
                spring(dampingRatio = 1f, stiffness = 50f)
            }else{
                spring(dampingRatio = 1f, stiffness = 1000f)
            }
        }, label = ""
    ){
        tabPositions[it].left
    }

    val indicatorEnd by transition.animateDp(
        transitionSpec = {
            if (initialState<targetState){
                spring(dampingRatio = 1f, stiffness = 1000f)
            }else{
                spring(dampingRatio = 1f, stiffness = 50f)
            }
        }, label = "") {
        tabPositions[it].right
    }
    Box(
        Modifier
            .offset(x = indicatorStart)
            .wrapContentSize(align = Alignment.BottomStart)
            .width(indicatorEnd - indicatorStart)
            .padding(2.dp)
            .fillMaxSize()
            .background(color = Color(0xFF006CCF), RoundedCornerShape(10))
            .zIndex(1f)
    )

}

@Composable
fun FundDialog(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = Shape.extraSmall,
        colors = CardDefaults.cardColors(containerColor = Color.Gray),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)) {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 5.dp), horizontalArrangement = Arrangement.Center){
//            Icon(painter = , contentDescription = )
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                androidx.compose.material3.Text(text = "Perhatian, Overspending!")
                androidx.compose.material3.Text(text = "Pengeluaran Keinginan kamu lebih banyak ketimbang kebutuhan pokok kamu")
            }
        }
    }
}




@Composable
@Preview
fun MultiSelectorPreview(){
    FundOptionTab()
}