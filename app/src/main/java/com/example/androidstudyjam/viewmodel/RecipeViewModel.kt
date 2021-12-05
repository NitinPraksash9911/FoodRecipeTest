package com.example.androidstudyjam.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidstudyjam.datasource.model.FoodRecipe
import com.example.androidstudyjam.datasource.repository.RecipeRepositoryImpl
import com.example.androidstudyjam.network.RetrofitFactory
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {

    private val recipeRepositoryImpl = RecipeRepositoryImpl(RetrofitFactory)

    private var mutableLiveData = MutableLiveData<FoodRecipe>()

    val foodRecipeLiveData: LiveData<FoodRecipe>
        get() = mutableLiveData

    fun searchFood(foodName: String, recipeCount: Int = 10) {

        viewModelScope.launch {

            val response = recipeRepositoryImpl.searchRecipe(foodName, recipeCount)
            mutableLiveData.value = response.body()

        }
    }
}