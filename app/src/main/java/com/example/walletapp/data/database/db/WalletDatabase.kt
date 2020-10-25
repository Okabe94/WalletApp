package com.example.walletapp.data.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.walletapp.data.database.converter.Converters
import com.example.walletapp.data.database.dao.CategoryDao
import com.example.walletapp.data.database.dao.PaymentDao
import com.example.walletapp.data.database.entity.Category
import com.example.walletapp.data.database.entity.Payment

private const val DATABASE_NAME = "Database"

@Database(entities = [Payment::class, Category::class], version = 1)
@TypeConverters(Converters::class)
abstract class WalletDatabase : RoomDatabase() {

    abstract fun paymentDao(): PaymentDao
    abstract fun categoryDao(): CategoryDao

    companion object {
        private var INSTANCE: WalletDatabase? = null

        fun getInstance(context: Context): WalletDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    WalletDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE as WalletDatabase
        }
    }
}