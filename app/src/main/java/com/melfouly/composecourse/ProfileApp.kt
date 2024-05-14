package com.melfouly.composecourse

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.melfouly.composecourse.ui.theme.ComposeCourseTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileApp() {
    ComposeCourseTheme {
        Scaffold {
            val navController = rememberNavController()
            ProfileNavGraph(navController = navController)
        }
    }
}