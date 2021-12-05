package com.example.androidstudyjam.datasource.repository

import com.example.androidstudyjam.network.RecipeService
import com.example.androidstudyjam.network.RetrofitFactory

class RecipeRepositoryImpl(private val retrofitFactory: RetrofitFactory) {

    suspend fun searchRecipe(foodName: String, recipeCount: Int) =
        retrofitFactory.retrofit.create(RecipeService::class.java).searchRecipe(foodName, recipeCount)

}