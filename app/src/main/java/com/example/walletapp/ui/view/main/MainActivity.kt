package com.example.walletapp.ui.view.main

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.walletapp.R
import com.example.walletapp.data.database.entity.Category
import com.example.walletapp.ui.viewmodel.CategoryViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val categoryViewModel : CategoryViewModel by viewModels()
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        categoryViewModel.categories.observe(this) { text.text = it.toString() }

        button.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        categoryViewModel.insert(Category("Hola $counter"))
        counter++
    }
}