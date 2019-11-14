package com.influx.fbapp.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Outline
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.influx.fbapp.R
import com.influx.fbapp.interfaces.IAdapterView
import com.influx.fbapp.model.FoodList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.food_list_item.view.*


class FoodListAdapter(
    private val foodList: FoodList,
    private val context: Context,
    private val currency: Any?,
    private val adapterView: IAdapterView

) :
    RecyclerView.Adapter<FoodListAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return foodList.fnblist.size
    }

    private var sizeSelected: String? = null

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val image = holder.posterImg
        val curveRadius = 20F

        image.outlineProvider = object : ViewOutlineProvider() {

            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun getOutline(view: View?, outline: Outline?) {
                outline?.setRoundRect(0, 0, view!!.width, (view.height + curveRadius).toInt(), curveRadius)
            }
        }

        image.clipToOutline = true

        Picasso.get().load(foodList.fnblist[position].imgUrl).fit().centerCrop().into(image)

        holder.productTitle.text = foodList.fnblist[position].name.toUpperCase()

        val builder = StringBuilder()
        builder.append(currency).append(" ").append(foodList.fnblist[position].itemPrice)
        holder.itemPrice.text = builder.toString()

        holder.itemView.plus_button.setOnClickListener {
            holder.quantityText.text = (((holder.quantityText.text.toString().toInt() + 1).toString()))
            adapterView.onFoodAdd(foodList.fnblist[position], sizeSelected)
        }

        holder.itemView.minus_button.setOnClickListener {
            if (holder.quantityText.text.toString().toInt() > 0) {
                holder.quantityText.text =
                    (((holder.quantityText.text.toString().toInt() - 1).toString()))
                adapterView.onFoodRemove(foodList.fnblist[position], sizeSelected)
            }
        }

        holder.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val idRadioButtonChosen = holder.radioGroup.checkedRadioButtonId

            if (idRadioButtonChosen > 0) {
                when (checkedId) {
                    holder.radioNormal.id -> sizeSelected = holder.radioNormal.text.toString()
                    holder.radioRegular.id -> sizeSelected = holder.radioRegular.text.toString()
                    holder.radioLarge.id -> sizeSelected = holder.radioLarge.text.toString()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.food_list_item, parent, false))
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var posterImg: ImageView = view.poster_img
        var productTitle: TextView = view.product_title
        var itemPrice: TextView = view.itemPrice
        var quantityText: TextView = view.quantity_button
        var radioGroup: RadioGroup = view.radio_group
        var radioNormal: RadioButton = view.normal_button
        var radioRegular: RadioButton = view.regular_button
        var radioLarge: RadioButton = view.large_button

    }
}