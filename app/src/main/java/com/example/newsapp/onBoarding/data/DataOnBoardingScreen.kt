package com.example.newsapp.onBoarding.data

import androidx.annotation.DrawableRes
import com.example.newsapp.R

data class DataOnBoardingScreen(
    val tittle: Int,
    val description: String,
    @DrawableRes val image: Int,
    val actionText: Int,
    val action: () -> Unit,
    val showSkipButton: Boolean = false,
)

val actual = R.string.actual
val next = R.string.next

val pages = listOf(

    DataOnBoardingScreen(
        tittle = actual,
        description = "Get the latest news from around the world",
        image = R.drawable.pexels_nbasak_30157461__1_,
        actionText = next,
        action = {},
    ),

    DataOnBoardingScreen(
        tittle = actual,
        description = "Get the latest news from around the world",
        image = R.drawable.pexels_cmrcn_30243611__1_,
        actionText = next,
        action = {},
    ),

    DataOnBoardingScreen(
        tittle = actual,
        description = "Get the latest news from around the world",
        image = R.drawable.pexels_kovyrina_30474533__1_,
        actionText = next,
        action = {},
    )

)
