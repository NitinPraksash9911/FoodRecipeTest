package com.example.androidstudyjam.datasource.model

import com.google.gson.annotations.SerializedName

data class FoodRecipe(
    @SerializedName("searchResults")
    val searchResults: List<SearchResult>,
    @SerializedName("totalResults")
    val totalResults: Int
) {

    data class SearchResult(
        @SerializedName("name")
        val name: String,
        @SerializedName("results")
        val results: List<Result>,
        @SerializedName("totalResults")
        val totalResults: Int,
        @SerializedName("totalResultsVariants")
        val totalResultsVariants: Int,
        @SerializedName("type")
        val type: String
    ) {
        data class Result(
            @SerializedName("content")
            val content: String?,
            @SerializedName("id")
            val id: Int,
            @SerializedName("image")
            val image: String,
            @SerializedName("name")
            val name: String,
        )
    }
}