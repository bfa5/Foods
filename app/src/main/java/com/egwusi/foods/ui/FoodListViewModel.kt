package com.egwusi.foods.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.egwusi.foods.data.FoodsRepo
import com.egwusi.foods.model.Food


class FoodListViewModel(foodsRepo: FoodsRepo) : ViewModel() {
    // TODO: Implement the ViewModel
    //list of all foods

    val foodList : LiveData<List<Food>> = foodsRepo.getAllFoods()

}
