package com.grdj.quecomemoshoy.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.viewmodel.ext.android.viewModel

import com.grdj.quecomemoshoy.R
import com.grdj.quecomemoshoy.adapters.FoodListAdapter
import com.grdj.quecomemoshoy.viewmodel.FoodListViewModel
import kotlinx.android.synthetic.main.fragment_food_list.*

class FoodListFragment : Fragment() {
    //// viewmodel inject by koin
    val viewModel: FoodListViewModel by viewModel()
    private val recipeAdapter = FoodListAdapter( arrayListOf() )
    private var from = 0
    private var to = 30
    private var query = "Pizza"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_food_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments.let {
            query = FoodListFragmentArgs.fromBundle(it!!).query
        }
        foodList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = recipeAdapter
        }
        val app_id = resources.getString(R.string.EDAMAM_APP_ID)
        val app_key = resources.getString(R.string.EDAMAM_API_KEY)
        viewModel.getDataFromTo(app_id, app_key, from.toString(), to.toString(), query)
        viewModel.recipes.observe(viewLifecycleOwner, Observer{ recipesList ->
            recipesList.let {
                recipeAdapter.updateList(it.hits)
            }
        })
        refreshLayout.setOnRefreshListener {

        }
    }
}