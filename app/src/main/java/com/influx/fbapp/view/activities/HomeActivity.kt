package com.influx.fbapp.view.activities

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.influx.fbapp.R
import com.influx.fbapp.adapters.PagerAdapter
import com.influx.fbapp.model.RequestModel
import com.influx.fbapp.view.fragments.Fragment
import com.influx.fbapp.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val model = ViewModelProviders.of(this)[HomeViewModel::class.java]
        model.init()

        model.getResponse().observe(this, Observer<RequestModel> { request -> setupTablayout(request) })
    }


    private fun setupTablayoutNames(request: RequestModel) {
        val adapter = PagerAdapter(supportFragmentManager)
        for (food in request.foodList) {
            adapter.addFragment(Fragment(food, request.currency), food.tabName)
        }
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
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
}