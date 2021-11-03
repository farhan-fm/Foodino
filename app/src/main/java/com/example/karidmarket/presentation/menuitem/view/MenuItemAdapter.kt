package com.example.karidmarket.presentation.menuitem.view

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
import com.example.karidmarket.presentation.menuitem.model.MenuItemResponcesModel
import com.example.karidmarket.presentation.recipes.model.OtherDetailModel
import com.example.karidmarket.presentation.recipes.view.RecipeAdapter

class MenuItemAdapter(private val context: Context) :
    RecyclerView.Adapter<MenuItemAdapter.ViewHolder>() {

    private val items = ArrayList<MenuItemResponcesModel>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var menuItemImage: ImageView = itemView.findViewById(R.id.menuItemFragmentImage)
        var menuItemTitle: TextView = itemView.findViewById(R.id.menuItemFragmentTitle)
        var menuItemResturanChain: TextView =
            itemView.findViewById(R.id.menuItemFragmentRestaurantChain)
        var menuItemPrice: TextView = itemView.findViewById(R.id.menuItemFragmentPrice)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun bindViewHolder(holder: ViewHolder, menuItemResponcesModel: MenuItemResponcesModel) {
        if (menuItemResponcesModel.title.equals(null))
            holder.menuItemTitle.text = "-"
        else
            holder.menuItemTitle.text = menuItemResponcesModel.title

        if (menuItemResponcesModel.restaurantChain.equals(null))
            holder.menuItemResturanChain.text =  "-"
        else
            holder.menuItemResturanChain.text = menuItemResponcesModel.restaurantChain

        if (menuItemResponcesModel.price.toString().equals(null))
            holder.menuItemResturanChain.text =  "-"
        else
            holder.menuItemPrice.text = menuItemResponcesModel.price.toString()

        var posterURL : String ? =null
        menuItemResponcesModel.images?.forEach { i ->
            if (!i.equals(null)){
                posterURL = i
                Glide.with(context)
                    .load(posterURL)
                    .into(holder.menuItemImage)
            }else{
                holder.menuItemImage.setImageDrawable(context.resources.getDrawable(R.drawable.ic_image_not_loaded))
            }
        }
        //val posterURL = menuItemResponcesModel.images?.get(0)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_menu_item_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        bindViewHolder(holder, items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setItems(items: MenuItemResponcesModel) {
        this.items.clear()
        addItems(items)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(items: MenuItemResponcesModel) {
        this.items.addAll(listOf(items))
        notifyDataSetChanged()
    }

}