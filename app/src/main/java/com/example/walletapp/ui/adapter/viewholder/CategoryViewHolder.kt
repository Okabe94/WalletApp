package com.example.walletapp.ui.adapter.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.walletapp.R
import com.example.walletapp.data.database.entity.Category
import kotlinx.android.synthetic.main.list_item_category.view.*

class CategoryViewHolder private constructor(
    itemView: View,
    private val listener: (Int) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private val tvName: TextView = itemView.tvCategoryName
    private val tvDate: TextView = itemView.tvCategoryDate

    init {
        itemView.setOnClickListener { listener(bindingAdapterPosition) }
    }

    companion object {
        fun create(parent: ViewGroup, listener: (Int) -> Unit): CategoryViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_category, parent, false)
            return CategoryViewHolder(view, listener)
        }
    }

    fun bind(category: Category?) {
        category?.let {
            tvName.text = it.name
            tvDate.text = it.date.toString()
        }
    }
}