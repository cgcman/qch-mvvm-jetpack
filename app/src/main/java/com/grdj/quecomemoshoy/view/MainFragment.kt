package com.grdj.quecomemoshoy.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager

import com.grdj.quecomemoshoy.R
import com.grdj.quecomemoshoy.adapters.foodTypeAdapter
import com.grdj.quecomemoshoy.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private val foodTypeAdapter = foodTypeAdapter( arrayListOf() )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        foodTypesList.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = foodTypeAdapter
        }

        viewModel.fetchFoodTypeData()

        foodTypeAdapter.updateList(viewModel.foodTypeList)
    }
}