package com.example.walletapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.walletapp.database.entity.Payment

@Dao
interface PaymentDao {
    @Query("SELECT * FROM payment")
    fun getPayments() : LiveData<List<Payment>>
}