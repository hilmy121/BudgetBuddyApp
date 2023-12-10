package com.credeative.budgetbuddy.ui.login

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.credeative.budgetbuddy.R
import com.credeative.budgetbuddy.data.datamodel.Page
import com.credeative.budgetbuddy.ui.theme.Typography
import com.credeative.budgetbuddy.ui.theme.theme_light_secondary_container
import com.credeative.budgetbuddy.ui.theme.theme_light_secondary_container_border
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

private const val MULTIPLIER_SELECTED_PAGE = 4
private val baseWidth = 4.dp
private val spacing = 10.dp
private val height = 8.dp
@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
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
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        androidx.compose.foundation.pager.HorizontalPager(modifier= Modifier
            .fillMaxWidth()
            .height(400.dp),state = pagerState){
            index -> PageUI(modifier = Modifier
            .fillMaxWidth()
            , page = items[index])
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