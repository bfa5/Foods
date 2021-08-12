package com.egwusi.foods.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.egwusi.foods.model.Food

@Dao
interface FoodsDao {

    //Add a list of foods
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(foodList: List<Food>)

    //Get all Foods
    @Query("SELECT * FROM Foods")
    fun getAllFoods(): LiveData<List<Food>>
}