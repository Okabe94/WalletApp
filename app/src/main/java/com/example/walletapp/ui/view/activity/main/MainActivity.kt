package com.example.walletapp.ui.view.activity.main

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.walletapp.R
import com.example.walletapp.data.database.entity.Category
import com.example.walletapp.ui.viewmodel.category.CategoryViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}