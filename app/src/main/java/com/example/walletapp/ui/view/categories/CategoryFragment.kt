package com.example.walletapp.ui.view.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.walletapp.R
import com.example.walletapp.data.database.entity.Category
import com.example.walletapp.ui.utlis.adapters.CategoryAdapter
import com.example.walletapp.ui.viewmodel.CategoryViewModel
import kotlinx.android.synthetic.main.fragment_categories.*

class CategoryFragment : Fragment() {

    var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel : CategoryViewModel by activityViewModels()

        val categoryAdapter = CategoryAdapter()
        rvCategories.apply {
            adapter = categoryAdapter
            layoutManager = LinearLayoutManager(context)
        }
        viewModel.categories.observe(viewLifecycleOwner) { categoryAdapter.updateList(it) }

        add.setOnClickListener {
            counter++
            viewModel.insert(Category("Hola $counter"))
        }
    }
}