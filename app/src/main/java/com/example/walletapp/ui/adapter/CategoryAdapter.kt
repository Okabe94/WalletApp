package com.example.walletapp.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.walletapp.data.database.entity.Category
import com.example.walletapp.ui.adapter.viewholder.CategoryViewHolder

class CategoryAdapter : RecyclerView.Adapter<CategoryViewHolder>() {

    private val list = mutableListOf<Category>()

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder.create(parent)
    }

    fun updateList(newList: List<Category>) {
        list.apply {
            clear()
            addAll(newList)
        }
        notifyDataSetChanged()
    }

}