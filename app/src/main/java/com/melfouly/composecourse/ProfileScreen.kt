package com.melfouly.composecourse

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.melfouly.composecourse.composables.InfoCard
import com.melfouly.composecourse.composables.ProfileAvatar
import com.melfouly.composecourse.composables.ProfileHeader
import com.melfouly.composecourse.ui.theme.Green

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.Start
    ) {
        ProfileHeader(title = "Account", desc = "Edit and manage your account.")

        ProfileAvatar(
            painter = painterResource(id = R.drawable.pic),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Change profile picture",
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = Color.Blue
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(modifier = Modifier.weight(1f)) {
                InfoCard(label = "First Name", data = "Mahmoud")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Box(modifier = Modifier.weight(1f)) {
                InfoCard(label = "Last Name", data = "Reda")
            }
        }

        InfoCard(label = "Location", data = "Egypt, Giza")
        InfoCard(label = "Email", data = "abcxxx@gmail.com")
        InfoCard(label = "Phone", data = "+200000000")

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Green)
        ) {
            Text(
                text = "Save",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Preview() {
    ProfileScreen()
}