package com.example.walletapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.walletapp.R
import com.example.walletapp.data.database.entity.Category
import kotlinx.android.synthetic.main.category_list_item.view.*

class CategoryAdapter(
    private val listener: (Int) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private val categoryList = mutableListOf<Category>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.category_list_item, parent, false)
        return ViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categoryList[position]
        holder.apply {
            tvName.text = category.name
            tvDate.text = category.date.toString()
            tvDescription.text = category.description
        }
    }

    override fun getItemCount(): Int = categoryList.size

    fun updateList(newList: List<Category>) {
        categoryList.apply {
            clear()
            addAll(newList)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View, listener: (Int) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.tvName
        val tvDate = itemView.tvDate
        val tvDescription = itemView.tvDescription

        init {
            itemView.setOnClickListener { listener(adapterPosition) }
        }
    }
}