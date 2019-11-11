
package com.influx.fbapp.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FoodList {

    @SerializedName("TabName")
    @Expose
    private String tabName;
    @SerializedName("fnblist")
    @Expose
    private List<Fnblist> fnblist = null;

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public List<Fnblist> getFnblist() {
        return fnblist;
    }

    public void setFnblist(List<Fnblist> fnblist) {
        this.fnblist = fnblist;
    }

}
