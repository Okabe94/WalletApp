package com.example.walletapp.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Category")
data class Category(
    @ColumnInfo(name = "CategoryName")
    val name: String,
    @ColumnInfo(name = "CategoryDescription")
    val description: String = ""
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "CategoryId")
    var id: Int = 0
}