package com.example.walletapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.walletapp.database.entity.Category

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category")
    fun getCategories() : LiveData<List<Category>>

    @Insert
    fun insert(category: Category)

}