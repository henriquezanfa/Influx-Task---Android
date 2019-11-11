package com.influx.fbapp.view.activities

import com.influx.fbapp.R
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.influx.fbapp.adapters.PagerAdapter
import com.influx.fbapp.view.fragments.ComboFragment
import com.influx.fbapp.view.fragments.CrepesFragment
import com.influx.fbapp.view.fragments.DrinksFragment
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolbar)
        toolbar_title.text = "F&B"

        supportActionBar?.setDisplayShowTitleEnabled(false)

        val adapter = PagerAdapter(supportFragmentManager)
        adapter.addFragment(ComboFragment(), "COMBOS")
        adapter.addFragment(DrinksFragment(), "DRINKS")
        adapter.addFragment(CrepesFragment(), "CREPES")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

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
