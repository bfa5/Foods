package com.egwusi.foods.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.egwusi.foods.R
import com.egwusi.foods.model.Food

class FoodViewHolder(view: View)  : RecyclerView.ViewHolder(view) {
    private val foodName: TextView = view.findViewById(R.id.foodName)
    private val foodPrice: TextView = view.findViewById(R.id.foodPrice)
    private val foodImage: ImageView = view.findViewById(R.id.foodImage)

    fun bind(food: Food?) {
        if (food != null) {
            showFoodData(food)
        }
    }

    private fun showFoodData(food: Food) {
        //food.apply {
            foodName.text = food.name
            foodPrice.text = food.price.toString()
            //foodImage.text = mountainRange
        //}
    }

    companion object {
        fun create(parent: ViewGroup): FoodViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.food_item, parent, false)
            return FoodViewHolder(view)
        }
    }
}
