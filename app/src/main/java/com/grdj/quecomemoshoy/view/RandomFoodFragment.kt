package com.grdj.quecomemoshoy.view


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.viewmodel.ext.android.viewModel
import swipeable.com.layoutmanager.OnItemSwiped
import swipeable.com.layoutmanager.SwipeableTouchHelperCallback
import swipeable.com.layoutmanager.touchelper.ItemTouchHelper
import swipeable.com.layoutmanager.SwipeableLayoutManager;
import com.grdj.quecomemoshoy.R
import com.grdj.quecomemoshoy.adapters.SwiperAdapter
import com.grdj.quecomemoshoy.viewmodel.RandomFoodViewModel
import kotlinx.android.synthetic.main.fragment_random_food.*

class RandomFoodFragment : Fragment() {

    //// viewmodel inject by koin
    val viewModel: RandomFoodViewModel by viewModel()
    private lateinit var swiperAdapter : SwiperAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_random_food, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemOnClick: (Int) -> Unit = {position ->
        }

        val swipeableTouchHelperCallback = object : SwipeableTouchHelperCallback(object : OnItemSwiped {
            override fun onItemSwiped() {
                swiperAdapter.removeTopItem()
            }

            override fun onItemSwipedLeft() {
                Log.e("SWIPE", "LEFT")
            }

            override fun onItemSwipedRight() {
                Log.e("SWIPE", "RIGHT")
            }

            override fun onItemSwipedUp() {
                Log.e("SWIPE", "UP")
            }

            override fun onItemSwipedDown() {
                Log.e("SWIPE", "DOWN")
            }
        }) {
            override fun getAllowedSwipeDirectionsMovementFlags(viewHolder: RecyclerView.ViewHolder?): Int {
                return ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipeableTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recyclerSwipeableCards)

        swiperAdapter = SwiperAdapter(arrayListOf(), itemClickListener = itemOnClick)

        recyclerSwipeableCards.apply {
            adapter = swiperAdapter
            layoutManager = SwipeableLayoutManager().setAngle(10)
                .setAnimationDuratuion(450)
                .setMaxShowCount(3)
                .setScaleGap(0.1f)
                .setTransYGap(0)
        }

        viewModel.fetchFoodData()
        swiperAdapter.updateList(viewModel.recipeList)
    }

}
