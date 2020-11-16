package com.example.walletapp.ui.view.fragment.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.walletapp.R
import com.example.walletapp.data.database.entity.Category
import com.example.walletapp.ui.adapter.CategoryAdapter
import com.example.walletapp.ui.viewmodel.CategoryViewModel
import com.example.walletapp.utils.querylistener.QueryListenerImpl
import kotlinx.android.synthetic.main.fragment_categories.*

class CategoryFragment : Fragment() {

    var counter = 0
    private val categoryAdapter = CategoryAdapter()
    private val viewModel: CategoryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        viewModel.liveCategories.observe(viewLifecycleOwner) { list ->
            list?.let {
                categoryAdapter.updateList(it)
                displayEmptyState(it.isEmpty())
            }
        }
    }

    private fun setupListeners() {
        rvCategories.apply {
            adapter = categoryAdapter
            layoutManager = LinearLayoutManager(context)
        }

        svFilter.setOnQueryTextListener(object : QueryListenerImpl() {
            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.filter(newText)
                return true
            }
        })

        add.setOnClickListener {
            counter++
            viewModel.insert(Category("Perito $counter"))
        }
    }

    private fun displayEmptyState(show: Boolean) {
        llEmpty.visibility = if (show) View.VISIBLE else View.GONE
    }

}