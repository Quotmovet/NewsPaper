package com.example.newsapp.onBoarding.data

import androidx.annotation.DrawableRes
import com.example.newsapp.R

data class DataOnBoardingScreen(
    val tittle: String,
    val description: String,
    @DrawableRes val image: Int,
    val actionText: String,
    val action: () -> Unit,
    val showSkipButton: Boolean = false,
)

val pages = listOf(

    DataOnBoardingScreen(
        tittle = "Get News",
        description = "Get the latest news from around the world",
        image = R.drawable.ic_launcher_background,
        actionText = "Next",
        action = {},
    ),

    DataOnBoardingScreen(
        tittle = "Get News",
        description = "Get the latest news from around the world",
        image = R.drawable.ic_launcher_background,
        actionText = "Next",
        action = {},
    ),

    DataOnBoardingScreen(
        tittle = "Get News",
        description = "Get the latest news from around the world",
        image = R.drawable.ic_launcher_background,
        actionText = "Next",
        action = {},
    )

)
