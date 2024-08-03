package com.example.shoppingadmin.UiLayer.ViewModel

import android.net.Uri
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppingadmin.CommonState.State
import com.example.shoppingadmin.DataLayer.Repo.ShoppingRepoImpl
import com.example.shoppingadmin.DomainLayer.Model.CategoryModel
import com.example.shoppingadmin.DomainLayer.Repo.ShoppingRepo
import com.google.firebase.storage.FirebaseStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingViewModel @Inject constructor(val shoppingRepo: ShoppingRepoImpl) : ViewModel() {
    val category = mutableStateOf(CategoryModel())
    private val _categoryState: MutableState<CategoryState> = mutableStateOf(CategoryState())
    val categoryState = _categoryState
    fun addCategory() {
        viewModelScope.launch {
            shoppingRepo.addCategory(category.value).collectLatest {
                when (it) {
                    is State.Error -> {
                        categoryState.value = CategoryState(error = it.message.toString())
                    }

                    State.Loading -> {
                        categoryState.value = CategoryState(isLoading = true)
                    }

                    is State.Success -> {
                        categoryState.value = CategoryState(data = it.data)
                    }
                }
            }
        }
    }

    fun uploadImage(uri: Uri,onSuccess : (uri:String)-> Unit){
        FirebaseStorage.getInstance().reference.child("CATEGORY").child(System.currentTimeMillis().toString()).putFile(uri).addOnCompleteListener{
            onSuccess(it.result.storage.downloadUrl.result.toString())
        }
    }

}

data class CategoryState(
    val data: String = "",
    val isLoading: Boolean = false,
    val error: String = "",
)