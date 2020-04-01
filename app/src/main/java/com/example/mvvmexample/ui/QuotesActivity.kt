package com.example.mvvmexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmexample.R
import com.example.mvvmexample.data.Quote
import com.example.mvvmexample.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initUI()
    }

    private fun initUI() {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory).get(QuotesViewModel::class.java)
        viewModel.getQuotes().observe(
            this, Observer { quote ->
                val stringBuilder = StringBuilder()
                stringBuilder.append("$quote\n\n")
                textView_quotes.text = stringBuilder.toString()
            }
        )
        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
        button_remove_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.removeQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
        button_delete_all.setOnClickListener {
            viewModel.deleteAll()
        }
    }
}
