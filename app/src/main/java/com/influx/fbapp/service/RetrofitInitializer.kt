package com.influx.fbapp.service

import com.influx.fbapp.model.RequestModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    private val retrofit =
        Retrofit.Builder()
            .baseUrl("http://www.mocky.io/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    fun getData() : IRequest {
        return retrofit.create(IRequest::class.java)
    }

}