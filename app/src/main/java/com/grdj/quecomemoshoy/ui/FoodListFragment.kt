package com.grdj.quecomemoshoy.ui


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.viewmodel.ext.android.viewModel
import com.grdj.quecomemoshoy.R
import com.grdj.quecomemoshoy.ui.adapters.FoodListAdapter
import com.grdj.quecomemoshoy.viewmodel.FoodListViewModel
import kotlinx.android.synthetic.main.fragment_food_list.*

class FoodListFragment : Fragment() {
    val viewModel: FoodListViewModel by viewModel()
    private val recipeAdapter = FoodListAdapter( arrayListOf() )
    private var from = 0
    private var to = 30
    private var query = "Pizza"
    private var attached = false

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
            listTitle.text = query
        }
        foodList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = recipeAdapter
        }
        refreshLayout.setOnRefreshListener {
            getRecipes()
        }
        if(attached){
            getRecipes()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        attached = true
    }

    private fun getRecipes(){
        progresBar.visibility= View.VISIBLE
        viewModel.getDataFromTo(from.toString(), to.toString(), query)
        viewModel.recipes.observe(viewLifecycleOwner, Observer{ recipesList ->
            recipesList.let {
                recipeAdapter.updateList(it.hits)
                refreshLayout.isRefreshing = false
                error.visibility= View.GONE
                progresBar.visibility= View.GONE
                attached = false
            }
        })

        viewModel.error.observe(viewLifecycleOwner, Observer{
            if(it){
                error.visibility= View.VISIBLE
                progresBar.visibility= View.GONE
            }
        })
    }
}