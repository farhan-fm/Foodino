package com.example.karidmarket.presentation.recipes.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.karidmarket.R
import com.example.karidmarket.presentation.recipes.model.ExtendedIngredientModel
import com.example.karidmarket.presentation.recipes.model.OtherDetailModel
import com.example.karidmarket.presentation.recipes.model.ShowExtendedIngredient

class RecipeFullInfoAdapter(val context: Context) :
    RecyclerView.Adapter<RecipeFullInfoAdapter.ViewHolder>() {

    val extendedIngredient =ArrayList<ShowExtendedIngredient>()

    val extendedIngredientItem = ArrayList<ExtendedIngredientModel>()
    val otherDetailItem = ArrayList<OtherDetailModel>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipeFoodImage = itemView.findViewById<ImageView>(R.id.recipeFoodImage)
        val recipeFoodTitle = itemView.findViewById<TextView>(R.id.recipeFoodTitle)
        val recipeFoodPricePerServing = itemView.findViewById<TextView>(R.id.recipeFoodPricePerServing)
        val recipeExtendedIngredientDetail = itemView.findViewById<ListView>(R.id.recipeExtendedIngredientDetail)
        val recipeFoodInstructions = itemView.findViewById<TextView>(R.id.recipeFoodInstructions)

    }

    private fun bindViewHolder(holder: RecipeFullInfoAdapter.ViewHolder,extendedIngredientModel:ExtendedIngredientModel ,otherDetailModel: OtherDetailModel) {
        holder.recipeFoodTitle.text = otherDetailModel.title
        holder.recipeFoodPricePerServing.text=otherDetailModel.pricePerServing.toString()+"$"


    //    holder.recipeExtendedIngredientDetail=otherDetailModel.healthScore.toString()

        holder.recipeFoodInstructions.text=otherDetailModel.instructions.toString()
        val posterURL = otherDetailModel.image
        Glide.with(context)
            .load(posterURL)
            .into(holder.recipeFoodImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.recipe_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        bindViewHolder(holder, extendedIngredientItem[position],otherDetailItem[position])
    }

    override fun getItemCount(): Int =
        otherDetailItem.size
}