package com.egwusi.foods.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "Foods")
data class Food(@PrimaryKey @field:SerializedName("id") val id: Int,
                     @field:SerializedName("name") val name: String = "",
                     @field:SerializedName("description") val description: String = "",
                     @field:SerializedName("image") val image: String = "",
                     @field:SerializedName("price") val price: Int = 0)