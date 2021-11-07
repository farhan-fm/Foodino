package com.example.karidmarket.presentation.ingredientcompute.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.karidmarket.R
import com.example.karidmarket.presentation.ingredientcompute.model.IngredientAmountResponseModel
import com.example.karidmarket.presentation.recipes.model.OtherDetailModel
import com.example.karidmarket.presentation.recipes.view.RecipeAdapter

class IngredientAmountAdapter(val context: Context) :
    RecyclerView.Adapter<IngredientAmountAdapter.ViewHolder>() {

    private val items = ArrayList<IngredientAmountResponseModel>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var foodStuffName: TextView = itemView.findViewById(R.id.foodStuffName)
        var foodStuffAmount: TextView = itemView.findViewById(R.id.foodStuffAmount)
        var foodStuffConsistency: TextView =
            itemView.findViewById(R.id.foodStuffConsistency)
    }

    private fun bindViewHolder(
        holder: ViewHolder,
        ingredientAmountResponseModel: IngredientAmountResponseModel
    ) {
        holder.foodStuffName.text = ingredientAmountResponseModel.originalName
        holder.foodStuffAmount.text = ingredientAmountResponseModel.amount.toString()
        holder.foodStuffConsistency.text = ingredientAmountResponseModel.consistency

        NutritionAdapter(context,ingredientAmountResponseModel.nutritionModel.nutrientModels)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context)
                .inflate(R.layout.item_ingredient_amount_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        bindViewHolder(holder, items[position])
    }

    override fun getItemCount(): Int =
        items.size

    fun setItems(items: IngredientAmountResponseModel) {
        this.items.clear()
        addItems(items)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(items: IngredientAmountResponseModel) {
        this.items.addAll(listOf(items))
        notifyDataSetChanged()
    }

}