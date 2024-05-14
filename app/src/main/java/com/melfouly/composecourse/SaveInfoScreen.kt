package com.melfouly.composecourse

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.melfouly.composecourse.viewmodel.SaveInfoViewModel

@Composable
fun SaveInfoScreen(
    navController: NavController,
    viewModel: SaveInfoViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    SaveInfoContent(
        state,
        onClickBack = { navController.navigateUp() }
    )
}

@Composable
fun SaveInfoContent(
    state: String,
    onClickBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = state)
        Spacer(modifier = Modifier.padding(vertical = 16.dp))
        Button(onClick = onClickBack) {
            Text(text = "Back")
        }
    }
}