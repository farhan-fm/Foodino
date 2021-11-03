package com.example.karidmarket.presentation.generatemeal.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.karidmarket.R
import com.example.karidmarket.presentation.generatemeal.model.MealModel
import com.example.karidmarket.presentation.recipes.model.OtherDetailModel
import com.example.karidmarket.presentation.recipes.view.RecipeAdapter

class GenerateMealPlanAdapter(val context: Context ) : RecyclerView.Adapter<GenerateMealPlanAdapter.ViewHolder>() {

    private val items = ArrayList<MealModel>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mealTitle = itemView.findViewById<TextView>(R.id.mealTitle)
        val mealReadyInMinutes = itemView.findViewById<TextView>(R.id.mealReadyInMinutes)
        val mealServings = itemView.findViewById<TextView>(R.id.mealServings)
        val mealUrlText = itemView.findViewById<TextView>(R.id.mealUrlText)
        val mealUrl = itemView.findViewById<ImageButton>(R.id.mealUrl)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_meal_plan_card, parent, false)
        return ViewHolder(view)
    }

    private fun bindViewHolder(holder:ViewHolder, mealPlan: MealModel) {
        holder.mealTitle.text = mealPlan.title
        holder.mealReadyInMinutes.text=mealPlan.readyInMinutes.toString()
        holder.mealServings.text=mealPlan.servings.toString()
        holder.mealUrlText.text =mealPlan.sourceUrl

        holder.mealUrl.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(mealPlan.sourceUrl)
            context.startActivity(intent)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        bindViewHolder(holder, items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setItems(item: MealModel) {
        if (items.size == 3)
            this.items.clear()
        addItems(item)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(items: MealModel) {
        this.items.addAll(listOf(items))
        notifyDataSetChanged()
    }
}