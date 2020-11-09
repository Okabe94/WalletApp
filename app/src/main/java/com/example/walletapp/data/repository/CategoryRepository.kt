package com.example.walletapp.data.repository

import androidx.paging.PagingSource
import com.example.walletapp.data.database.dao.CategoryDao
import com.example.walletapp.data.database.entity.Category

class CategoryRepository(private val categoryDao: CategoryDao) {

    fun getPagedCategories(filter: String? = null) : PagingSource<Int, Category> {
        return if (filter == null) categoryDao.getPagedCategories()
        else categoryDao.getFilteredPagedCategories(filter)
    }

    suspend fun insert(category: Category) {
        categoryDao.insert(category)
    }

}