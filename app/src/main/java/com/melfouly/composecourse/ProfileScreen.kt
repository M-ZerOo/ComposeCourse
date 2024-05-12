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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.melfouly.composecourse.composables.InfoCard
import com.melfouly.composecourse.composables.ProfileAvatar
import com.melfouly.composecourse.composables.ProfileHeader
import com.melfouly.composecourse.ui.theme.Green


@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    ProfileContent(
        state,
        viewModel::onChangeFirstName,
        viewModel::onChangeLastName,
        viewModel::onChangeLocation,
        viewModel::onChangeEmail,
        viewModel::onChangePhone,
        viewModel::saveUserInfo
    )
}

@Composable
private fun ProfileContent(
    state: ProfileUiState,
    onChangeFirstName: (String) -> Unit,
    onChangeLastName: (String) -> Unit,
    onChangeLocation: (String) -> Unit,
    onChangeEmail: (String) -> Unit,
    onChangePhone: (String) -> Unit,
    saveUserInfo: () -> Unit
) {
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
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp),
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
                InfoCard(
                    label = "First Name",
                    data = state.firstName,
                    onTextChange = onChangeFirstName
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Box(modifier = Modifier.weight(1f)) {
                InfoCard(
                    label = "Last Name",
                    data = state.lastName,
                    onTextChange = onChangeLastName
                )
            }
        }

        InfoCard(label = "Location", data = state.location, onTextChange = onChangeLocation)
        InfoCard(label = "Email", data = state.email, onTextChange = onChangeEmail)
        InfoCard(label = "Phone", data = state.phone, onTextChange = onChangePhone)

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = saveUserInfo,
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