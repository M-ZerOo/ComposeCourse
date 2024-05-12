package com.melfouly.composecourse.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.melfouly.composecourse.ui.theme.Black
import com.melfouly.composecourse.ui.theme.CardBackground
import com.melfouly.composecourse.ui.theme.Gray

@Composable
fun InfoCard(label: String, data: String) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)) {
            Text(
                text = label,
                fontWeight = FontWeight.Thin,
                fontSize = 9.sp,
                color = Gray
            )

            Text(
                text = data,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Black
            )
        }
    }
}