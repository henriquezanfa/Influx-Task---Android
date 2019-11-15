package com.influx.fbapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.influx.fbapp.R
import com.influx.fbapp.adapters.FoodListAdapter
import com.influx.fbapp.interfaces.IAdapterView
import com.influx.fbapp.model.Fnblist
import com.influx.fbapp.model.FoodList
import com.influx.fbapp.viewmodel.FragmentViewModel
import kotlinx.android.synthetic.main.fragment.*

class Fragment(
    private val foodList: FoodList,
    private var currency: String,
    private var interfaceAdapter: IAdapterView?
) : Fragment(), IAdapterView  {
    private lateinit var viewModel: FragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FragmentViewModel::class.java)

        food_recycler_view.layoutManager  = LinearLayoutManager(activity)
        food_recycler_view.adapter = context?.let { FoodListAdapter(foodList, it, currency, this) }
    }

    override fun onFoodAdd(fnblist: Fnblist, sizeSelected: String?) {
        interfaceAdapter?.onFoodAdd(fnblist, sizeSelected)
    }

    override fun onFoodRemove(fnblist: Fnblist, sizeSelected: String?) {
        interfaceAdapter?.onFoodRemove(fnblist, sizeSelected)
    }
}
