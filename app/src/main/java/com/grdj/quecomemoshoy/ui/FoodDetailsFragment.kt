package com.grdj.quecomemoshoy.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.grdj.quecomemoshoy.R
import com.grdj.quecomemoshoy.databinding.FragmentFoodDetailsBinding
import com.grdj.quecomemoshoy.viewmodel.FoodDetailsViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class FoodDetailsFragment : Fragment() {

    val viewModel: FoodDetailsViewModel by viewModel()
    private lateinit var dataBindng: FragmentFoodDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBindng = DataBindingUtil.inflate(inflater, R.layout.fragment_food_details, container, false)
        return dataBindng.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments.let {
            dataBindng.recipeModel = FoodDetailsFragmentArgs.fromBundle(it!!).recipe
        }
    }

}
