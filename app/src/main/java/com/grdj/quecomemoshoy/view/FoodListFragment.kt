package com.grdj.quecomemoshoy.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.android.viewmodel.ext.android.viewModel

import com.grdj.quecomemoshoy.R
import com.grdj.quecomemoshoy.adapters.FoodListAdapter
import com.grdj.quecomemoshoy.viewmodel.FoodListViewModel

class FoodListFragment : Fragment() {

    //// viewmodel inject by koin
    val viewModel: FoodListViewModel by viewModel()
    lateinit var recipeAdapter: FoodListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_list, container, false)
    }


}
