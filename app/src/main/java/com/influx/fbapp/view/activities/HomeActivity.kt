package com.influx.fbapp.view.activities

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.influx.fbapp.R
import com.influx.fbapp.adapters.PagerAdapter
import com.influx.fbapp.view.fragments.Fragment
import com.influx.fbapp.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val model = ViewModelProviders.of(this)[HomeViewModel::class.java]
        model.init()

        model.getTitleList().observe(this, Observer<ArrayList<String>> { list -> setupTablayout(list) })
    }


    private fun setupTablayoutNames(titleArray: ArrayList<String>) {
        val adapter = PagerAdapter(supportFragmentManager)
        for (title in titleArray) {
            adapter.addFragment(Fragment(), title)
        }
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }

    private fun setupTablayout(titleArray: ArrayList<String>) {
        setSupportActionBar(toolbar)
        toolbar_title.text = applicationInfo.loadLabel(packageManager).toString()

        supportActionBar?.setDisplayShowTitleEnabled(false)

        setupTablayoutNames(titleArray)

        val root = tabs.getChildAt(0)
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