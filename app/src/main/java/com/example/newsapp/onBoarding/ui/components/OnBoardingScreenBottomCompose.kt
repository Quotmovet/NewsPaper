package com.example.newsapp.onBoarding.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.newsapp.onBoarding.data.pages
import com.example.newsapp.onBoarding.ui.common.OnBoardingBackButtonCommon
import com.example.newsapp.onBoarding.ui.common.OnBoardingIndicatorCommon
import com.example.newsapp.values.`object`.Dimens.IndicatorWidth
import com.example.newsapp.values.`object`.Dimens.MediumPadding
import kotlinx.coroutines.launch

//@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreenBottomCompose(){

    Column(modifier = Modifier.fillMaxSize()) {

        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonsState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }

        HorizontalPager(state = pagerState) { pageIndex ->
            OnBoardingScreenMainCompose(modifier = Modifier, page = pages[pageIndex])
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MediumPadding)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            OnBoardingIndicatorCommon(
                modifier = Modifier.width(IndicatorWidth),
                pageSize = pages.size,
                selectedPage = pagerState.currentPage
            )

            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically) {

                val scope = rememberCoroutineScope()

                if (buttonsState.value[0].isNotEmpty()) {

                    OnBoardingBackButtonCommon(
                        text = buttonsState.value[0],
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                            }
                        }
                    )
                }

                OnBoardingBackButtonCommon(text = buttonsState.value[1], onClick = {
                    scope.launch {
                        if (pagerState.currentPage == 3) {
                        //TODO Navigate to main screen
                        } else {
                            pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
                        }
                    }
                })
            }
        }

        Spacer(modifier = Modifier.weight(0.5f))
    }
}