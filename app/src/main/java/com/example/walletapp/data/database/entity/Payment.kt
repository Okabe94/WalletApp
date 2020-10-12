package com.example.walletapp.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Payment")
data class Payment(
    @ColumnInfo(name = "CategoryId") val category: Int,
    @ColumnInfo(name = "PaymentName") val name: String,
    @ColumnInfo(name = "PaymentAmount") val amount: Float,
    @ColumnInfo(name = "IsRecurrent") val recurrent: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "PaymentId") var id: Int = 0
    @ColumnInfo(name = "CreatedAt") var date: Date = Date()
}