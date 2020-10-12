package com.example.walletapp.ui.view.fragment.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.walletapp.R
import com.example.walletapp.data.database.entity.Category
import com.example.walletapp.ui.adapter.CategoryAdapter
import com.example.walletapp.ui.viewmodel.category.CategoryViewModel
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : Fragment(), View.OnClickListener {

    private var counter = 0
    private val categoryViewModel: CategoryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAdd.setOnClickListener(this)
        val adapter = CategoryAdapter(::click)
        rvCategories.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(this@CategoryFragment.context)
        }
        categoryViewModel.categories.observe(viewLifecycleOwner) {
            adapter.updateList(it)
        }
    }

    override fun onClick(v: View?) {
        categoryViewModel.insert(Category("HOLA ${++counter}"))
    }

    fun click(position: Int) {
        categoryViewModel.categories.value?.get(position)?.name.let {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
    }
}