package com.example.walletapp.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Category")
data class Category(
    @ColumnInfo(name = "CategoryName")
    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "CategoryId")
    var id: Int = 0
    var date: Date = Date()
}