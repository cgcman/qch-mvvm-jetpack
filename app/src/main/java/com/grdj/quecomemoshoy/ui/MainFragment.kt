package com.grdj.quecomemoshoy.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import org.koin.android.viewmodel.ext.android.viewModel
import com.grdj.quecomemoshoy.R
import com.grdj.quecomemoshoy.ui.adapters.FoodTypeAdapter
import com.grdj.quecomemoshoy.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    //// viewmodel inject by koin
    val viewModel: MainViewModel by viewModel()
    private val foodTypeAdapter = FoodTypeAdapter( arrayListOf() )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        foodTypesList.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = foodTypeAdapter
        }

        viewModel.fetchFoodTypeData()
        foodTypeAdapter.updateList(viewModel.foodTypeList)

        roulette.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_main_to_random)
        }
    }
}