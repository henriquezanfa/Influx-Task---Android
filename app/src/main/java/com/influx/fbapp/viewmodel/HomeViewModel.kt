package com.influx.fbapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.influx.fbapp.model.FoodList
import com.influx.fbapp.model.RequestModel
import com.influx.fbapp.service.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback

class HomeViewModel : ViewModel() {

    private val titleArray: MutableLiveData<ArrayList<String>> = MutableLiveData()

    fun init() {
        makeRequest()
    }

    private fun makeRequest() {
        val call = RetrofitInitializer().getData().getItems()
        call.enqueue(object : Callback<RequestModel?> {
            override fun onFailure(call: Call<RequestModel?>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<RequestModel?>, response: retrofit2.Response<RequestModel?>) {
                response.body()?.foodList?.let { makeTitleList(it) }
            }
        })
    }

    private fun makeTitleList(foodList: MutableList<FoodList>) {
        val titleList : ArrayList<String> = ArrayList()
        for(food in foodList) {
            if(!titleList.contains(food.tabName.toLowerCase()))
                titleList.add(food.tabName!!.toUpperCase())
        }
        titleArray.value = titleList
    }

    fun getTitleList(): MutableLiveData<ArrayList<String>> {
        return titleArray
    }
}