package com.example.walletapp.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Category")
data class Category(
    @ColumnInfo(name = "CategoryName") val name: String,
    @ColumnInfo(name = "CategoryDescription") val description: String = "Sin descripción"
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "CategoryId") var id: Int = 0
    @ColumnInfo(name = "CreatedAt") var date: Date = Date()
}