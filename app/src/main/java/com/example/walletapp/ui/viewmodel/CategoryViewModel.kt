package com.example.walletapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.walletapp.data.database.db.WalletDatabase
import com.example.walletapp.data.database.entity.Category
import com.example.walletapp.data.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryViewModel(application: Application) : AndroidViewModel(application) {

    private val db = WalletDatabase.getInstance(application)
    private val categoryRepository = CategoryRepository(db.categoryDao())

    private val query = MutableLiveData("")
    val liveCategories: LiveData<List<Category>> =
        Transformations.switchMap(query) { word -> categoryRepository.getCategories(word) }

    fun filter(word: String? = null) {
        query.value = word
    }

    fun insert(category: Category) = viewModelScope.launch(Dispatchers.IO) {
        categoryRepository.insert(category)
    }
}