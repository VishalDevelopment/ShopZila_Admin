package com.example.shoppingadmin.UiLayer.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun NotificationScreen (){
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = "Notification", fontSize = 20.sp)
    }
}