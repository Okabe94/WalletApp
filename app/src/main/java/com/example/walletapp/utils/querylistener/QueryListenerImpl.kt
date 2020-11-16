package com.example.walletapp.utils.querylistener

import androidx.appcompat.widget.SearchView

abstract class QueryListenerImpl : SearchView.OnQueryTextListener {
    override fun onQueryTextSubmit(query: String?) = false
    override fun onQueryTextChange(newText: String?) = false
}