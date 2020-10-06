package com.example.walletapp.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.walletapp.data.database.entity.Payment

@Dao
interface PaymentDao {
    @Query("SELECT * FROM payment")
    fun getPayments() : LiveData<List<Payment>>
}