package com.egwusi.foods.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.egwusi.foods.data.FoodsRepo

class ViewModelFactoryFoodList(private val foodsRepo: FoodsRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FoodListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FoodListViewModel(foodsRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}