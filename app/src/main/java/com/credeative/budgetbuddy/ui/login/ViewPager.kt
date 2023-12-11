package com.credeative.budgetbuddy.ui.login


import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.credeative.budgetbuddy.R
import com.credeative.budgetbuddy.data.datamodel.Page
import com.credeative.budgetbuddy.ui.theme.PrimaryColorContainer
import com.credeative.budgetbuddy.ui.theme.Shape
import com.credeative.budgetbuddy.ui.theme.Typography
import com.credeative.budgetbuddy.ui.theme.theme_light_tertiary_container
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlin.math.abs

private const val MULTIPLIER_SELECTED_PAGE = 4
private val baseWidth = 4.dp
private val spacing = 15.dp
private val height = 8.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ViewpagerApp(modifier : Modifier = Modifier){
    val itemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val items = ArrayList<Page>(listOf(
        Page(
            header = R.string.header1,
            subHeader = R.string.subheader1
            , img = null ),
        Page(
            header = R.string.header2,
            subHeader = R.string.subheader2
            , img = null ),
        Page(
            header = R.string.header3,
            subHeader = R.string.subheader3
            , img = null )
    ))
    val pagerState = rememberPagerState(
        pageCount = {
            items.size
        }, initialPage = 0
    )

    val isDraggedState = pagerState.interactionSource.collectIsDraggedAsState()


    LaunchedEffect(key1 = isDraggedState, block = {
        snapshotFlow { isDraggedState.value }.collectLatest {
            value -> if (!value){
                while (true){
                    delay(2000)
                    try {
                        pagerState.animateScrollToPage(
                            page =  if (pagerState.currentPage<pagerState.pageCount-1)pagerState.currentPage+1 else 0,
                            animationSpec = tween(1000)
                        )
                    }catch (ignore:CancellationException){

                    }
                }
        }
        }
//        coroutineScope {
//            launch (){
//                while (true){
//                    yield()
//
//                    Log.i("Current Page : ",pagerState.currentPage.toString())
//                    delay(2000)
//
//                    pagerState.animateScrollToPage(
//                        page =  if (pagerState.currentPage<pagerState.pageCount-1)pagerState.currentPage+1 else 0
//                    )
////                    pagerState.animateScrollToPage(
////                        page = if (pagerState.currentPage<pagerState.pageCount-1)pagerState.currentPage+1 else 0,
////                        animationSpec = tween(1000), skipPages = false
////                    )
//
//                }
//
//            }
//
//        }
    })
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(20.dp)) {
        HorizontalPager(modifier= Modifier
            .fillMaxWidth()
            .height(400.dp),state = pagerState){

            index -> PageUI(modifier = Modifier
            .fillMaxWidth()
            , page = items[index])
        }
        CustomViewPagerIndicator(modifier = Modifier.fillMaxWidth(),pagerState = pagerState)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomViewPagerIndicator(modifier: Modifier = Modifier,
    pagerState: PagerState){
    Row (){
        val offsetIntPart = pagerState.currentPageOffsetFraction.toInt()
        val offsetFractionalPart = pagerState.currentPageOffsetFraction - offsetIntPart
        val currentPage = pagerState.currentPage + offsetIntPart
        val targetPage = if (pagerState.currentPageOffsetFraction < 0) currentPage - 1 else currentPage + 1
        val currentPageWidth = baseWidth * (1 + (1 - abs(offsetFractionalPart)) * MULTIPLIER_SELECTED_PAGE)
        val targetPageWidth = baseWidth * (1 + abs(offsetFractionalPart) * MULTIPLIER_SELECTED_PAGE)
        repeat(pagerState.pageCount){
            index -> val width = when(index){
                pagerState.currentPage -> currentPageWidth
                pagerState.targetPage -> targetPageWidth
                else -> baseWidth
            }
            Card(modifier = Modifier
                .width(width = width)
                .height(height = height), shape = Shape.extraSmall, colors = CardDefaults.cardColors(containerColor = theme_light_tertiary_container)) {

            }
            if (index != pagerState.pageCount-1){
                Spacer(modifier = Modifier.width(width = spacing))
            }
        }
    }

}
@Composable
fun PageUI(page:Page,modifier:Modifier = Modifier){
    Box(modifier = modifier){
        Column(
            Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .padding(horizontal = 10.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(60.dp))
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(text = stringResource(id = page.header), style = Typography.displaySmall)
                Text(text = stringResource(id = page.subHeader), style = Typography.bodyMedium)
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(60.dp))
            Image(painter = painterResource(id = R.drawable.ic_hero_budget_buddy_20), contentDescription = null)



        }
    }
}

@Composable
@Preview(showBackground = true)
fun PageUIPreview(){
    PageUI(Page(
        header = R.string.header1,
        subHeader = R.string.subheader1
        , img = null ))
}