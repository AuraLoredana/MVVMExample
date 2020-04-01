package com.example.mvvmexample.ui

import androidx.lifecycle.ViewModel
import com.example.mvvmexample.data.Quote
import com.example.mvvmexample.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {
    fun getQuotes() = quoteRepository.getQuotes()
    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
    fun removeQuote(quote: Quote) = quoteRepository.removeQuote(quote)
    fun deleteAll() = quoteRepository.deleteAll()
}