
package com.influx.fbapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subitem {

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("PriceInCents")
    @Expose
    private String priceInCents;
    @SerializedName("SubitemPrice")
    @Expose
    private String subitemPrice;
    @SerializedName("VistaParentFoodItemId")
    @Expose
    private String vistaParentFoodItemId;
    @SerializedName("VistaSubFoodItemId")
    @Expose
    private String vistaSubFoodItemId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(String priceInCents) {
        this.priceInCents = priceInCents;
    }

    public String getSubitemPrice() {
        return subitemPrice;
    }

    public void setSubitemPrice(String subitemPrice) {
        this.subitemPrice = subitemPrice;
    }

    public String getVistaParentFoodItemId() {
        return vistaParentFoodItemId;
    }

    public void setVistaParentFoodItemId(String vistaParentFoodItemId) {
        this.vistaParentFoodItemId = vistaParentFoodItemId;
    }

    public String getVistaSubFoodItemId() {
        return vistaSubFoodItemId;
    }

    public void setVistaSubFoodItemId(String vistaSubFoodItemId) {
        this.vistaSubFoodItemId = vistaSubFoodItemId;
    }

}
