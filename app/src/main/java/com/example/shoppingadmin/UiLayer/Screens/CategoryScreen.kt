package com.example.shoppingadmin.UiLayer.Screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.example.shoppingadmin.DomainLayer.Model.CategoryModel
import com.example.shoppingadmin.UiLayer.ViewModel.ShoppingViewModel


@Composable
fun CategoryScreen(viewModel: ShoppingViewModel= hiltViewModel()) {
    val state = viewModel.categoryState.value
    var image by remember{ mutableStateOf("") }
    val galleryLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent(), onResult = {
        uri ->
        uri?.let {
            viewModel.uploadImage(uri!!){
                image = it
            }
        }
    })

  if (state.isLoading){
      Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
          CircularProgressIndicator()
      }
  }
    if (state.error.isNotBlank()){
        Text(text = state.error)
    }
    val data = remember {
        mutableStateOf("")
    }
    Column(modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(value = data.value, onValueChange = {
             data.value= it
        })
        Card(elevation = CardDefaults.cardElevation(0.1.dp), modifier = Modifier.clickable {
            galleryLauncher.launch("image/*")
        }){
            Text(text = "Upload Image",modifier = Modifier.fillMaxSize(),textAlign = TextAlign.Center)
        }
        Button(onClick = {
            viewModel.category.value = CategoryModel(name = data.value, createBy = "Vishal", imageUrl = image)
            viewModel.addCategory()
        }, modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(.8f)) {
            Text(text = "Submit")
        }
    }
}