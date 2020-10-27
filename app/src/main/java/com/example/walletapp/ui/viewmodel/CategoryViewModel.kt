package com.example.walletapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.filter
import androidx.paging.map
import com.example.walletapp.data.database.db.WalletDatabase
import com.example.walletapp.data.database.entity.Category
import com.example.walletapp.data.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class CategoryViewModel(application: Application) : AndroidViewModel(application) {

    private val categoryRepository =
        CategoryRepository(WalletDatabase.getInstance(application).categoryDao())

    private val pagerConfig = PagingConfig(
        pageSize = 5,
        initialLoadSize = 5,
        enablePlaceholders = false
    )

    val categoryPager = Pager(pagerConfig) {
        categoryRepository.getPagedCategories()
    }.flow

    fun insert(category: Category) = viewModelScope.launch(Dispatchers.IO) {
        categoryRepository.insert(category)
    }

    fun filter(word: String) = categoryPager.map { list ->
        list.filter { it.name.contains(word, true) }
    }
}