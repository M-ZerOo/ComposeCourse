package com.melfouly.composecourse

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Account",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Edit and manage your account.",
            fontSize = 18.sp
        )

        Image(
            painter = painterResource(id = R.drawable.pic),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 18.dp)
                .align(Alignment.CenterHorizontally)
                .size(120.dp)
                .clip(RoundedCornerShape(8.dp))
        )

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Change profile picture",
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = Color.Blue
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun Preview() {
    ProfileScreen()
}