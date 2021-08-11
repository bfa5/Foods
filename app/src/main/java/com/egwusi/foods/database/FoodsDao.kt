package com.egwusi.foods.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.egwusi.foods.model.Food

@Dao
interface FoodsDao {
    //Get all Foods
    @Query("SELECT * FROM Foods")
    fun getFoods(): LiveData<List<Food>>
}