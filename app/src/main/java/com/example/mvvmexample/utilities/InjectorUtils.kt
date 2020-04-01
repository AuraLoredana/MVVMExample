package com.example.mvvmexample.utilities

import com.example.mvvmexample.data.FakeDataBase
import com.example.mvvmexample.data.QuoteRepository
import com.example.mvvmexample.ui.QuotesViewModelFactory

object InjectorUtils {
    // This will be called from QuotesActivity
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        // ViewModelFactory needs a repository, which in turn needs a DAO from a database
        // The whole dependency tree is constructed right here, in one place
        val quoteRepository = QuoteRepository.getInstance(FakeDataBase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}