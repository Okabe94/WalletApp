package com.example.walletapp.repository

import com.example.walletapp.database.dao.CategoryDao
import com.example.walletapp.database.entity.Category

class CategoryRepository(private val categoryDao: CategoryDao) {

    val liveCategories = categoryDao.getCategories()

    suspend fun insert(category: Category) {
        categoryDao.insert(category)
    }
}