package com.example.walletapp.data.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.walletapp.data.database.entity.Category

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category")
    fun getPagedCategories() : PagingSource<Int, Category>

    @Query("SELECT * FROM Category WHERE CategoryName LIKE '%' || :filter || '%'")
    fun getFilteredPagedCategories(filter: String) : PagingSource<Int, Category>

    @Insert
    suspend fun insert(category: Category)

}