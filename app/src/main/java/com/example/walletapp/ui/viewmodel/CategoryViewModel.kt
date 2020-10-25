package com.example.walletapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.walletapp.data.database.db.WalletDatabase
import com.example.walletapp.data.database.entity.Category
import com.example.walletapp.data.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CategoryRepository(WalletDatabase.getInstance(application).categoryDao())
    val categories: LiveData<List<Category>> = repository.liveCategories

    fun insert(category: Category) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(category)
    }
}