package com.example.cookbook.data

import com.example.cookbook.model.Meal
import com.example.cookbook.model.TagList

class MealRepository {
    fun retrieveMeals(callback: OperationCallback<ArrayList<Meal>>) {
        val meals = arrayListOf(
            Meal("Sushi", "60+ min", arrayListOf("japanisch", "reis")),
            Meal("Gnocchis mit Tomatensauce", "30-60 min", arrayListOf("vegan")),
            Meal("Spaghetti", "bis 30 min", arrayListOf("pasta", "basic"))
        )

//        ApiClient.retrieveData(callback)
        callback.onSuccess(meals)
    }
}