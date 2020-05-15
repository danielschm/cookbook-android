package com.example.cookbook.ui.meal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cookbook.data.MealRepository

class MealViewModelFactory(private val repository: MealRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MealViewModel(repository) as T
    }
}