
package com.influx.fbapp.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestModel {

    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("FoodList")
    @Expose
    private List<FoodList> foodList = null;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<FoodList> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<FoodList> foodList) {
        this.foodList = foodList;
    }

}
