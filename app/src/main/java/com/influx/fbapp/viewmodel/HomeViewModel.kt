package com.influx.fbapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.influx.fbapp.model.Fnblist
import com.influx.fbapp.model.RequestModel
import com.influx.fbapp.service.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val responseArray: MutableLiveData<RequestModel> = MutableLiveData()
    private val productsArray: MutableLiveData<ArrayList<ArrayList<Fnblist>>> = MutableLiveData()

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

    private fun populateObjects(response: Response<RequestModel?>) {
        response.body()?.let { makeFoodList(it) }

    }

    private fun makeFoodList(request: RequestModel) {
        responseArray.value = request
    }


    fun getResponse(): MutableLiveData<RequestModel> {
        return responseArray
    }

    fun getProductsList() : MutableLiveData<ArrayList<ArrayList<Fnblist>>> {
        return productsArray
    }
}