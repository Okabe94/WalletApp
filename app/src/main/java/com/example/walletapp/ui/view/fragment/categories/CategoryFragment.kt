package com.example.walletapp.ui.view.fragment.categories

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.walletapp.R
import com.example.walletapp.data.database.entity.Category
import com.example.walletapp.ui.adapter.CategoryAdapter
import com.example.walletapp.ui.viewmodel.CategoryViewModel
import com.example.walletapp.utils.textwatcher.TextWatcherImpl
import kotlinx.android.synthetic.main.fragment_categories.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

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

        tvEdit.addTextChangedListener(object : TextWatcherImpl() {
            override fun afterTextChanged(s: Editable?) {
                s?.toString()?.let { word -> updateList(viewModel.updateList(word)) }
            }
        })

        rvCategories.apply {
            adapter = categoryAdapter
            layoutManager = LinearLayoutManager(context)
        }

        add.setOnClickListener {
            counter++
            viewModel.insert(Category("Perito $counter"))
        }

        updateList(viewModel.updateList())
    }

    private fun updateList(categoryFlow: Flow<PagingData<Category>>) {
        lifecycleScope.launch {
            categoryFlow.collectLatest { categoryAdapter.submitData(it) }
        }
    }

}