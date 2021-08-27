package com.wahyu.starwars.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wahyu.starwars.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentTitle = intent.getStringExtra("title")
        val intentDescription = intent.getStringExtra("description")

        if (!intentDescription.isNullOrEmpty() && !intentTitle.isNullOrEmpty()) {
            binding.txtTitle.text = intentTitle
            binding.description.text = intentDescription
        }

        binding.imgBack.setOnClickListener { onBackPressed() }
    }
}