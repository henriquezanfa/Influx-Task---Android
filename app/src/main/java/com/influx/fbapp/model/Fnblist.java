
package com.influx.fbapp.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fnblist {

    @SerializedName("Cinemaid")
    @Expose
    private String cinemaid;
    @SerializedName("TabName")
    @Expose
    private String tabName;
    @SerializedName("VistaFoodItemId")
    @Expose
    private String vistaFoodItemId;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("PriceInCents")
    @Expose
    private String priceInCents;
    @SerializedName("ItemPrice")
    @Expose
    private String itemPrice;
    @SerializedName("SevenStarExperience")
    @Expose
    private String sevenStarExperience;
    @SerializedName("OtherExperience")
    @Expose
    private String otherExperience;
    @SerializedName("SubItemCount")
    @Expose
    private Integer subItemCount;
    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("ImgUrl")
    @Expose
    private String imgUrl;
    @SerializedName("VegClass")
    @Expose
    private String vegClass;
    @SerializedName("subitems")
    @Expose
    private List<Subitem> subitems = null;

    public String getCinemaid() {
        return cinemaid;
    }

    public void setCinemaid(String cinemaid) {
        this.cinemaid = cinemaid;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public String getVistaFoodItemId() {
        return vistaFoodItemId;
    }

    public void setVistaFoodItemId(String vistaFoodItemId) {
        this.vistaFoodItemId = vistaFoodItemId;
    }

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

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getSevenStarExperience() {
        return sevenStarExperience;
    }

    public void setSevenStarExperience(String sevenStarExperience) {
        this.sevenStarExperience = sevenStarExperience;
    }

    public String getOtherExperience() {
        return otherExperience;
    }

    public void setOtherExperience(String otherExperience) {
        this.otherExperience = otherExperience;
    }

    public Integer getSubItemCount() {
        return subItemCount;
    }

    public void setSubItemCount(Integer subItemCount) {
        this.subItemCount = subItemCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getVegClass() {
        return vegClass;
    }

    public void setVegClass(String vegClass) {
        this.vegClass = vegClass;
    }

    public List<Subitem> getSubitems() {
        return subitems;
    }

    public void setSubitems(List<Subitem> subitems) {
        this.subitems = subitems;
    }

}
