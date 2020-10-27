package com.example.walletapp.data.repository

import com.example.walletapp.data.database.dao.CategoryDao
import com.example.walletapp.data.database.entity.Category

class CategoryRepository(private val categoryDao: CategoryDao) {

    fun getPagedCategories() = categoryDao.getPagedCategories()

    suspend fun insert(category: Category) {
        categoryDao.insert(category)
    }

}