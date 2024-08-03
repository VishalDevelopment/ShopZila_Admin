package com.example.shoppingadmin.DomainLayer.Repo

import com.example.shoppingadmin.CommonState.State
import com.example.shoppingadmin.DomainLayer.Model.CategoryModel
import kotlinx.coroutines.flow.callbackFlow
import java.util.concurrent.Flow

interface ShoppingRepo {

    suspend fun addCategory(category: CategoryModel): kotlinx.coroutines.flow.Flow<State<String>>
}