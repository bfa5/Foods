package com.egwusi.foods.ui.connection

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.egwusi.foods.R

class FoodListFragment : Fragment() {

    companion object {
        fun newInstance() = FoodListFragment()
    }

    private lateinit var viewModel: FoodListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.food_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FoodListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
