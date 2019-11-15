package com.influx.fbapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.influx.fbapp.R
import com.influx.fbapp.model.SummaryItem
import kotlinx.android.synthetic.main.summary_list_item.view.*


class SummaryItemAdapter(
    private val summaryItemList: ArrayList<SummaryItem>,
    private val context: Context

) :
    RecyclerView.Adapter<SummaryItemAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return summaryItemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameItem.text = summaryItemList[position].name
        holder.priceItem.text = summaryItemList[position].price.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.summary_list_item, parent, false))
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var nameItem: TextView = view.itemNameTextView
        var priceItem: TextView = view.priceItemTextView

    }
}