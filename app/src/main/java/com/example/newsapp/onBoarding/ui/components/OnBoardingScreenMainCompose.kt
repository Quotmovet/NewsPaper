package com.example.newsapp.onBoarding.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapp.R
import com.example.newsapp.onBoarding.data.DataOnBoardingScreen
import com.example.newsapp.onBoarding.data.pages
import com.example.newsapp.values.`object`.Dimens.LargePadding
import com.example.newsapp.values.`object`.Dimens.MediumPadding
import com.example.newsapp.values.settings.NewsAppTheme

@Composable
fun OnBoardingScreenMainCompose(
    modifier: Modifier,
    page: DataOnBoardingScreen
) {
    Column(modifier = modifier) {

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f),
            painter = painterResource(id = page.image),
            contentScale = ContentScale.Crop,
            contentDescription = null)

        Spacer(modifier = Modifier.height(MediumPadding))

        Text(
            modifier = Modifier
                .padding(horizontal = LargePadding),
            text = page.tittle,
            style = MaterialTheme.typography.displaySmall
                .copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.black)
        )

        Text(
            modifier = Modifier
                .padding(horizontal = LargePadding),
            text = page.description,
            style = MaterialTheme.typography.displaySmall,
            color = colorResource(id = R.color.black)
        )

        Row(modifier = Modifier) {

        }
    }
}

@Preview (showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES,showBackground = true)
@Composable
fun PreviewComposeOnBoarding() {
    NewsAppTheme{
        OnBoardingScreenMainCompose(
            page = pages[0],
            modifier = Modifier
        )
    }
}