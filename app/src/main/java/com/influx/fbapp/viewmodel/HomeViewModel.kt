package com.influx.fbapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.influx.fbapp.model.Fnblist
import com.influx.fbapp.model.RequestModel
import com.influx.fbapp.model.SummaryItem
import com.influx.fbapp.service.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class HomeViewModel : ViewModel() {

    val requestModel: MutableLiveData<RequestModel> = MutableLiveData()
    var summaryList : MutableLiveData<ArrayList<SummaryItem>> = MutableLiveData()

    fun init() {
        makeRequest()
    }

    private fun makeRequest() {
        val call = RetrofitInitializer().getData().getItems()
        call.enqueue(object : Callback<RequestModel?> {
            override fun onFailure(call: Call<RequestModel?>, t: Throwable) {
                Log.e("onFailure", t.localizedMessage)
            }

            override fun onResponse(call: Call<RequestModel?>, response: Response<RequestModel?>) {
                 populateObjects(response)
            }
        })
    }

    fun onFoodAdd(fnblist: Fnblist, sizeSelected: String?) {
        Log.i("onFoddAdd", "comida add")

        val item = SummaryItem()
        item.name = fnblist.name
        item.price = fnblist.itemPrice.toFloat()

        summaryList.value?.add(item)

    }

    fun onFoodRemove(fnblist: Fnblist, sizeSelected: String?) {

        val item = SummaryItem()
        item.name = fnblist.name
        item.price = fnblist.itemPrice.toFloat()

        summaryList.value?.remove(item)

    }

    private fun populateObjects(response: Response<RequestModel?>) {
        response.body()?.let { makeFoodList(it) }
    }

    private fun makeFoodList(request: RequestModel) {
        requestModel.value = request
    }
}