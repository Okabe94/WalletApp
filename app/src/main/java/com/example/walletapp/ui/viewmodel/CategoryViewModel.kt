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
import com.example.walletapp.utils.pager.PagingSourceProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class CategoryViewModel(application: Application) : AndroidViewModel(application) {

    private val categoryRepository =
        CategoryRepository(WalletDatabase.getInstance(application).categoryDao())

    fun updateList(word: String? = null) =
        PagingSourceProvider.get(categoryRepository.getPagedCategories(word))

    fun insert(category: Category) = viewModelScope.launch(Dispatchers.IO) {
        categoryRepository.insert(category)
    }
}