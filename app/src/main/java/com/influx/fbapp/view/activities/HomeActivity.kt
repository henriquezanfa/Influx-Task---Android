package com.influx.fbapp.view.activities

import android.annotation.SuppressLint
import android.graphics.Rect
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.influx.fbapp.R
import com.influx.fbapp.adapters.FoodListAdapter
import com.influx.fbapp.adapters.PagerAdapter
import com.influx.fbapp.adapters.SummaryItemAdapter
import com.influx.fbapp.interfaces.IAdapterView
import com.influx.fbapp.model.Fnblist
import com.influx.fbapp.model.RequestModel
import com.influx.fbapp.model.SummaryItem
import com.influx.fbapp.view.fragments.Fragment
import com.influx.fbapp.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.bottom_sheet.summary_recycler_view
import kotlinx.android.synthetic.main.fragment.*


class HomeActivity : AppCompatActivity(), IAdapterView   {

    private var bottomSheetBehavior: BottomSheetBehavior<View>? = null
    private lateinit var homeViewModel : HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homeViewModel = ViewModelProviders.of(this)[HomeViewModel::class.java]
        homeViewModel.init()

        homeViewModel.requestModel.observe(this, Observer<RequestModel> { request -> setupTablayout(request) })
        homeViewModel.summaryList.observe(this, Observer<ArrayList<SummaryItem>> { item -> updateSummaryList(item) })

        val bottomSheet: View = findViewById(R.id.bottomSheet)
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)

        val currentBottomSheetBehavior = bottomSheetBehavior
        currentBottomSheetBehavior?.isHideable = false

        currentBottomSheetBehavior?.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            @SuppressLint("SwitchIntDef")
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                // React to state change
                when (newState) {
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        bottomSheet.findViewById<ImageView>(R.id.downArrowImage).visibility = VISIBLE
                        bottomSheet.findViewById<ImageView>(R.id.upArrowImage).visibility = GONE
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        bottomSheet.findViewById<ImageView>(R.id.downArrowImage).visibility = GONE
                        bottomSheet.findViewById<ImageView>(R.id.upArrowImage).visibility = VISIBLE
                    }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }
        })
    }

    private fun updateSummaryList(item: ArrayList<SummaryItem>) {

        summary_recycler_view.layoutManager  = LinearLayoutManager(this)
        summary_recycler_view.adapter = SummaryItemAdapter(item,  this)


    }

    fun showBottom(view: View) {
        if (bottomSheetBehavior?.state == BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior?.state = BottomSheetBehavior.STATE_COLLAPSED
        } else if (bottomSheetBehavior?.state == BottomSheetBehavior.STATE_COLLAPSED) {
            bottomSheetBehavior?.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            if (bottomSheetBehavior?.state == BottomSheetBehavior.STATE_EXPANDED) {

                val outRect = Rect()
                bottomSheet.getGlobalVisibleRect(outRect)

                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt()))
                    bottomSheetBehavior?.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }

        return super.dispatchTouchEvent(event)
    }

    private fun setupTablayoutNames(request: RequestModel) {
        val adapter = PagerAdapter(supportFragmentManager)
        for (food in request.foodList) {
            adapter.addFragment(Fragment(food, request.currency, this), food.tabName)
        }
        viewPagerItem.adapter = adapter
        tabs.setupWithViewPager(viewPagerItem)
    }

    private fun setupTablayout(request: RequestModel) {
        setSupportActionBar(toolbar)
        toolbar_title.text = applicationInfo.loadLabel(packageManager).toString()

        supportActionBar?.setDisplayShowTitleEnabled(false)

        setupTablayoutNames(request)

        val root = tabs.getChildAt(1)
        if (root is LinearLayout) {
            root.showDividers = LinearLayout.SHOW_DIVIDER_MIDDLE
            val drawable = GradientDrawable()
            drawable.setColor(resources.getColor(R.color.separator))
            drawable.setSize(2, 1)
            root.dividerPadding = 10
            root.dividerDrawable = drawable
        }
    }

    override fun onFoodAdd(fnblist: Fnblist, sizeSelected: String?) {
        homeViewModel.onFoodAdd(fnblist, sizeSelected)
    }

    override fun onFoodRemove(fnblist: Fnblist, sizeSelected: String?) {
        homeViewModel.onFoodRemove(fnblist, sizeSelected)
    }
}