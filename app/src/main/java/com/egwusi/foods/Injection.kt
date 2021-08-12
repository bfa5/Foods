package com.egwusi.foods

import com.egwusi.foods.data.FoodsRepo
import com.egwusi.foods.database.FoodsDatabase
import com.egwusi.foods.service.FoodListService
import com.egwusi.foods.ui.ViewModelFactoryFoodList

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import java.util.concurrent.Executors

object Injection{
    private fun provideFoodsRepo(context: Context): FoodsRepo {
        val database = FoodsDatabase.getInstance(context)
        return FoodsRepo(FoodListService.create(), database.foodsDao(), Executors.newSingleThreadExecutor())
    }

    fun provideViewModelFactoryFoodList(context: Context): ViewModelProvider.Factory {
        return ViewModelFactoryFoodList(provideFoodsRepo(context))
    }
}
