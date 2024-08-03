package com.example.shoppingadmin.DataLayer.Repo

import com.example.shoppingadmin.CommonState.State
import com.example.shoppingadmin.DomainLayer.Model.CategoryModel
import com.example.shoppingadmin.DomainLayer.Repo.ShoppingRepo
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import java.util.concurrent.Flow
import javax.inject.Inject

class ShoppingRepoImpl @Inject constructor(val firestore: FirebaseFirestore) : ShoppingRepo {
    override suspend fun addCategory(category: CategoryModel): kotlinx.coroutines.flow.Flow<State<String>> =
        callbackFlow {
            trySend(State.Loading)
            firestore.collection("CATEGORY").add(category).addOnSuccessListener {
                trySend(State.Success("Data Loaded"))
            }
                .addOnFailureListener {
                    trySend(State.Error("Error Accure"))
                }
            awaitClose {
                close()
            }
        }

}

