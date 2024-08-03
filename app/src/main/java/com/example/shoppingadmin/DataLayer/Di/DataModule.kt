package com.example.shoppingadmin.DataLayer.Di

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun provideFireStore ():FirebaseFirestore{
        return FirebaseFirestore.getInstance()
    }
}