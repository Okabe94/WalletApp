package com.example.walletapp.data.repository.category

import com.example.walletapp.data.database.dao.CategoryDao
import com.example.walletapp.data.database.entity.Category

class CategoryRepository(private val categoryDao: CategoryDao) {

    val liveCategories = categoryDao.getCategories()

    suspend fun insert(category: Category) {
        categoryDao.insert(category)
    }
}