package com.example.walletapp.utils.pager

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource

abstract class PagingSourceProvider {

    companion object {
        private val pagerConfig = PagingConfig(
            pageSize = 5,
            initialLoadSize = 5,
            enablePlaceholders = false
        )

        fun <T : Any> get(pagingSource: PagingSource<Int, T>) =
            Pager(pagerConfig) { pagingSource }.flow
    }
}