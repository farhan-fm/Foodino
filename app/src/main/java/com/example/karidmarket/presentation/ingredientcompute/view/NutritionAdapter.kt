package com.example.karidmarket.presentation.ingredientcompute.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.karidmarket.R
import com.example.karidmarket.presentation.ingredientcompute.model.IngredientAmountResponseModel
import com.example.karidmarket.presentation.ingredientcompute.model.NutrientModel
import com.example.karidmarket.presentation.recipes.model.OtherDetailModel

class NutritionAdapter(val context: Context, val items: ArrayList<NutrientModel>) :
    RecyclerView.Adapter<NutritionAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var nutrientName: TextView = itemView.findViewById(R.id.nutrientName)
        var nutrientAmount: TextView = itemView.findViewById(R.id.nutrientAmount)
        var nutrientUnit: TextView =
            itemView.findViewById(R.id.nutrientUnit)

    }

    private fun bindViewHolder(
        holder: ViewHolder,
        nutrientModel: NutrientModel
    ) {
        holder.nutrientName.text = nutrientModel.name
        holder.nutrientAmount.text = nutrientModel.amount.toString()
        holder.nutrientUnit.text = nutrientModel.unit

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context)
                .inflate(R.layout.item_nutient_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        bindViewHolder(holder, items[position])
    }

    override fun getItemCount(): Int = items.size


}