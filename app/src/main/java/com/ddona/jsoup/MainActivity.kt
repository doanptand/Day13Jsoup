package com.ddona.jsoup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.ddona.jsoup.databinding.ActivityMainBinding
import com.ddona.jsoup.parser.StackOverFlowParser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launch(Dispatchers.IO) {
            val question = StackOverFlowParser.parserQuestion("Jetpack")
            Log.d("doanpt", "Get question size is ${question.size}")
        }
    }
}