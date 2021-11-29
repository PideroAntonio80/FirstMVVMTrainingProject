package com.example.firstmvvmtrainingproject.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.firstmvvmtrainingproject.databinding.ActivityMainBinding
import com.example.firstmvvmtrainingproject.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            Glide.with(this).load(currentQuote.image).into(binding.ivPicture)
            binding.tvTitle.text =currentQuote.quote
            binding.tvAuthor.text =currentQuote.author
        })

        quoteViewModel.isLoading.observe(this, Observer {
            binding.pbProgress.isVisible = it
        })

        binding.llContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }
}

// https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/.json
// https://api.punkapi.com/v2/beers