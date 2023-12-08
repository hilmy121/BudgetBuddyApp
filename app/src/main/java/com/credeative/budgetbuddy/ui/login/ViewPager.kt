package com.credeative.budgetbuddy.ui.login

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.credeative.budgetbuddy.R
import com.credeative.budgetbuddy.data.datamodel.Page
import com.credeative.budgetbuddy.ui.theme.Typography
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun ViewpagerApp(modifier : Modifier = Modifier){
    val itemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val items = listOf<Page>(
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
    )
    val pagerState = rememberPagerState(
        initialPage = 0, pageCount = items.size
    )

    LaunchedEffect(key1 = Unit, block = {
        coroutineScope {
            launch (){
                while (true){
                    yield()
                    delay(2000)
                    pagerState.animateScrollToPage(
                        page = (pagerState.currentPage + 1)%(pagerState.pageCount),
                        animationSpec = tween(1000)
                    )
                }
            }

        }
    })
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        HorizontalPager(
            modifier=Modifier.fillMaxWidth().height(400.dp),
            state = pagerState,
        ) {
                index -> PageUI(modifier = Modifier.fillMaxWidth(), page = items[index])
        }
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(16.dp)
        )
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