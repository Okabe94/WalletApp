package com.example.walletapp.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import com.example.walletapp.data.database.dao.CategoryDao
import com.example.walletapp.data.database.entity.Category

class CategoryRepository(private val categoryDao: CategoryDao) {

    fun getCategories(filter: String? = null) : LiveData<List<Category>> {
        return if (filter == null) categoryDao.getCategories()
        else categoryDao.getFilteredCategories(filter)
    }

    suspend fun insert(category: Category) {
        categoryDao.insert(category)
    }

}