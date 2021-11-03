package com.example.karidmarket.presentation.recipes.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.karidmarket.R
import com.example.karidmarket.presentation.recipes.model.ExtendedIngredientModel
import com.example.karidmarket.presentation.recipes.model.OtherDetailModel
import com.example.karidmarket.presentation.recipes.model.RecipedModel

class RecipeAdapter(val context: Context) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    private val items = ArrayList<OtherDetailModel>()

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val recipeFoodImg = itemView.findViewById<ImageView>(R.id.recipeFoodImg)
        val recipeFoodPricePerServing = itemView.findViewById<TextView>(R.id.recipeFoodPricePerServing)
        val recipeFoodTitle = itemView.findViewById<TextView>(R.id.recipeFoodTitle)
        val recipeFoodHealthyScore = itemView.findViewById<TextView>(R.id.recipeFoodHealthyScore)
        val recipeServings = itemView.findViewById<TextView>(R.id.recipeServings)

    }

    private fun bindViewHolder(holder: ViewHolder, otherDetailModel: OtherDetailModel) {
        holder.recipeFoodTitle.text = otherDetailModel.title
        holder.recipeFoodPricePerServing.text=otherDetailModel.pricePerServing.toString()+"$"
        holder.recipeFoodHealthyScore.text=otherDetailModel.healthScore.toString()
        holder.recipeServings.text=otherDetailModel.servings.toString()
        val posterURL = otherDetailModel.image
        Glide.with(context)
            .load(posterURL)
            .into(holder.recipeFoodImg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.recipe_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        bindViewHolder(holder, items[position])
    }


    override fun getItemCount(): Int =
        items.size

    fun setItems(items: OtherDetailModel) {
        this.items.clear()
        addItems(items)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(items: OtherDetailModel) {
        this.items.addAll(listOf(items))
        notifyDataSetChanged()
    }
}