package com.example.walletapp.ui.adapter

import android.util.Log
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.walletapp.data.database.entity.Category
import com.example.walletapp.ui.adapter.viewholder.CategoryViewHolder

class CategoryAdapter : PagingDataAdapter<Category, CategoryViewHolder>(COMPARATOR) {

    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<Category>() {
            override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean =
                oldItem.id == newItem.id
        }
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder.create(parent, ::listener)
    }

    private fun listener(position: Int) {
        getItem(position)?.name?.let { Log.d("Position", it) }
    }
}