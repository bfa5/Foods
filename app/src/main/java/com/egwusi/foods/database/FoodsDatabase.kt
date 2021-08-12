package com.egwusi.foods.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.egwusi.foods.model.Food

/**
 * Database to store all Foods
 */
@Database(
    entities = [Food::class],
    version = 1,
    exportSchema = false
)
abstract class FoodsDatabase : RoomDatabase() {

    abstract fun foodsDao(): FoodsDao

    companion object {
        @Volatile
        private var INSTANCE: FoodsDatabase? = null

        fun getInstance(context: Context): FoodsDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                FoodsDatabase::class.java, "Foods.db")
                .build()
    }
}
