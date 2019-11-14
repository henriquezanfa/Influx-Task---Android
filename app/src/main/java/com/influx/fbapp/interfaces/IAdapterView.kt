package com.influx.fbapp.interfaces

import com.influx.fbapp.model.Fnblist

interface IAdapterView {
    fun onFoodAdd(fnblist: Fnblist, sizeSelected: String?)
    fun onFoodRemove(fnblist: Fnblist, sizeSelected: String?)
}