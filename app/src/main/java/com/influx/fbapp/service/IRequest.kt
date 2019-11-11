package com.influx.fbapp.service

import com.influx.fbapp.model.RequestModel
import retrofit2.Call
import retrofit2.http.GET

interface IRequest {
    @GET("5b700cff2e00005c009365cf")
    fun getItems() : Call<RequestModel>
}