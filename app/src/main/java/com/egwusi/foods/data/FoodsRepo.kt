package com.egwusi.foods.data


import androidx.lifecycle.LiveData
import com.egwusi.foods.database.FoodsDao
import com.egwusi.foods.model.Food
import com.egwusi.foods.service.FoodListService
import com.egwusi.foods.service.requestFoods
import java.util.concurrent.Executor

class FoodsRepo(private val foodListService: FoodListService,
                private val foodsDao: FoodsDao, private val ioExecutor: Executor) {

    fun getAllFoods(): LiveData<List<Food>> {
        requestFoods(foodListService, {
                foods ->
            ioExecutor.execute {
                foodsDao.insertAll(foods)
            }
        }, { error ->

        })
        return foodsDao.getAllFoods()
    }
}