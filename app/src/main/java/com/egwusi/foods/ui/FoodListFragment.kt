package com.egwusi.foods.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.egwusi.foods.Injection

import androidx.recyclerview.widget.LinearLayoutManager

import com.egwusi.foods.R
import com.egwusi.foods.model.Food
import kotlinx.android.synthetic.main.food_list_fragment.*

class FoodListFragment : Fragment() {

    private lateinit var viewModelFoodList: FoodListViewModel
    private var adapter = FoodsAdapter()

    companion object {
        fun newInstance() = FoodListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModelFoodList = ViewModelProvider(this,
            Injection.provideViewModelFactoryFoodList(requireContext())).get(FoodListViewModel::class.java)
        initAdapter()

        return inflater.inflate(R.layout.food_list_fragment, container, false)
    }

   /* override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FoodListViewModel::class.java)
        // TODO: Use the ViewModel
    }*/

    private fun initAdapter(){
        list.layoutManager = LinearLayoutManager(requireContext())
        list.adapter = adapter

        /**
         * Observe changes in the list of foods
         */
        viewModelFoodList.foodList.observe(viewLifecycleOwner, Observer<List<Food>> {
            adapter.submitList(it)
        })
    }

}
