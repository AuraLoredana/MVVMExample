package com.example.mvvmexample.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {
    private val quoteList = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList
    }

    fun addQuote(quote: Quote) {
        quoteList.add(quote)
        quotes.value = quoteList
    }

    fun getQuotes() = quotes as LiveData<List<Quote>>

    fun removeQuote(quote: Quote) {
        quoteList.remove(quote)
        quotes.value = quoteList
    }

    fun deleteAll(){
        quoteList.removeAll(quoteList)
        quotes.value = quoteList
    }
}